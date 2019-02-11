package com.cg.banking.exceptions;

public class InsufficentAmountException extends RuntimeException{
	public InsufficentAmountException(String s) {
	super(s);
	}
}
