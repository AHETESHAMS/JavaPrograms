package com.bridgelabz.facade;

public class CheckPassword {
	private String password = "007";
	public boolean checkPassword(String pass)
	{
		if(password.equals(pass))
			return true;
		else
			return false;
	}
}
