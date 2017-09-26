package com.restmockservice.errorhandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ErrorMessage {
	int code;
    String status;
    String message;
    
  	public ErrorMessage(int value, String string, String message2) {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public static ErrorMessage internalServerError(String message) {
        return new ErrorMessage(INTERNAL_SERVER_ERROR.value(), "Internal-Server-Error", message);
    }

    public static ErrorMessage notFound(String message) {
        return new ErrorMessage(NOT_FOUND.value(), "Not-Found", message);
    }

    public static ErrorMessage badRequest(String message) {
        return new ErrorMessage(BAD_REQUEST.value(), "Bad-Request", message);
    }

}
