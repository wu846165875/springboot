package com.example.demo.controller;

import java.util.List;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/findAllUser")
	public List<User> findAllUser(){
		return userService.findAllUser();
	}

	@RequestMapping("findUserByNameAndPwd")
	public String findUserByNameAndPwd(User user){
		System.out.println("jinru-----");
		User loginuser =  userService.findUserByNameAndPwd(user);
		if (loginuser != null) {
			return "index";
		} else {
			return "login";
		}
	}

}
