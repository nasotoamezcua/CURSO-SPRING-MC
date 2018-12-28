package com.mitocode.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	// implements WebApplicationInitializer {
	// Override
	/*
	 * public void onStartup(ServletContext container) throws ServletException {
	 * 
	 * AnnotationConfigWebApplicationContext ctx = new
	 * AnnotationConfigWebApplicationContext(); ctx.register(AppConfig.class);
	 * ctx.setServletContext(container);
	 * 
	 * ServletRegistration.Dynamic servlet = container.addServlet("dispatcher",
	 * new DispatcherServlet(ctx));
	 * 
	 * servlet.setLoadOnStartup(1); servlet.addMapping("/");
	 */

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
