package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
	public List<User> findAllUser();

	@Select("SELECT * FROM USER WHERE USERNAME=#{userName} AND PASSWORD = #{passWord}")
	public User findUserByNameAndPwd(User user);
}
