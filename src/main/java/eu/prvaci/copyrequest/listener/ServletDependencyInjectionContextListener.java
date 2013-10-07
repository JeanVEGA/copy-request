package eu.prvaci.copyrequest.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletDependencyInjectionContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

}
