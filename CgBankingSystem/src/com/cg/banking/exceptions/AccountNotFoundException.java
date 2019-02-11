package com.cg.banking.exceptions;

public class AccountNotFoundException extends RuntimeException{

	public AccountNotFoundException(String string) {
		super(string);
	}

}
