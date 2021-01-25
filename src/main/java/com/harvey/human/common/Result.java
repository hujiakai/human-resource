package com.harvey.human.common;

/**
 * 返回数据结构
 * 
 * @author Harvey
 * @date 2020年12月28日
 */
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
	
	public Result(T data) {
		this.code = ResultEnum.SUCCESS.getCode();
		this.message = ResultEnum.SUCCESS.getMessage();
		this.data = data;
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
