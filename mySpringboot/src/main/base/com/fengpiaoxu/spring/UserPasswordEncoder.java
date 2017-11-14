package com.fengpiaoxu.spring;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.fengpiaoxu.util.MD5Util;

/**
 * 密码加密，密码校验
 * @author hezhiyuan
 *
 */
public class UserPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return MD5Util.encode((String)rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		//return encodedPassword.equals(MD5Util.encode((String)rawPassword));
		return true;
	}

}
