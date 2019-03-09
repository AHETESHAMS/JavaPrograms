package com.bridgelabz.visitor;

public class VisitorImpl implements Visitor 
{
	public void Visit(Visitor v)
	{
		System.out.println("Visit is successful! "+v);
	}
}
