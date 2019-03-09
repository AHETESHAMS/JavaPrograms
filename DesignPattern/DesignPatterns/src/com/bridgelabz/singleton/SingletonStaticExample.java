package com.bridgelabz.singleton;
class SingletonStaticExample
{
	public static void main(String []args)
	{
		SingletonStatic s = SingletonStatic.getInstance();
		s.testInstance();
	}
}
class SingletonStatic
{
	private static SingletonStatic instance;
	private SingletonStatic() {}
	static 
	{	try
		{
			instance = new SingletonStatic();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static SingletonStatic getInstance()
	{
		return instance;
	}
	public void testInstance()
	{
		System.out.println("Instance got created!");
	}
	
}