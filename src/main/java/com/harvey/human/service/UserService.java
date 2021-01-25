package com.harvey.human.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvey.human.common.HumanConstant;
import com.harvey.human.dao.UserMapper;
import com.harvey.human.model.UserModel;
import com.harvey.human.model.TokenModel;
import com.harvey.human.util.CacacheUtils;

/**
 * 用户服务类
 * 
 * @author Harvey
 * @date 2020年12月30日
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public List<UserModel> find(){
		return userMapper.findUserModels(new UserModel());
	}
	/**
	 * 登录
	 * 
	 * @param userModel 用户信息
	 * @return 临牌信息
	 */
	public TokenModel login(UserModel userModel) {
		// 验证用户名密码
		
		// 验证通过生成token
		TokenModel tokenModel = TokenService.generateToken();
		String token = tokenModel.getToken();
		CacacheUtils.putCache(token, tokenModel);
		
		String key = token + HumanConstant.TOKEN_USER_INFO;
		CacacheUtils.putCache(key, userModel);
		return tokenModel;
	}
	
	public void logout(HttpServletRequest request) {
		String token = request.getHeader(HumanConstant.TOKEN);
		CacacheUtils.remove(token);
		CacacheUtils.remove(token + HumanConstant.TOKEN_USER_INFO);
	}
}
