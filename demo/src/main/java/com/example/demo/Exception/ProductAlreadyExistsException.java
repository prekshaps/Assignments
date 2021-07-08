package com.example.demo.Exception;

public class ProductAlreadyExistsException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2596524050807149598L;
	private String message;

    public ProductAlreadyExistsException(){

    }

    public ProductAlreadyExistsException(String message){
        super();
        this.message = message;
    }

}
