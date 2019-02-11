package com.cg.banking.daoservices;
import java.util.List;
import java.util.Map;

import com.cg.banking.beans.Transaction;
public interface TransactionDAO {
	Transaction save(Transaction transaction,long accountNo);
	boolean update(Transaction transaction,long accountNo);
	Transaction findOne(long accountNo,int transactionId);
	List<Transaction> findAll(long accountNo);
}
