package com.bridgelabz.dsutility;

public class Stack {
	
	char[] items = new char [100];
	int top = -1;
	public void push(char x) {
		if(top==99)
		{
			System.out.println("Stack is full!");
		}
		else
		{
			items[++top] = x;
		}
	}
	public char pop()	
	{
		if(top == -1)
		{
			System.out.println("Stsck is Empty!");
			return '\0';
		}
		else
		{
			char element  = items[top];
			top--;
			return element;
		}
	}
	public boolean isEmpty()
	{
		return(top == -1)? true : false;
	}
}
