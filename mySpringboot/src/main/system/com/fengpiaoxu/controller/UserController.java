package com.fengpiaoxu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fengpiaoxu.entity.Msg;
import com.fengpiaoxu.entity.User;
import com.fengpiaoxu.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value= "/user")	
	public List<User> getUser(){
		 List<User> userByID = userService.getUserByID();
		 
		
		return userByID;
		
	}
	@RequestMapping(value= "/index1")	
	public void getIndex(HttpServletRequest request,HttpServletResponse response) throws IOException{
	 response.sendRedirect("index2");
	}
//	@RequestMapping(value= "/")	
//	public String getIndex2(HttpServletRequest request,HttpServletResponse response,ModelMap map,Model model) throws IOException{
//		   Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
//		    model.addAttribute("msg", msg);
//		return "login";
//	}
//	@RequestMapping(value= "/login")	
//	public String getIndex3(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws IOException{
//		map.addAttribute("ctx", "..");
//		return "login";
//	}
	@RequestMapping(value= "/login9")	
	public String getIndex39(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws IOException{
		return "index";
	}
//   @RequestMapping("home")
//    public  String index(Model model) {
//	   Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
//	   System.out.println("999999");
//   	model.addAttribute("msg", msg);
//       return "index";
//   }
   @RequestMapping("home/ooo")
   public @ResponseBody String indexee(Model model) {
	   return "home";
   }
  
    @RequestMapping("/ee")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 或角色
//    @PreAuthorize("principal.username.equals(#username)") 只能查询自己
//    @PreAuthorize("hasRole('ROLE_USER')")  
    public @ResponseBody String index9(Model model) {
    	Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
    	model.addAttribute("msg", msg);
    	return "index";
    }
    @RequestMapping("/http/ee")
    public @ResponseBody String index10(Model model) {
    	return "httpee";
    }
    @RequestMapping("/cus_error/{code}")
    public String index11(@PathVariable("code") Integer code,Model model,HttpServletResponse response) {
    	response.setStatus(code);
    	return "error/"+code;
    }
    @RequestMapping("/test/test1")
    public String index13(Model model,HttpServletResponse response) {
    	return "/test/test1";
    }
    @RequestMapping("/test/test2")
    public String index14(Model model,HttpServletResponse response) {
    	return "/test/test2";
    }
    @RequestMapping("/test/test3")
    public String index16(Model model,HttpServletResponse response) {
    	return "/test/test3";
    }
    @RequestMapping("/home")
    public String index15(Model model,HttpServletResponse response) {
    	return "home";
    }
}
