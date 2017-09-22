package com.restmockservice.exception;

public class RestMockException extends Exception{

		private static final long serialVersionUID = 1L;
		protected String code;
		protected String message;

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
}
