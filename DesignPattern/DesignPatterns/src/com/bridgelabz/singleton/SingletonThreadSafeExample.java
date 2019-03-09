package com.bridgelabz.singleton;

public class SingletonThreadSafeExample 
{

	public static void main(String[] args) 
	{
		
		SingletonThreadSafe sts = SingletonThreadSafe.getInstance();
		sts.testSingletonThreadSafe();
	}
	
}
class SingletonThreadSafe
{
	private static SingletonThreadSafe instance;
	
	public SingletonThreadSafe() {}
	public static synchronized SingletonThreadSafe getInstance() 
	{
		if(instance == null)
			instance = new SingletonThreadSafe();
		return instance; 
	}
	public void testSingletonThreadSafe()
	{
		System.out.println("Object got created!");
	}
}
