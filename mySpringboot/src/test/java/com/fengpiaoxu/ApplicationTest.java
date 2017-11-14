package com.fengpiaoxu;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengpiaoxu.entity.User;
import com.fengpiaoxu.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@TestPropertySource(locations = {"classpath:application.properties"})
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private UserService userService ;

	@Test
	public void test(){
		System.out.println(1111);
		List<User> users = userService.getUserByID() ;
		System.out.println(users);
	}
}
