package com.fengpiaoxu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fengpiaoxu.entity.User;


@Mapper //依赖于此注解
public interface UserDAO {
	
	List<User> findUser();
	
	User getUserByName(String name);
}
