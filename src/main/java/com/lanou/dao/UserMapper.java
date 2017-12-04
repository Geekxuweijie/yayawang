package com.lanou.dao;

import java.util.List;

import com.lanou.entity.User;

public interface UserMapper {
	
	public List<User> selectUserByUser(User user);//登录
	public List<User> selectUserByuserName(User user);//注册查找
	public Integer saveUser(User user);//注册储存用户
}
