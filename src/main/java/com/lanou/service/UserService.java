package com.lanou.service;

import com.lanou.entity.User;

public interface UserService {
	
	public boolean selectUserByUser(User user);//登录
	public boolean saveUser(User user);//注册储存用户
}
