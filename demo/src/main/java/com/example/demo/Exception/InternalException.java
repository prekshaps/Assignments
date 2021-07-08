package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1528245319430287596L;

	public InternalException(String message) {
		super(message);
	}

}
