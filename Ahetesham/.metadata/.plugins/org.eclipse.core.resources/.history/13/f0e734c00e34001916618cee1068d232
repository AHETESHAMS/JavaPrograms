package com.bridgelabz.datastructure;

import java.util.ArrayList;
import java.util.List;

import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.Stack;

public class AnagramStack {

	public static void main(String[] args) {
		List<Integer> prime = new ArrayList<>(); 
		List <Integer> anagram = new ArrayList<>(); 
		int num1,anagramnum;
		int num2,cnt=0;
		boolean anagramResult=false;	
		
					/*Prime*/
		
		for(num1=1;num1<=1000;num1++)
		{			
			cnt = Utility.checkPrime(num1);	
			if(cnt==0)
			{
				prime.add(num1);
			}
		}
		System.out.println("List of Prime Numbers:");
		System.out.println(prime);
		
					/*Anagram*/
		
		for(int i=7;i<prime.size();i++)
		{

			num1 = prime.get(i);
			for(int j=i+1;j<prime.size();j++)
			{
				num2 = prime.get(j);
				String str1 = Integer.toString(num1);
				String str2 = Integer.toString(num2);
				anagramResult = Utility.checkAnagrams(str1,str2);
				if(anagramResult)
				{
					anagram.add(num1);
					break;
				}	
					
			}
			
		}
		
		System.out.println("List of Anagram Prime Numbers:");
		System.out.println(anagram);
		
			/*Anagrams push and pop using Stack*/
		
		Stack anagramStack = new Stack();
		char a;
		int b;
		for(int i=0;i<anagram.size();i++)
		{
			anagramnum = anagram.get(i);
			a=(char) anagramnum;
			anagramStack.push(a);
			System.out.println(anagramnum+" is Pushed to Stack");
			
		}
		System.out.println();
		while(!anagramStack.isEmpty())
		{
			a = anagramStack.pop();
			b = (int)a;
			System.out.println(b+" is Popped from stack");
		}

	}

}
