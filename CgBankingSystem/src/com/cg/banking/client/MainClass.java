package com.cg.banking.client;
import java.util.Scanner;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.InsufficentAmountException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {

	public static void main(String[] args) throws AccountNotFoundException,InvalidPinNumberException {
		BankingServices services = new BankingServicesImpl();
		Scanner sc = new Scanner(System.in);
		String accountType = " ";
		long accountNo = 0;
		int pinNumber = 0;
		long accountNoTo =0;
		long accountNoFrom = 0;
		char ch = ' ';
		do {

			System.out.println("Choose  1) Create New Account 2) Deposit Amount 3) Withdraw Amount 4)Fund Transfer 5)Mini Statment 6)Account Details");

			int option = sc.nextInt();
			switch(option) {
			case 1: 	System.out.println("Enter Account  you want to open  1) Savings  2) Current:");
							int choice = sc.nextInt();
							switch(choice) {
							case 1 : accountType = "Savings";break;
							case 2 : accountType = "Current";break;
							default : System.out.println("Wrong choice!!");break;
							}
							System.out.println("Enter Initial  amount :");
							float initBalance = sc.nextFloat();
							try {
							accountNo = services.openAccount(accountType, initBalance);
							}
							catch(InvalidAmountException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("Account credentials generated :");
							System.out.println("\n" + services.getAccountDetails(accountNo));
						
			case 2 :	
							int i =0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
								System.exit(0);
							}
							i = 0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo, pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								System.exit(0);
							}
							System.out.println("Enter amount to deposit :");
							float depositAmount = sc.nextFloat();
							System.out.println("current balance :" +services.depositAmount(accountNo, depositAmount));
							break;
			case 3:	
							 i =0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
								//services.accountStatus(accountNo);
								System.exit(0);
							}
							i=0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo, pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								System.exit(0);
							}
							else {
								System.out.println("Enter amount to Withdraw :");
								float withdrawAmount = sc.nextFloat();
								try {
									System.out.println("current balance :" +services.withdrawAmount(accountNo, withdrawAmount));
								}
								catch(InsufficentAmountException e) {
									System.out.println(e.getMessage());
								}
								}
							break;

			case 4: 	
							i=0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNoFrom = sc.nextLong();
								try {
									services.getAccountDetails(accountNoFrom);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {							
								System.exit(0);
							}
							i = 0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNoFrom,pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								System.exit(0);
							}
							i=0;
							while(i<3) {
								System.out.println("Enter to whom to deposit Account No :");
								accountNoTo = sc.nextLong();
								try {
									services.getAccountDetails(accountNoFrom);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {							
								System.exit(0);
							}
							System.out.println("Enter Amount To Transfer :");
							float transferAmount = sc.nextFloat();
							services.fundTransfer(accountNoTo, accountNoFrom, transferAmount);
							System.out.println("fund transfer success");break;
			case 5:	i=0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
									System.exit(0);
							}
							i = 0;
							while(i<=3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo,pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) {
								System.exit(0);
							}
							else
								System.out.println(services.getAccountAllTransaction(accountNo));
								break;
			case 6 : System.out.println("Account Details :");
							i=0;
							while(i<3) {
								System.out.println("Enter your Account No :");
								accountNo = sc.nextLong();
								try {
									services.getAccountDetails(accountNo);
									break;
								}
								catch (AccountNotFoundException e) {
									System.out.println(e.getMessage());
									i++;
								}
							}
							if(i==3) {
									System.exit(0);
							}
							i = 0;
							while(i<3) {
								System.out.println("Enter your PIN No :");
								pinNumber = sc.nextInt();
								try {
									services.pinVerify(accountNo,pinNumber,i);
									break;
								}
								catch(InvalidPinNumberException e) {
									System.out.println(e.getMessage());
									i++;
								}
								catch(AccountBlockedException e) {
									System.out.println(e.getMessage());
								}
							}
							if(i==3) 
								System.exit(0);
							else 
								System.out.println(services.getAccountDetails(accountNo) );
							break;
			default:
			System.out.println("Wrong choice");
		
			}
			System.out.println("Want to continue services? ");
			ch = sc.next().charAt(0);
		}while( ch=='Y');
		if(ch== 'N')
			System.exit(0);
	}
}


