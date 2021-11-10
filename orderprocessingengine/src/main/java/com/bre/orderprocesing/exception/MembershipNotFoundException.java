package com.bre.orderprocesing.exception;

public class MembershipNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MembershipNotFoundException(String errorMessage)  {  
		super(errorMessage);  
	}
}
