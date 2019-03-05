package com.bridgelabz.datastructure;
import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.DSUtility;
import com.bridgelabz.dsutility.Queue;
public class BankingCashCounter {

	public static void main(String[] args) throws Exception {
		
		int balance = 10000;
		int capacity=0,bankoperations;
		boolean queueresult;
		System.out.println("Balance is:="+balance);
		System.out.println("Enter the Capacity:=");
		capacity = Utility.singleIntegerInput();
		Queue queue = new Queue(capacity); 
		for(int i=0;i<=capacity;i++)
		{
			queueresult = queue.enqueue(1);
			if(queueresult)
			{
				System.out.println("Queue is Full!");

			}	
		}
		do
		{
			System.out.println("1.Deposit Cash");
			System.out.println("2.Withdraw Cash");
			System.out.println("Please Enter Your Choice:=");
			bankoperations = Utility.singleIntegerInput();
			if(bankoperations == 1)
			{
				balance = DSUtility.deposit(balance);
				System.out.println("Balance is:="+balance);
				System.out.println("Deposit is Successful!");
				queue.dequeue();
				System.out.println("Dequeue is successful!");
				capacity--;
			}
			else if(bankoperations == 2)
			{
				balance = DSUtility.withDraw(balance);	
				System.out.println("Balance is:="+balance);
				queue.dequeue();
				System.out.println("Dequeue is successful!");
				capacity--;
			}	
			else
				throw new Exception("Wrong Choice!");
			
		}while(capacity>0);	

	}

}
