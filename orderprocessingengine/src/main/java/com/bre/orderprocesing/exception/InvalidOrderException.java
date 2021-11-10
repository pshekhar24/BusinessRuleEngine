package com.bre.orderprocesing.exception;

public class InvalidOrderException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidOrderException(String errorMessage)  {  
		super(errorMessage);  
	}
}
