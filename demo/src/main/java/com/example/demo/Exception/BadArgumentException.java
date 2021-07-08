package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadArgumentException extends RuntimeException{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 889119117197928050L;

	public BadArgumentException(String message) {
		super(message);
	}

}
