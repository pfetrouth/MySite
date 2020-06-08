package com.mysite.work.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mysite.work.interceptor.SessionInterceptor;

@Configuration
public class SessionInterceptorConfig extends WebMvcConfigurerAdapter      {
	
   @Bean
   public SessionInterceptor SessionInterceptor() {
	   return new SessionInterceptor();
   }
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	        //registry.addInterceptor(new SessionInterceptor())
			registry.addInterceptor(SessionInterceptor())
	                .addPathPatterns("/**")
	                .excludePathPatterns("/resources/*")
	                .excludePathPatterns("/login/login") //로그인 쪽은 예외처리를 한다.
			        .excludePathPatterns("/login/doLogin") //로그인 쪽은 예외처리를 한다.
			        .excludePathPatterns("/board/getBoardList"); //로그인 쪽은 예외처리를 한다.
	    }

}
