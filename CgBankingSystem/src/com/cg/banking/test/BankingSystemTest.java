package com.cg.banking.test;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
import com.cg.banking.util.BankingDButil;
public class BankingSystemTest {
	private static BankingServices services;
	@BeforeClass
	public static void setUpTestEnv() {
		services = new BankingServicesImpl();
	}
	@Before
	public void setUpTestData() {
		HashMap<Integer, Transaction>transactions1 = new HashMap<>();
		HashMap<Integer, Transaction>transactions2 = new HashMap<>();
		transactions1.put(1111, new Transaction(1111, 1000, "Deposit"));
		Account account1 = new Account(9001, 3331, "Savings", "Active", 2000.0F, transactions1);
		transactions2.put(1112, new Transaction(1112, 1000, "Withdraw"));
		Account account2 = new Account(9002, 3332, "Savings", "Active", 2000.0F, transactions2);
		BankingDButil.accounts.put(account1.getAccountNo(), account1);
		BankingDButil.accounts.put(account2.getAccountNo(), account2);
		BankingDButil.CUSTOMER_ACCOUNT_NO = 9002;
		BankingDButil.TRANSACTION_ID = 1112;
	}
	@Test(expected=AccountNotFoundException.class)
	public void testGetAccountDetailsForInvalidAccountNo() throws AccountNotFoundException,InvalidPinNumberException{
		System.out.println(services.getAccountDetails(8456));
	}
	@Test
	public void testGetAccountDetailsForValidAccountNo() throws AccountNotFoundException{
		HashMap<Integer, Transaction>transactions2 = new HashMap<>();
		transactions2.put(1112, new Transaction(1112, 1000, "Withdraw"));
		Account expectedAccount = new Account(9002, 3332, "Savings", "Active", 2000.0F,transactions2);
		Account actualAccount =  services.getAccountDetails(9002);
		Assert.assertEquals(expectedAccount, actualAccount);
	}
	@Test
	public void testDepositAmount() {
		int expectedBalance = 2500;
		int actualBalance = (int)services.depositAmount(9002, 500.0F);
		Assert.assertEquals(expectedBalance, actualBalance);
	}
	@Test 
	public void testWithdrawAmount() {
		int expectedBalance = 1500;
		int actualBalance = (int)services.withdrawAmount(9002, 500.0F);
	}
	@Test(expected = InvalidAmountException.class)
	public void testOpenAccountForInValidInitalAmount() throws InvalidAmountException{
		long expectedAccountNo = 9003;
		long actualAcountNo = services.openAccount("Savings", 400);
		Assert.assertEquals(expectedAccountNo, actualAcountNo);
	}
	@Test
	public void testOpenAccountForValidInitalAmount() throws InvalidAmountException{
		long expectedAccountNo = 9003;
		long actualAcountNo = services.openAccount("Savings", 1000);
		Assert.assertEquals(expectedAccountNo, actualAcountNo);
	}
	@After
	public void tearDownTestData() {
		BankingDButil.accounts.clear();
		BankingDButil.CUSTOMER_ACCOUNT_NO = 9000;
		BankingDButil.TRANSACTION_ID = 1111;
	}
	@AfterClass
	public static void tearDownTestEnv() {
		services =null;
	}
}
