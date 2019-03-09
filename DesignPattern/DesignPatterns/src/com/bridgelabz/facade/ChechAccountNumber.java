package com.bridgelabz.facade;
public class ChechAccountNumber {
	private String accountNumber = "6865453427";
	public boolean chechAccountNumber(String number)
	{
		if(accountNumber.equals(number))
			return true;
		else
			return false;
	}
}
