package com.harvey.human.common;

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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
