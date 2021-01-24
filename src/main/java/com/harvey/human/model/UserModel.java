package com.harvey.human.model;

import com.harvey.human.base.BaseModel;

public class UserModel extends BaseModel{
	private static final long serialVersionUID = 4260260191087771342L;

	private String userName;
	
	private String mobile;
	
	private String password;
	
	private String salt;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
