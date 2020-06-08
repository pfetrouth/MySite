package com.mysite.work.login;

import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.work.login.service.impl.LogInService;
import com.mysite.work.login.vo.LogInVO;
import com.mysite.work.user.vo.UserVO;
import com.mysite.work.util.jwt.JwtServiceUtil; 

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//@Autowired
    //RedisTemplate<String, Object> redisTemplate;
	
	@Inject
	private LogInService logInService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model, HttpServletResponse response) throws Exception {
		model.addAttribute("logInVO", new LogInVO());
//		String serialVersionUID = UUID.randomUUID().toString();
//		Cookie cookieM = new Cookie("GUIDSESSIONUID",serialVersionUID);
//		response.addCookie(cookieM);
		
		return "login/login";
	}

	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		model.addAttribute("userVO", new UserVO());
		return "/login/signupForm";
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public void doLogin(@ModelAttribute("LogInVO") LogInVO logInVO, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String serialVersionUID = UUID.randomUUID().toString();
		String serialVersionUID ="";
		UserVO userVO = logInService.getUserInfo(logInVO);
		logger.debug("userVO : {}",userVO);
		if(userVO==null) {
			response.sendRedirect("/login/login");
		}else {		
			JwtServiceUtil jwt = new JwtServiceUtil();			
			serialVersionUID =jwt.makeJwt(request, userVO);
			
			logger.debug("jwt tocken   :{}", serialVersionUID);
			
//			userVO.setSerialVersionUID(serialVersionUID);
//			redisTemplate.opsForValue().set(serialVersionUID, userVO);
			Cookie cookieM = new Cookie("GUIDSESSIONUID",serialVersionUID);
			cookieM.setPath("/");
//			response.addCookie(cookieM);
//			request.setAttribute("serialVersionUID",serialVersionUID);
			response.setHeader("WebTocken", serialVersionUID);

			response.sendRedirect("/board/getBoardList");
		}
	}
}
