package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.util.BankingDButil;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public Transaction save(Transaction transaction,long accountNo) {
		Account account = BankingDButil.accounts.get(accountNo);
		transaction.setTransactionId(BankingDButil.getTRANSACTION_ID());
		account.transactions.put(transaction.getTransactionId(),transaction);
		return transaction;

	}

	@Override
	public boolean update(Transaction transaction,long accountNo) {
		return false;
	}

	@Override
	public Transaction findOne(long accountNo,int transactionId) {
		Account account = BankingDButil.accounts.get(accountNo);
		Transaction transaction = account.transactions.get(transactionId);
		return transaction;
	}

	@Override
	public List<Transaction> findAll(long accountNo) {
		Account account = BankingDButil.accounts.get(accountNo);
		ArrayList<Transaction>transactionList = new ArrayList<Transaction>(account.transactions.values());
		return transactionList;
	}

}
