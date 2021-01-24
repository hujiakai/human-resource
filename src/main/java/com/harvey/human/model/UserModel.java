package com.harvey.human.model;

import com.harvey.human.base.BaseModel;

import lombok.Data;

@Data
public class UserModel extends BaseModel{
	private static final long serialVersionUID = 4260260191087771342L;
	private String userName;
	
	private String mobile;
	
	private String password;
	
	private String salt;
}
