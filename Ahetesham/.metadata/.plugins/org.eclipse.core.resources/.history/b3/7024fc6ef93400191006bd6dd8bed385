package com.bridgelabz.datastructure;
import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.LinkedList;
public class PalindromeChecker {

	public static void main(String[] args) 
	{
		System.out.print("Enter any string:");
        String inputString = Utility.singleStringInput();
        char []charArray = inputString.toCharArray(); 
        LinkedList palindromeQueue = new LinkedList();
        System.out.println("Queue is created");
        for (int i = inputString.length()-1; i >=0; i--) {
        	palindromeQueue.insertAtLast(Character.toString(charArray[i]));
     }
     String reverseString = "";
     for(int i=0;i<inputString.length();i++) 
     {
         reverseString = reverseString+palindromeQueue.deleteAtFirst();   
     }
        System.out.println("Reverse String is:="+reverseString);
        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

	}

}
