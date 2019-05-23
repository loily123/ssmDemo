package com.exception;

public class MyWebException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public MyWebException(String msg, String errorCode) {
		super();
		this.errorCode = errorCode;
		this.msg = msg;
	}
}
