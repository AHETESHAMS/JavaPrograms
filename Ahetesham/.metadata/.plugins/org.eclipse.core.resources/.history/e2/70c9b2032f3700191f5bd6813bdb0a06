/**
 * Agenda: Creating a stack and performing operations of Stack 
 */
package com.bridgelabz.dsutility;
//class Stack: It is a Class contains functions which performs operations on Stack
public class Stack {
	
	char[] items = new char [100];
	int top = -1;
	/**
	 * Function : To push Element in a Stack
	 * @param x : Is a character value
	 */
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
	/**
	 * Function : To pop Element from Stack
	 * @return : Character value
	 */
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
	/**
	 * Function : Which checks whether stack is full or not 
	 * @return : boolean
	 */
	public boolean isFull()
	{
		return(top == 99)? true : false;
	}
	/**
	 * Function : To check whether Stack is Empty or not
	 * @return : boolean
	 */
	public boolean isEmpty()
	{
		return(top == -1)? true : false;
	}
}
