package com.fengpiaoxu.spring.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

/**
 * 权限自定义配置器
 * @author hezhiyuan
 *
 */
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private final Map<String,String> urlRoleMap = new HashMap<String,String>(){{
        put("/ee","ROLE_USER");
        put("/test/**","ROLE_USER");
        put("/home","ROLE_USER");
    }};

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        System.out.println(2+"       "+url);
       
        if(url.equals("/login")||url.startsWith("/http/")||url.startsWith("/static/")){
        	return null; //不用权限即可访问
        }
        
//        String httpMethod = fi.getRequest().getMethod();
        for(Map.Entry<String,String> entry:urlRoleMap.entrySet()){
            if(antPathMatcher.match(entry.getKey(),url)){
            	
                return SecurityConfig.createList(entry.getValue());
            }
        }
       return SecurityConfig.createList("ROLE_USER");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
