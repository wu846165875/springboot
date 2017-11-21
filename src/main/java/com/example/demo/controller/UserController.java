package com.example.demo.controller;

import java.util.List;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RedisTemplate redisTemplate;

	@RequestMapping("/findAllUser")
	public List<User> findAllUser(){
		return userService.findAllUser();
	}

	@RequestMapping("findUserByNameAndPwd")
	public ModelAndView findUserByNameAndPwd(User user){
		System.out.println(user);
		User loginuser =  userService.findUserByNameAndPwd(user);

		if (loginuser != null) {//登录成功
			//统计网站总访问量
			redisTemplate.opsForValue().increment("visits",1);
			//统计网站今日访问量
			redisTemplate.opsForValue().increment(DateUtil.getCurrentDate(""),1);

			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("loginuser",loginuser);
			return modelAndView;
			//return "index";
		} else {//用户名密码错误

			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("loginError","用户名或密码错误！");
			return  modelAndView;
			//return "login";
		}
	}

}
