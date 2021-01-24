package com.harvey.human.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.harvey.human.common.BussinessException;
import com.harvey.human.common.Result;

/**
 * 全局异常处理
 * 
 * @author Harvey
 * @date 2020年12月28日
 */
@ControllerAdvice
public class HumanExceptionHandler {
	Logger logger = LoggerFactory.getLogger(HumanExceptionHandler.class);

	@ExceptionHandler({Exception.class})
	public Result<?> humanExceptionHandle(Exception ex){
		logger.error("exceptin msg:{}", ex);
		Result<?> result = Result.fail();
		if (ex instanceof BussinessException) {
			BussinessException bussinessException = (BussinessException) ex;
			result.setCode(bussinessException.getCode());
			result.setMessage(bussinessException.getMessage());
		}
		return result;
	}
}
