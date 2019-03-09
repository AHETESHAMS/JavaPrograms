package com.bridgelabz.visitor;

public class LondonImpl implements London
{
	public void acceptVisitor(Visitor v) 
	{
		System.out.println("Visitor accepted "+v);
		
	}
}
