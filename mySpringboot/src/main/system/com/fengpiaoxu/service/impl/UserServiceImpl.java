
package com.fengpiaoxu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fengpiaoxu.dao.UserDAO;
import com.fengpiaoxu.entity.User;
import com.fengpiaoxu.service.UserService;


/**
 * @author mn11235813@163.com
 * @date 2017-07-03 15:22:24
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 36000,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	
	@Override
	public List<User> getUserByID() {
		List<User> findUserByID = userDAO.findUser();	
		return findUserByID;
	}


	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
