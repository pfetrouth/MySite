package com.mysite.work.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(HeaderFilter.class);
	
	public HeaderFilter(){
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		 Enumeration<String> headerNames = req.getHeaderNames();
		 logger.debug("HeaderFilter-----------START-----uri :{}", uri);
         
	        while(headerNames.hasMoreElements()) {
	            String name = (String)headerNames.nextElement();
	            String value = req.getHeader(name);
	         //   logger.debug(name + " : " + value );
	        }
	     logger.debug("WebTocken :{}", req.getHeader("WebTocken"));	     
	     logger.debug("HeaderFilter-----------END-----------------");

		 chain.doFilter(req, res);


	}

}
