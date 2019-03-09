package com.bridgelabz.facade;
public class CheckBalance {
	private int actualBalance=15000;
	public boolean checkBalance(int balance)
	{
		if(balance<=actualBalance)
			return true;
		else
			return false;
	}
}
