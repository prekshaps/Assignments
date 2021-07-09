package com.example.demo.Controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.demo.Exception.BadRequestException;
import com.example.demo.Exception.CustomException;
import com.example.demo.Exception.ExceptionResponse;
import com.example.demo.Exception.ProductAlreadyExistsException;
import com.example.demo.Exception.ProductNotFoundException;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleExceptions(BadRequestException exception,WebRequest webRequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("BAD_REQUEST");
		response.setStatus_Code(400);
		response.setDescription("product price should not be leesthan 100");
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		return entity;
		
	}
	
	@ExceptionHandler(ProductAlreadyExistsException.class)
	public ResponseEntity<Object> handleExceptions(ProductAlreadyExistsException exception,WebRequest webRequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("ALREADY_EXITS");
		response.setStatus_Code(422);
		response.setDescription("Product already exits please don't add");
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.ALREADY_REPORTED);
		return entity;
		
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(ProductNotFoundException exception,WebRequest webRequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("NOT_FOUND");
		response.setStatus_Code(400);
		response.setDescription("Sorry Requested Product not present");
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		return entity;
		
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleExceptions(CustomException exception,WebRequest webRequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage("INTERNAL_SERVER_ERROR");
		response.setStatus_Code(500);
		response.setDescription("check the passcode");
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
		
	}

	
}
