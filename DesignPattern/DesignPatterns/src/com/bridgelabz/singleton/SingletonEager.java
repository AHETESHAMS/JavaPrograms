package com.bridgelabz.singleton;

public class SingletonEager {
	
	public static void main(String []args)
	{
		Abc obj1 = Abc.getInstace();
		Abc obj2 = Abc.getInstace();
		System.out.println(obj1);
		System.out.println(obj2);
	}	
}


class Abc
{
	static 	Abc obj = new Abc();
	private Abc() 
	{

	}
	public static Abc getInstace()
	{
		return obj;
	}
}
