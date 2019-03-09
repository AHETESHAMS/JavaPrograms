package com.bridgelabz.visitor;

public class VisitorDemo 
{
	public static void main(String []args)
	{
		Visitor ahetesham = new VisitorImpl();
		Visitor Tom = new VisitorImpl();
		Visitor Dom = new VisitorImpl();
		LondonImpl limpl = new LondonImpl();
		VisitorImpl vimpl = new VisitorImpl();
		limpl.acceptVisitor(ahetesham);
		limpl.acceptVisitor(Dom);
		limpl.acceptVisitor(Tom);
		vimpl.Visit(ahetesham);
		vimpl.Visit(Tom);
		vimpl.Visit(Dom);
	}
}
