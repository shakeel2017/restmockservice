package com.restmockservice.exception;

public class NoDeveloperFoundException extends RestMockException{
	private static final long serialVersionUID = 190L;
	public NoDeveloperFoundException(String code) {
	        this.code = code;
	}
}
