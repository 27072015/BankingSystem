package com.cg.banking.services;

import java.util.List;
import java.util.Map;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public interface BankingServices {
	void pinVerify(long accountNo, int pinNumber,int counter) throws InvalidPinNumberException;
	long openAccount(String accountType,float initBalance)
			throws InvalidAmountException,InvalidAccountTypeException,BankingServicesDownException;

	float depositAmount(long accountNo,float amount)
			throws AccountNotFoundException,BankingServicesDownException,AccountBlockedException;

	float withdrawAmount(long accountNo,float amount)
			throws InsufficentAmountException,BankingServicesDownException,AccountBlockedException;

	void fundTransfer(long accountNoTo,long accountNoFrom,float transferAmount)
			throws InsufficentAmountException,BankingServicesDownException,AccountBlockedException;

	Account getAccountDetails(long accountNo)
			throws AccountNotFoundException;

	List<Account> getAllAccountDetails()
			throws BankingServicesDownException;

	List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException,AccountNotFoundException;

	public String accountStatus(long accountNo)
			throws BankingServicesDownException,AccountNotFoundException,AccountBlockedException;
}
