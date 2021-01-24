package com.harvey.human.common;

public class HumanConstant {
	public static final String TOKEN = "token";
	/**
	 * 用户信息在缓存中key的后缀
	 */
	public static final String TOKEN_USER_INFO = "-token-user-info";
	
	/**
	 * token有效时长（分钟）
	 */
	public static final int TOKEN_EXPIRE_TIME = 15;
	
	/**
	 * token操作类型：续期
	 */
	public static final String TOKEN_OPERATE_RENEWAL = "renewal";
	
	/**
	 * token操作类型：删除
	 */
	public static final String TOKEN_OPERATE_REMOVE = "remove";

}
