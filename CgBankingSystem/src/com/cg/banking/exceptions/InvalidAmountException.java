package com.cg.banking.exceptions;

public class InvalidAmountException extends RuntimeException{

	public InvalidAmountException(String string) {
		super(string);
	}

}
