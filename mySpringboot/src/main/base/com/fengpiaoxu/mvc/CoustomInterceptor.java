package com.fengpiaoxu.mvc;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fengpiaoxu.service.UserService;
import com.fengpiaoxu.spring.SpringContextUtil;

public class CoustomInterceptor  implements HandlerInterceptor {

	private static Logger log = LoggerFactory.getLogger(CoustomInterceptor.class) ;
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		log.info("请求之后处理");
		System.out.println(request.getRequestURI()); 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView model) throws Exception {
		log.info("controller调用之后");
		if(model!=null){
			log.info(request.getContextPath()) ;
			model.addObject("_app", request.getContextPath()) ;
		}
		System.out.println(request.getRequestURI()); 
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		log.info("调用controller之前");
		System.out.println(response.getStatus()) ;
		Principal p = request.getUserPrincipal() ;
		
//		if(request.getRequestURI().equals("/tt/error")&&p==null){
//        	response.sendRedirect("home");
//		}
		
		
		if(response.getStatus() == 403&&p!=null){
			response.sendRedirect("cus_error/403");
		}
		System.out.println(request.getRequestURI()); 
		
		System.out.println(SpringContextUtil.getBean(UserService.class)) ;
		System.out.println("sessionid  "+request.getSession().getId());
		return true;
	}

}
