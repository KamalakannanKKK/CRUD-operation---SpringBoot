package com.Spring.CRUD.Operation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
	public ResponseEntity<ErrorObject> handleResourceNotfoundException(ResourceNotFoundException ex){
    	ErrorObject errorobject=new ErrorObject();
    	errorobject.setStatuscode(HttpStatus.NOT_FOUND.value());
    	errorobject.setMessage(ex.getMessage());
    	errorobject.setTimestamp(System.currentTimeMillis());
    	return new ResponseEntity<>(errorobject,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler
	public ResponseEntity<ErrorObject> handleNoDatafoundException(NoDataFoundException ex){
    	ErrorObject errorobject=new ErrorObject();
    	errorobject.setStatuscode(HttpStatus.NO_CONTENT.value());
    	errorobject.setMessage(ex.getMessage());
    	errorobject.setTimestamp(System.currentTimeMillis());
    	return new ResponseEntity<>(errorobject,HttpStatus.OK);
    }
}
