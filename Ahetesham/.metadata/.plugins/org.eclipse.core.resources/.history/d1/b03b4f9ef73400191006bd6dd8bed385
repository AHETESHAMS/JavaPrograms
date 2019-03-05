package com.bridgelabz.dsutility;
import java.io.*;

import com.BridgeLabz.FunctionalPrograms.Utility;
public class DSUtility {
	
	/**
	 * Function: Used to Read a File
	 * @param word: Array of String 
	 * @return: Array of String
	 */
	public static String[] readFile(String []word)
	{
		File file = new File("xyz.txt");
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			while(br.readLine()!=null)
			{
				str = str+br.readLine();
			}
			word = str.split(" ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return word;
	}

	/**
	 * Function: Used to Write a File
	 * @param wordList: Is an Object of LinkedList
	 * @return: wordList of Type LinkedList
	 */
	public static LinkedList writeFile(LinkedList wordList) 
		{
			try
				{
					
					BufferedWriter bw = new BufferedWriter(new FileWriter("xyz.txt",true));
					
					
					while(!wordList.isEmpty()) {
						bw.write(wordList.get()+" ");
					}
		            bw.flush();
					bw.close();
				}
			catch(Exception e) 
				{
					e.printStackTrace();
				}
				return wordList;
		}
	/**
	 * Function: Checking if Pair is matching in the expression.
	 * @param charachter1: It is of type character holding opening parenthesis
	 * @param charachter2: It is of type character holding closing parenthesis
	 * @return: boolean
	 */
	
	public static boolean isMatchingPair(char charachter1,char charachter2)
	{
		if(charachter1 == '(' && charachter2 == ')')
			return true;
		else if(charachter1 == '{' && charachter2 == '}')
			return true;
		else if(charachter1 == '[' && charachter2 == ']')
			return true;
		else
			return false;
			
	}
	
	/**
	 * Function: Checks Whether parenthesis are not balanced
	 * @param exp: character array
	 * @return: boolean
	 */
	public static boolean areParenthesBalance(char exp[])
	{
		Stack st = new Stack();
		for(int i=0;i<exp.length;i++)
		{
			if(exp[i] == '(' || exp[i] == '{' || exp[i] == '[')
				st.push(exp[i]);
			if(exp[i] == ')' || exp[i] == '}' || exp[i] == ']')
			{
				if(st.isEmpty())
				{
					return false;
				}
				else if(!isMatchingPair(st.pop(),exp[i]))
				{
					return false;
				}
			}
		}
		if(st.isEmpty())
			return true;
		else
		{
			return false;
		}	
	}
	
	public static int deposit(int balance)
	{
		int amnt=0;
		System.out.println("Enter Amount to Deposit:=");
		amnt = Utility.singleIntegerInput();
		balance = balance+amnt;
		return balance;
	}
	
	public static int withDraw(int balance)
	{
		int amnt=0;
		System.out.println("Enter the Cash Amount to Withdraw:=");
		amnt = Utility.singleIntegerInput();
		if(amnt > balance)
			throw new ArithmeticException("Insufficient Balance");
		else
		{
			balance = balance-amnt;
		}
		return balance;
	}
	
		
}
