package com.harvey.human.model;

import java.io.Serializable;
import java.util.Date;

public class TokenModel implements Serializable{
	private static final long serialVersionUID = 4029363888441876439L;

	private String token;
	
	private String refreshToken;
	
	private Date expireDate;

	public TokenModel(String token, String refreshToken, Date expireDate) {
		this.token = token;
		this.refreshToken = refreshToken;
		this.expireDate = expireDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	
}
