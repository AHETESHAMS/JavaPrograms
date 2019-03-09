package com.bridgelabz.singleton;

public class SingletonLazyExample
{
	public static void main(String []args)
	{
		SingletonLazy l = SingletonLazy.singletonLazy();
		l.testSingletonLazy();
	}
}
class SingletonLazy
{
	private static SingletonLazy instance;
	private SingletonLazy() {}
	public static SingletonLazy singletonLazy()
	{
		if(instance == null)
			instance = new SingletonLazy();
		return instance;
	}
	public void testSingletonLazy()
	{
		System.out.println("Instance got created!");
	}
}
