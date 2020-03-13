package com.mysite.work.health;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.work.health.service.HealthService;
import com.mysite.work.health.vo.HealthCheckVO;

@RestController
public class HealthCheckController {
	
	Logger logger = LoggerFactory.getLogger(HealthCheckController.class);
	@Inject
	private HealthService healthService;

	@GetMapping(value = "/health/info")
	public String health(HttpServletRequest request) throws Exception {

		String serviceCode = "200";
		String returnJson = "";
		HealthCheckVO vo = new HealthCheckVO();

		try {

			InetAddress ids = HealthCheckController.getLocalHost();

			vo.setHostName(ids.getHostName());
			vo.setIp(ids.getHostAddress());
			vo.setUrl(request.getRequestURI());
			vo.setPort(String.valueOf(request.getServerPort()));

		} catch (Exception e) {
			logger.error("returnJson : {}", returnJson);
			vo.setMessage(e.getMessage());
		} finally {
			vo.setAliveYn("Y");
			vo.setServiceCode(serviceCode);
		}
		ObjectMapper mapper = new ObjectMapper();
		returnJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);

		logger.debug("returnJson : {}", returnJson);

		return returnJson;
	}
	
	@GetMapping(value = "/health/database")
	public String healthDataBase(HttpServletRequest request) throws Exception {

		String serviceCode = "200";
		String returnJson = "";
		HealthCheckVO vo = new HealthCheckVO();

		try {

			InetAddress ids = HealthCheckController.getLocalHost();

			vo.setHostName(ids.getHostName());
			vo.setIp(ids.getHostAddress());
			vo.setUrl(request.getRequestURI());
			vo.setPort(String.valueOf(request.getServerPort()));			
			vo.setDbCnt(healthService.getDatabaseHealth().getDbCnt());

		} catch (Exception e) {
			logger.error("returnJson : {}", returnJson);
			vo.setMessage(e.getMessage());
		} finally {
			vo.setAliveYn("Y");
			vo.setServiceCode(serviceCode);
		}
		ObjectMapper mapper = new ObjectMapper();
		returnJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vo);

		logger.debug("returnJson : {}", returnJson);

		return returnJson;
	}

	@GetMapping(value = "/health/service")
	@ResponseBody
	public String healthService(HttpServletRequest request) throws Exception {
		return "200";
	}

	public static String getLocalHostName() throws UnknownHostException {

		return InetAddress.getLocalHost().getHostName();
	}

	public static InetAddress getLocalHost() throws UnknownHostException {

		return InetAddress.getLocalHost();
	}

}