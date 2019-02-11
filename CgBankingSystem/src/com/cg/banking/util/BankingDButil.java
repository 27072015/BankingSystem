package com.cg.banking.util;

import java.util.HashMap;
import java.util.Random;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;

public class BankingDButil {
	public static HashMap<Long,Account> accounts= new HashMap<>();
	public static long CUSTOMER_ACCOUNT_NO =1000;
	public static int TRANSACTION_ID = 7500;
		public static long getCUSTOMER_ACCOUNT_NO() {
		return ++CUSTOMER_ACCOUNT_NO;
	}
	public static int getCUSTOMER_PIN() {
		
		return (int)Math.pow(5, 5 - 1) + new Random().nextInt(6000);
	}
	public static int getTRANSACTION_ID() {
		return ++TRANSACTION_ID;
	}
}

