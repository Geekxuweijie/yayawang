package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.UserMapper;
import com.lanou.entity.User;
import com.lanou.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	//登录用的，根据传过来的用户的用户名和密码来查找是否有这个用户
	public boolean selectUserByUser(User user) {
		boolean result = false;
		List<User> userList = userMapper.selectUserByUser(user);
		if (userList.size() != 0 ) {
			result = true;
			return result;
		}
		
		return result;
	}

	//注册用的，把传过来的用户存进用户表中
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean saveUser(User user) {
		boolean result = false;
		List<User> userList = userMapper.selectUserByuserName(user);
		System.out.println(userList);
		if (userList.size() == 0) {
			int res = userMapper.saveUser(user);
			if (res==1) {
				result = true;
			}
		}
		
		return result;
	}

}
