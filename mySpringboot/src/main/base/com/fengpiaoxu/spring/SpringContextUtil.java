package com.fengpiaoxu.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.fengpiaoxu.Application;

/**
 * 得到上下文对象，手动获取bean
 * @author hezhiyuan
 *
 */
public class SpringContextUtil {
	
	private static Logger log = LoggerFactory.getLogger(SpringContextUtil.class) ;

	private static ApplicationContext applicationContext = null ;
	
	/*
	 * 得到上下文对象
	 */
	public static ApplicationContext getApplicationContext(){
		return applicationContext ;
	}
	
	/*
	 * 设置上下文对象
	 */
	public static void setApplicationContext(ApplicationContext applicationContext){
		SpringContextUtil.applicationContext = applicationContext ;
		log.info("设置上下文对象");
	}
	
	//通过名字获取上下文中的bean  
    public static Object getBean(String name){  
    	log.info("手动获取bean"+name);
        return applicationContext.getBean(name);  
    }  
      
    //通过类型获取上下文中的bean  
    public static Object getBean(Class<?> requiredType){  
    	log.info("手动获取bean"+requiredType);
        return applicationContext.getBean(requiredType);  
    }  
}
