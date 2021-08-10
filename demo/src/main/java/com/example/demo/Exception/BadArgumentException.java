package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * Custom Exception called by name BadArgumentException for product if it does
 * not exists
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadArgumentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 889119117197928050L;

	/**
	 * 
	 * @param message accepts the message of type string
	 */
	public BadArgumentException(String message) {
		super(message);
	}

}
