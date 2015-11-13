package com.luchoc.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6355495076577976386L;
	
	public DataNotFoundException(String message) { 
		super(message);
	}
}
