package com.harvey.human.common;

import lombok.Data;

@Data
public class BussinessException extends RuntimeException{
	private static final long serialVersionUID = 8433723079694769042L;

	private int code;
	
	private String errorMsg;

	public BussinessException(int code, String errorMsg) {
		super();
		this.code = code;
		this.errorMsg = errorMsg;
	}
	
	public BussinessException(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.errorMsg = resultEnum.getMessage();
	}
}
