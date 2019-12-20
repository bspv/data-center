package com.hxcf.common.ex;

public class ParameterException extends RuntimeException {
	private static final long serialVersionUID = 3272301612085625887L;
	private String code;
	private String message;

	public ParameterException(String code, String message) {
		this.message = message;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
