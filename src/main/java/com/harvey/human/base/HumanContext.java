package com.harvey.human.base;

import com.harvey.human.model.UserModel;

/**
 * HumanContext
 * 
 * @author Harvey
 * @date 2020年12月30日
 */
public class HumanContext {
	private static ThreadLocal<UserModel> userThreadLocal = new ThreadLocal<UserModel>();
	
	/**
	 * 设置当前登录用户信息
	 * 
	 * @param userModel 用户信息
	 */
	public static void setCurrentUser(UserModel userModel) {
		userThreadLocal.set(userModel);
	}
	
	/**
	 * 获取当前登录用户信息
	 * 
	 * @return 用户信息
	 */
	public static UserModel getCurrentUser() {
		return userThreadLocal.get();
	}
}
