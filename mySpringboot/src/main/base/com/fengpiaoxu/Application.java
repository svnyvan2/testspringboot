package com.fengpiaoxu;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fengpiaoxu.spring.SpringContextUtil;



/**
 * 启动类
 * 开启事务用的注解就是@EnableTransactionManagement
 */
@SpringBootApplication
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@EnableScheduling //启动定时任务
@MapperScan("com.fengpiaoxu.dao")//扫描的是mapper.xml中namespace指向值的包位置
@ServletComponentScan//配置druid必须加的注解，如果不加，访问页面打不开，filter和servlet、listener之类的需要单独进行注册才能使用，spring boot里面提供了该注解起到注册作用
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class) ;
	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(Application.class, args);
		SpringContextUtil.setApplicationContext(app);
	}
}

