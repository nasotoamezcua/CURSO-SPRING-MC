package com.mitocode;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import com.mitocode.util.SimpleCORSFilter;

@Configuration
public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		FilterRegistration corsFilterReg = servletContext.addFilter("simpleCORSFilter", SimpleCORSFilter.class);
		corsFilterReg.addMappingForUrlPatterns(null, false, "/*");
	}

}
