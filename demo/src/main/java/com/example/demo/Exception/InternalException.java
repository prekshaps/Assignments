package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * Custom Exception for handling Internal Server error
 * @author P7112764
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1528245319430287596L;
/**
 * 
 * @param message accepts the String message
 */
	public InternalException(String message) {
		super(message);
	}

}
