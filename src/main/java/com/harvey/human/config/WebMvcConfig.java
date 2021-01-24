package com.harvey.human.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@SuppressWarnings("serial")
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> excludePaths = new ArrayList<String>() {
			{
				add("/js/**");
				add("/"); // 首页
				add("/user/login"); // 登录
			}
		};
		registry.addInterceptor(new ValidateTokenInterceptor()).addPathPatterns("/**")
				.excludePathPatterns(excludePaths);
	}
}
