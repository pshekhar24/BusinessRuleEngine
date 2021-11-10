package com.bre.orderprocesing.exception;

public class MembershipAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MembershipAlreadyExistsException(String errorMessage)  {  
		super(errorMessage);  
	}
}
