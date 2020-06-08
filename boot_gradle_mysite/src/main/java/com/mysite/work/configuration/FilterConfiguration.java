package com.mysite.work.configuration;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mysite.work.filter.CORSFilter;
import com.mysite.work.filter.HeaderFilter;

@Configuration
public class FilterConfiguration implements WebMvcConfigurer {
	
	@Bean
	public FilterRegistrationBean<CORSFilter> getFilterCORSRegistrationBean() {
		FilterRegistrationBean<CORSFilter> registrationBean = new FilterRegistrationBean<CORSFilter>(new CORSFilter());
		registrationBean.setOrder(Integer.MIN_VALUE);
		//registrationBean.addUrlPatterns("/*");
		registrationBean.setUrlPatterns(Arrays.asList("/*"));
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean<HeaderFilter> getFilterHeaderRegistrationBean() {
		FilterRegistrationBean<HeaderFilter> registrationBean = new FilterRegistrationBean<HeaderFilter>(new HeaderFilter());
		registrationBean.setOrder(Integer.MIN_VALUE);
		//registrationBean.addUrlPatterns("/*");
		registrationBean.setUrlPatterns(Arrays.asList("/*"));
		return registrationBean;
	}
}