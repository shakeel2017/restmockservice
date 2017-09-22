package com.restmockservice.errorhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class RestMockErrorHandler {
	
	private final Logger logger = LoggerFactory.getLogger(RestMockErrorHandler.class);
	@ExceptionHandler(Exception.class)
    ResponseEntity<ErrorMessage> allOtherErrorsHandler(Exception exception) {
		logger.error("Internal Server Error: ", exception);
        return new ResponseEntity<>(ErrorMessage.internalServerError("INTERNAL SERVER ERROR"),HttpStatus.INTERNAL_SERVER_ERROR);          
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    ResponseEntity<ErrorMessage> unknownRouteHandler(WebRequest request) {
        return new ResponseEntity<>(
        		ErrorMessage.notFound("Unknown path: " + ((ServletRequestAttributes) request).getRequest().getRequestURI()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorMessage> invalidPayloadMarshallingHandler() {
        return new ResponseEntity<>(ErrorMessage.badRequest("Failure parsing bad request body"), HttpStatus.BAD_REQUEST);
    }

}
