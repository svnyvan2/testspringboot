package com.fengpiaoxu.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * session监听
 * @author hezhiyuan
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener,ServletContextListener{

	private static Logger log = LoggerFactory.getLogger(SessionListener.class) ;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		log.info("创建session");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		log.info("销毁session");		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("容器销毁");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("容器初始化");
		
	}

}
