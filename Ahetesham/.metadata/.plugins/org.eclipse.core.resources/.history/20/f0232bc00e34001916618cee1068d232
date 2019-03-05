/**
 * Agenda: Creating a stack and performing operations of Stack 
 */
package com.bridgelabz.dsutility;
//class Stack: It is a Class contains functions which performs operations on Stack
public class Stack {
	
	char[] items = new char [100];
	int top = -1;
	//It is a Function which performs push operation
	public void push(char x) 
	{
		if(isFull())
		{
			System.out.println("Stack is full!");
		}
		else
		{
			items[++top] = x;
		}
	}
	//It is a function which performs pop operation
	public char pop()	
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty!");
			return '\0';
		}
		else
		{
			char element  = items[top];
			top--;
			return element;
		}
	}
	public boolean isFull()
	{
		return(top == 99)? true : false;
	}
	public boolean isEmpty()
	{
		return(top == -1)? true : false;
	}
}
