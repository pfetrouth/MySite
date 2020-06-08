package com.mysite.work.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.mysite.work.user.vo.UserVO;

public class CORSFilter implements Filter {

	Logger logger = LoggerFactory.getLogger(CORSFilter.class);

	private List<String> whiteList;
	private List<String> resourceList;
	private boolean filterYn = true;
	
	@Autowired
    RedisTemplate<String, Object> redisTemplate;

	public CORSFilter() {

		whiteList = new ArrayList<String>();
		// whiteList.add("/");
		whiteList.add("/loginMain");
		whiteList.add("/user/loginPost");
		whiteList.add("/login/login");
		whiteList.add("/login/doLogin");
		whiteList.add("/board/getBoardList");
		whiteList.add("/health");

		resourceList = new ArrayList<String>();
		resourceList.add("/resources");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init CORSFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		boolean isURIResouceFile = false;

		String uri = req.getRequestURI();
		logger.debug("###CORSFilter URL : {}",uri);

		if (filterYn) {

			if (!whiteList.contains(uri)) {

				for (String resouce : resourceList) {

					logger.debug("resouce :" + resouce);

					if (uri.startsWith(resouce)) {
						isURIResouceFile = true;
						break;
					}
				}
				logger.debug("isURIResouceFile :" + isURIResouceFile);
				if(isURIResouceFile) { return;}
			}

		}
		logger.info("##### filter - before #####");
		chain.doFilter(req, res);
		logger.info("##### filter - after #####");
	}

	@Override
	public void destroy() {
		logger.info("destroy CORSFilter");
	}

}
