package com.mysite.work.configuration;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mysite.work.filter.CORSFilter;

@Configuration
public class FilterConfiguration implements WebMvcConfigurer {
	
	@Bean
	public FilterRegistrationBean<CORSFilter> getFilterRegistrationBean() {
		FilterRegistrationBean<CORSFilter> registrationBean = new FilterRegistrationBean<CORSFilter>(new CORSFilter());
				registrationBean.setOrder(Integer.MIN_VALUE);
		//registrationBean.addUrlPatterns("/*");
		registrationBean.setUrlPatterns(Arrays.asList("/*"));
		return registrationBean;
	}
}