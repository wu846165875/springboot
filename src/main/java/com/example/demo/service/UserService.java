package com.example.demo.service;

import java.util.List;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	//注入mapper接口对象
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 使用redis缓存
	 * @return
	 */
	@Cacheable("findAllUser")
	public List<User> findAllUser(){
		userMapper.findAllUser();
		System.out.println("查询所有用户------");
		return userMapper.findAllUser();
	}
	@Cacheable(value = "#user.userName")
	public User findUserByNameAndPwd(User user){
		System.out.println("redis------------");
		return userMapper.findUserByNameAndPwd(user);
	}
}
