package com.harvey.human.common;

public enum ResultEnum {
	SUCCESS(200, "success"),
	
	FAILURE(600, "operate failure"),
	
	// token不可用，需要重新登录
	TOKEN_INVALID(601, "token invalid"),
	
	// token过期，可用refreshToken更新
	TOKEN_EXPIRED(602, "token expired");
	
	private int code;
	
	private String message;

	private ResultEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
