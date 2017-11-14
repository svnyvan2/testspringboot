package com.fengpiaoxu.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.fengpiaoxu.service.impl.SecurityUserServiceImpl;
import com.fengpiaoxu.spring.UserPasswordEncoder;

/**
 * Spring Security的配置类 WebSecurityConfig 
 * 通过 @EnableWebMvcSecurity 注解开启Spring Security的功能
 * 继承 WebSecurityConfigurerAdapter ，并重写它的方法来设置一些web安全的细节
 * configure(HttpSecurity http) 方法
 * 通过 authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护。
 * 例如以上代码指定了 / 和 /home 不需要任何认证就可以访问，其他的路径都必须通过身份验证。
 * 通过 formLogin() 定义当需要用户登录时候，转到的登录页面。
 * configureGlobal(AuthenticationManagerBuilder auth) 方法，
 * 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。新增登录请求与页面
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	   @Bean
	   UserDetailsService customUserService() {
	        return new SecurityUserServiceImpl();
	   }
	   
	   @Bean
	   MyAccessDecisionManager accessDecisionManager() {
		   return new MyAccessDecisionManager();
	   }
	   
	   @Bean
	   CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource() {
		   return new CustomFilterInvocationSecurityMetadataSource();
	   }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                .antMatchers("/css/**","/http/**","/login").permitAll() //这两个请求不用登陆就能访问
////                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>(){
////					@Override
////					public <O extends FilterSecurityInterceptor> O postProcess(
////							O object) {
////						object.setAccessDecisionManager(accessDecisionManager());
////						object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource());
////						return object;
////					}
////                })
                 .anyRequest().authenticated() //任何请求登录后才可以访问
                 .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>(){
					@Override
					public <O extends FilterSecurityInterceptor> O postProcess(
							O object) {
						object.setAccessDecisionManager(accessDecisionManager());
						object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource());
						return object;
					}
                })
                .and()
            .formLogin()
                .loginPage("/login")
                .passwordParameter("password")
                .usernameParameter("username")
                .failureUrl("/login?error")
                .permitAll()
                .and()
            .logout().logoutSuccessUrl("/login").permitAll();
        //设置默认登录成功跳转页面
//        .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
//        .and()
//        //开启cookie保存用户数据
//        .rememberMe()
//        //设置cookie有效期
//        .tokenValiditySeconds(60 * 60 * 24 * 7)
//        //设置cookie的私钥
//        .key("")
//        .and()
//        .logout()
//        //默认注销行为为logout，可以通过下面的方式来修改
//        .logoutUrl("/custom-logout")
//        //设置注销成功后跳转页面，默认是跳转到登录页面
//        .logoutSuccessUrl("")
//        用户名不存在:UsernameNotFoundException;
//        密码错误:BadCredentialException;
//        帐户被锁:LockedException;
//        帐户未启动:DisabledException;
//        密码过期:CredentialExpiredException;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new UserPasswordEncoder());
    }

}

