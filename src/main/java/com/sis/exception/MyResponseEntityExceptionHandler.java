package com.sis.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr) {
		BaseException be = new BaseException(new Date(), ex.getMessage(), wr.getDescription(false));
		return new ResponseEntity(be, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest wr) {
		BaseException be = new BaseException(new Date(), ex.getMessage(), wr.getDescription(false));
		return new ResponseEntity(be, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders header, HttpStatus status, WebRequest request) {
		BaseException be = new BaseException(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity(be, HttpStatus.BAD_REQUEST);
	}
}
