package com.bridgelabz.facade;

import java.util.Scanner;

public class FacadeExample {
	public static void main(String []args)
	{
		Scanner sc =new Scanner(System.in);
		ChechAccountNumber an =new ChechAccountNumber();
		CheckBalance cb = new CheckBalance();
		CheckPassword cp = new CheckPassword();
		boolean accountNumberFound = an.chechAccountNumber("6865453427");
		if(accountNumberFound)
			System.out.println("Account Number is Valid!");
		else
			System.out.println("Account Number is not Valid!");
		System.out.println("Enter the amount to withdraw:=");
		int withdrawAmount = sc.nextInt();
		boolean balanceResult = cb.checkBalance(withdrawAmount);
		if(balanceResult)
			System.out.println("Withdraw amount is valid!");
		else
			System.out.println("Withdraw amount is not valid!");
		System.out.println("Enter the password:=");
		String pass = sc.next();
		boolean passwordResult = cp.checkPassword(pass);
		if(passwordResult)
			System.out.println("Password is valid");
		else
			System.out.println("Password is not valid");
		
	}
}
