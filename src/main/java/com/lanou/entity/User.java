package com.lanou.entity;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	private int userId;
	private String userName;//手机号
	private String password;
	private String nickName;
	private String sex;
	private String email;
	private String realName;
	
	private String birth;
	private String address;
	private String photoImage;
	private Integer member_id;
	private Integer delete_id;
	private Integer level;//是否管理员
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhotoImage() {
		return photoImage;
	}
	public void setPhotoImage(String photoImage) {
		this.photoImage = photoImage;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getDelete_id() {
		return delete_id;
	}
	public void setDelete_id(Integer delete_id) {
		this.delete_id = delete_id;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", nickName=" + nickName
				+ ", sex=" + sex + ", email=" + email + ", realName=" + realName + ", birth=" + birth + ", address="
				+ address + ", photoImage=" + photoImage + ", member_id=" + member_id + ", delete_id=" + delete_id
				+ ", level=" + level + "]";
	}
	
	
}
