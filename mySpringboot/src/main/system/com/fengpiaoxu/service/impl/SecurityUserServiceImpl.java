package com.fengpiaoxu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fengpiaoxu.dao.UserDAO;
import com.fengpiaoxu.entity.User;

public class SecurityUserServiceImpl implements UserDetailsService{
	
	@Autowired
	UserDAO userDAO ;

	@Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		User user = userDAO.getUserByName(name) ;
		//添加权限
		List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        user.setAuthoritys(authorities);
		return user;
	}
	
}
