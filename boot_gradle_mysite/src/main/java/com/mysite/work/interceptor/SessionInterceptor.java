package com.mysite.work.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mysite.work.user.vo.UserVO;
import com.mysite.work.util.jwt.JwtServiceUtil;

public class SessionInterceptor implements HandlerInterceptor  {
	
	Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
//	@Autowired
//    RedisTemplate<String, Object> redisTemplate;
	RedisTemplate<String, Object> redisTemplate =null;

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("###Interceptor > preHandle");
		logger.debug("###SessionInterceptor URL : {}",request.getRequestURI());
		boolean isValid=false;
		
		JwtServiceUtil jwt = new JwtServiceUtil();	
		
		final String webTocken = request.getHeader("WebTocken");
		logger.debug("###WebTocken :{}",webTocken);

		if(webTocken != null && jwt.checkJwt(webTocken)){
			isValid=true;
		}else{
			isValid=false;
		}

		 
		if(!isValid){
			response.sendRedirect("/login/login");
			return false;
			 
		 } 
		return true;
    }
	
//	@Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		logger.info("Interceptor > preHandle");
//		logger.debug("###SessionInterceptor URL : {}",request.getRequestURI());
//		boolean isValid=false;
//		
//		JwtServiceUtil jwt = new JwtServiceUtil();			
//
//		Cookie[] cookies = request.getCookies();
//		 if (cookies != null) {
//		      for (Cookie cookie : cookies) {
//		    	  logger.debug("cookie :{} = {}",cookie.getName(),cookie.getValue());
//		    	  if(cookie.getName().equals("GUIDSESSIONUID")) {
//		    		  String key=cookie.getValue();		
//		    		  logger.debug("key :{}  ",key);
//		    		  if(key!=null&&key!="") {
//						if (jwt.checkJwt(key)) {
//							isValid = true;
//						}
//		    	     }
//		         }
//		      }
//		 }
//		if(!isValid){
//			response.sendRedirect("/login/login");
//			return false;
//			 
//		 } 
//		return true;
//    }
	/*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("Interceptor > preHandle");
		logger.debug("###SessionInterceptor URL : {}",request.getRequestURI());
		//boolean isValid=false;
		boolean isValid=true;
		Cookie[] cookies = request.getCookies();
		 if (cookies != null) {
		      for (Cookie cookie : cookies) {
		    	  logger.debug("cookie :{} = {}",cookie.getName(),cookie.getValue());
		    	  if(cookie.getName().equals("GUIDSESSIONUID")) {
		    		  String key=cookie.getValue();		
		    		  logger.debug("key :{}  ",key);
		    		  logger.debug("redisTemplate :{}  ",redisTemplate);
		    		  if(key!=null&&key!="") {
		    			  Object obj= null;
		    			  if(redisTemplate!=null) {
		    				  obj= redisTemplate.opsForValue().get(key);
				    		  logger.debug("obj :{}  ",obj);	
			    			  if(obj!=null) {					    				  
			    				  UserVO userVO = (UserVO)obj;
			    				  logger.debug("userVO :{}  ",userVO);			   
			    				  if(key.equals(userVO.getSerialVersionUID())) {
			    					  isValid =true;
			    				  }
			    			  }
		    			  }
		    	     }
		         }
		      }
		 }
		if(!isValid){
			response.sendRedirect("/login/login");
			return false;
			 
		 } 
		return true;
    }*/

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	logger.info("Interceptor > postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
    	logger.info("Interceptor > afterCompletion" );
    }
}
