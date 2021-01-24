package com.harvey.human.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.harvey.human.base.HumanContext;
import com.harvey.human.common.BussinessException;
import com.harvey.human.common.HumanConstant;
import com.harvey.human.common.HumanThreadPool;
import com.harvey.human.common.ResultEnum;
import com.harvey.human.model.UserModel;
import com.harvey.human.model.TokenModel;
import com.harvey.human.util.CacacheUtils;

@Service
public class TokenService {
	/**
	 * 验证token是否有效，若有效则需要续期
	 * 
	 * @param token 令牌
	 * @return true-有效，false-无效
	 */
	public boolean validateToken(String token) {
		if (ObjectUtils.isEmpty(token)) {
			return false;
		}
		
		TokenModel tokenModel = (TokenModel) CacacheUtils.getValue(token);
		if (tokenModel == null) {
			return false;
		}
		
		long currentTime = Calendar.getInstance().getTimeInMillis();
		long tokenExpireTime = tokenModel.getExpireDate().getTime();
		if (tokenExpireTime > currentTime) {
			return false;
		}
		
		// 验证通过，token续期
		TokenRenewalThread tokenRenewal = new TokenRenewalThread(token, HumanConstant.TOKEN_OPERATE_RENEWAL);
		HumanThreadPool.getInstance().execute(tokenRenewal);
		return true;
	}
	
	/**
	 * 通过refreshToken更新token
	 * 
	 * @param tokenModel token信息
	 * @return 新token
	 */
	public TokenModel refreshToken(TokenModel tokenModel) {
		if (ObjectUtils.isEmpty(tokenModel.getToken()) || ObjectUtils.isEmpty(tokenModel.getRefreshToken())) {
			throw new BussinessException(ResultEnum.TOKEN_INVALID);
		}

		TokenModel cacheToken = (TokenModel) CacacheUtils.getValue(tokenModel.getToken());
		if (!cacheToken.getToken().equals(tokenModel.getToken())
				|| !cacheToken.getRefreshToken().equals(tokenModel.getRefreshToken())) {
			throw new BussinessException(ResultEnum.TOKEN_INVALID);
		}

		// 生成新的token
		TokenModel newToken = generateToken();
		String token = newToken.getToken();
		CacacheUtils.putCache(token, tokenModel);
		String key = token + HumanConstant.TOKEN_USER_INFO;
		UserModel currentUser = HumanContext.getCurrentUser();
		CacacheUtils.putCache(key, currentUser);
		
		//删除旧token
		TokenRenewalThread tokenRemove = new TokenRenewalThread(tokenModel.getToken(),
				HumanConstant.TOKEN_OPERATE_REMOVE);
		HumanThreadPool.getInstance().execute(tokenRemove);
		
		return newToken;
	}
	
	public static TokenModel generateToken() {
		String token = UUID.randomUUID().toString();
		String refreshToken = UUID.randomUUID().toString();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, HumanConstant.TOKEN_EXPIRE_TIME);
		return new TokenModel(token, refreshToken, calendar.getTime());
	}
	
	/**
	 * 为token续期
	 * 
	 * @author Harvey
	 * @date 2020年12月30日
	 */
	class TokenRenewalThread implements Runnable {
		private String token;
		
		// 操作类型：
		private String operateType;

		public TokenRenewalThread(String token, String operateType) {
			super();
			this.token = token;
			this.operateType = operateType;
		}

		@Override
		public void run() {
			TokenModel tokenModel = (TokenModel) CacacheUtils.getValue(token);
			if (tokenModel != null) {
				if (HumanConstant.TOKEN_OPERATE_RENEWAL.equals(operateType)) {
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.MINUTE, HumanConstant.TOKEN_EXPIRE_TIME);
					tokenModel.setExpireDate(calendar.getTime());
					CacacheUtils.putCache(token, tokenModel);
				} else if (HumanConstant.TOKEN_OPERATE_REMOVE.equals(operateType)) {
					CacacheUtils.remove(token);
					CacacheUtils.remove(token + HumanConstant.TOKEN_USER_INFO);
				}
			}
		}
	}
}
