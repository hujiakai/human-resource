package com.harvey.human.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harvey.human.common.Result;
import com.harvey.human.common.ResultEnum;
import com.harvey.human.model.UserModel;
import com.harvey.human.model.TokenModel;
import com.harvey.human.service.UserService;
import com.harvey.human.service.TokenService;


/**
 * 用户管理controller
 * 
 * @author Harvey
 * @date 2020年12月21日
 */
@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result<TokenModel> login(@Validated UserModel userModel) {
		logger.info("start login ============");
		TokenModel tokenModel = userService.login(userModel);
		return new Result<TokenModel>(ResultEnum.SUCCESS, tokenModel);
	}
	

	@RequestMapping(value = "/refresh/token", method = RequestMethod.POST)
	public Result<TokenModel> refreshToken(TokenModel tokenModel){
		TokenModel token = tokenService.refreshToken(tokenModel);
		return new Result<TokenModel>(ResultEnum.SUCCESS, token);
	}

}
