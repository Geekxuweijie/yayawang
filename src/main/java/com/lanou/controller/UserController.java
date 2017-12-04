package com.lanou.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.lanou.util.FastJson_Ali;

@Controller
@RequestMapping("/user")
public class UserController {

	private HttpServletResponse response;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public void login(String userName,String password,HttpServletResponse response) throws IOException {
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		String mes = "";
		boolean result = false;
		if (userService.selectUserByUser(user)) {
			result = true;
			mes = "登录成功";
		} else {
			result = false;
			mes = "登录失败";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("mes", mes);
		FastJson_Ali.toJson(map,response);
	}
	
	@RequestMapping("/reg")
	public void reg(String userName,String password,HttpServletResponse response) throws IOException {

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);

		boolean result = false;
		String mes = "";
		Pattern p1 = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 11位验证手机号即用户名
		Pattern p2 = Pattern.compile("[0-9A-Za-z]{6,16}$");// 6-16密码

		Matcher m1 = p1.matcher(user.getUserName());
		if (m1.matches()) {
			Matcher m2 = p2.matcher(user.getPassword());
			if (m2.matches()) {
				if (userService.saveUser(user)) {
					result = true;
					mes = "注册成功";
				} else {
					result = false;
					mes = "用户名已存在";
				}
			} else {
				result = false;
				mes = "密码错误";
			}
		} else {
			result = false;
			mes = "用户名错误";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("mes", mes);
		FastJson_Ali.toJson(map, response);
	}
}
