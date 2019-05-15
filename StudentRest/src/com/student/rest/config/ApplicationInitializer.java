package com.student.rest.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servlet) throws ServletException {
		
		AnnotationConfigWebApplicationContext config = new AnnotationConfigWebApplicationContext();
		config.setServletContext(servlet);
		config.register(RestSpringConfig.class);
		ServletRegistration.Dynamic servletDyamic =servlet.addServlet("dispatcherServlet", new DispatcherServlet(config)); 
		servletDyamic.setLoadOnStartup(1);
		servletDyamic.addMapping("/");
	}
	
	
}
