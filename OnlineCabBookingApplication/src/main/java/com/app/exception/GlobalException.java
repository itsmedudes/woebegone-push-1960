package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorList> allExceptionHandler(Exception e, WebRequest wr){
		MyErrorList error = new MyErrorList();
		error.setLocalDateTime(LocalDateTime.now());
		error.setDetails(e.getMessage());
		error.setMessage(wr.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorList> methodArgsInvalid(MethodArgumentNotValidException e,WebRequest wr) {
		MyErrorList err = new MyErrorList();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(e.getBindingResult().getFieldError().getDefaultMessage());
	
		return new ResponseEntity<MyErrorList>(err,HttpStatus.BAD_REQUEST);
	}
	
	//Driver Exception
	@ExceptionHandler(DriverException.class)
	public ResponseEntity<MyErrorList> driverExceptionHandler(DriverException e,WebRequest wr){
		MyErrorList error = new MyErrorList();
		error.setLocalDateTime(LocalDateTime.now());
		error.setDetails(e.getMessage());
		error.setMessage(wr.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	

}
