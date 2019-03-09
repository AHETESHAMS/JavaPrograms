package com.bridgelabz.singleton;

public class BillPughSingletonExample {
	
public BillPughSingletonExample() 
{
		
}
private static class BillPughSingleton
{
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
}
public static BillPughSingleton getInstance()
{
	return BillPughSingleton.INSTANCE;
}
public static void testBillPughSingleton()
{
	System.out.println("Instance got created!");
}
	public static void main(String[] args) 
	{
		BillPughSingleton bps = BillPughSingletonExample.getInstance();
	}

}
