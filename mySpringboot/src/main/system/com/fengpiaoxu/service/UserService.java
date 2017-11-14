
package com.fengpiaoxu.service;

import java.util.List;

import com.fengpiaoxu.entity.User;


public interface UserService {
	List<User> getUserByID();
	User getUserByName(String name) ;
}
