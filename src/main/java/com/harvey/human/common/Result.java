package com.harvey.human.common;

import lombok.Data;

/**
 * 返回数据结构
 * 
 * @author Harvey
 * @date 2020年12月28日
 */
@Data
public class Result <T>{
	private int code;
	
	private String message;
	
	private T data;


	@SuppressWarnings("rawtypes")
	public static Result success(){
		return new Result(ResultEnum.SUCCESS);
	}
	
	@SuppressWarnings("rawtypes")
	public static Result fail() {
		return new Result(ResultEnum.FAILURE);
	}
	
	public Result() {
		super();
	}

	public Result(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Result(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
	}
	
	public Result(ResultEnum resultEnum, T data) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
		this.data = data;
	}
}
