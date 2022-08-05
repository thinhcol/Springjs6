package com.PS18524;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.PS18524.interceptor.GobalInter;
@Configuration
public class Interceptor implements WebMvcConfigurer{
	@Autowired
	GobalInter inter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(inter).addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/admin/**","/images/**");
	}
}
