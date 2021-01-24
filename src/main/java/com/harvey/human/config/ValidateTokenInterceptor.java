package com.harvey.human.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.harvey.human.base.HumanContext;
import com.harvey.human.common.BussinessException;
import com.harvey.human.common.HumanConstant;
import com.harvey.human.common.ResultEnum;
import com.harvey.human.model.UserModel;
import com.harvey.human.service.TokenService;
import com.harvey.human.util.CacacheUtils;

@Component
public class ValidateTokenInterceptor implements HandlerInterceptor {
	@Autowired
	private TokenService tokenService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		String path = request.getRequestURI();
//		String path1 = request.getRequestURL().toString();
//		String path3 = request.getServletPath();
//		String token = request.getHeader(HumanConstant.TOKEN);
//		boolean isValidToken = tokenService.validateToken(token);
//		if (!isValidToken) {
//			throw new BussinessException(ResultEnum.TOKEN_EXPIRED);
//		}
//		UserModel currentUser = (UserModel) CacacheUtils.getValue(token + HumanConstant.TOKEN_USER_INFO);
//		HumanContext.setCurrentUser(currentUser);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
