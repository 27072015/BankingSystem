package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.util.BankingDButil;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public Account save(Account account) {
		account.setAccountNo(BankingDButil.getCUSTOMER_ACCOUNT_NO());
		account.setPinNumber(BankingDButil.getCUSTOMER_PIN());
		BankingDButil.accounts.put(account.getAccountNo(), account);
		return account;
	}

	@Override
	public boolean update(Account account) {
		account.setAccountBalance(account.getAccountBalance());
		BankingDButil.accounts.put(account.getAccountNo(), account);
		return false;
	}

	@Override
	public Account findOne(long accountNo) throws AccountNotFoundException{
		Account account=BankingDButil.accounts.get(accountNo);
		return account;
	}

	@Override
	public List<Account> findAll() {
		List<Account>accountList = new ArrayList<>(BankingDButil.accounts.values());
		return accountList;
	}



}
