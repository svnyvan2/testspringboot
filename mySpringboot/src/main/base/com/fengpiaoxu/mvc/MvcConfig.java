package com.fengpiaoxu.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc //开启mv配置
public class MvcConfig extends WebMvcConfigurerAdapter {

	private static Logger log = LoggerFactory.getLogger(MvcConfig.class) ;
	@Bean
	CoustomInterceptor coustomInterceptor(){
		return new CoustomInterceptor() ;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(coustomInterceptor()).addPathPatterns("/**")/*.excludePathPatterns("")*/;
		super.addInterceptors(registry);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/") ;
		super.addResourceHandlers(registry);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		log.info("sdfdsfd");
		
//		super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("login");
	}
	

}
