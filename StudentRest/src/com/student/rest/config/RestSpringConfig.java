package com.student.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.student.rest")
@PropertySources(@PropertySource("classpath:message.properties")) 
public class RestSpringConfig extends WebMvcConfigurerAdapter {

	
	
	@Bean
	public ViewResolver viewresolver(){
		
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setViewClass(JstlView.class);
		r.setPrefix("/WEB-INF/pages/");
		r.setSuffix("/");
		return r;
	}
	
	
}
