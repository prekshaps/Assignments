package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @exception resourcenotfound Exception
 * @author P7112764
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {// 404
	/**
	 * 
	 */
	private static final long serialVersionUID = -7193939015589380840L;

	/**
	 * 
	 * @param message accepts the message
	 */

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
