package com.jSolutions.exceptions;

public class NotBelongsToDomainException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotBelongsToDomainException(String message) {
        super(message);
    }
}
