package com.bridgelabz.datastructure;

import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.Queue;

public class PalindromeChecker {

	public static void main(String[] args) 
	{
		int j=0;
		System.out.print("Enter any string:");
        String inputString = Utility.singleStringInput();
        Queue queue = new Queue(4);
        System.out.println("Queue is created");
        for (int i = inputString.length()-1; i >=0; i--) {
        	System.out.println("In loop");
            queue.add(inputString.charAt(i));
     }
     String reverseString = "";
     while (!queue.isEmpty(queue)) 
     {
    	 System.out.println("In While loop");
         reverseString = reverseString+queue.remove();
         System.out.println("String is:="+reverseString);
     }
        System.out.println("String is:="+reverseString);
        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

	}

}
