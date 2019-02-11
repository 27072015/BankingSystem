package com.cg.banking.exceptions;

public class InvalidPinNumberException extends RuntimeException {

	public InvalidPinNumberException(String string) {
		super(string);
	}

}
