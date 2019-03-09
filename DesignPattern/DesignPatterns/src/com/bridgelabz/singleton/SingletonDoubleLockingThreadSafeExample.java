package com.bridgelabz.singleton;

public class SingletonDoubleLockingThreadSafeExample 
{

	public static void main(String[] args) 
	{
		SingletonDoubleLockingThreadSafe dl = SingletonDoubleLockingThreadSafe.getInstance();
		dl.testSingletonDoubleLockingThreadSafe();

	}

}
class SingletonDoubleLockingThreadSafe
{
	private static SingletonDoubleLockingThreadSafe instance;
	public SingletonDoubleLockingThreadSafe() {}
	public static SingletonDoubleLockingThreadSafe getInstance()
	{
		if(instance == null)
		{
			synchronized (SingletonDoubleLockingThreadSafe.class) 
			{
				if(instance == null)
					instance = new SingletonDoubleLockingThreadSafe();
			}
		}
		return instance;
	}
	public void testSingletonDoubleLockingThreadSafe() 
	{
		System.out.println("Instance got created");
	}
	
}
