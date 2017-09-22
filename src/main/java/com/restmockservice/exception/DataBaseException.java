package com.restmockservice.exception;

public class DataBaseException extends RestMockException{
	private static final long serialVersionUID = 100L;
	public DataBaseException(String code) {
	        this.code = code;
	}
}
