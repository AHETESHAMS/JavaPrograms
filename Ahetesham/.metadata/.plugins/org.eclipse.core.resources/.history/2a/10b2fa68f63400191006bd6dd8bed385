/**
 * Agenda : 
 */
package com.bridgelabz.datastructure;
import java.io.FileWriter;
import java.io.IOException;

import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.DSUtility;
import com.bridgelabz.dsutility.LinkedList;
public class HashingFunction {

	public static void main(String[] args) throws IOException {
		
		String element;
		String t;
		int reminder,integerNumber;
		//Creation of Linked List Object
		LinkedList wordList[] = new LinkedList[11];
		String numbers[] = null;
		
		for(int j=0;j<=10;j++)
		{
			wordList[j] = new LinkedList();
		}
		//Calling to readFile function to read a file
		numbers = DSUtility.readFile(numbers);
		
		for(int i=0;i<numbers.length;i++)
		{
			integerNumber = Integer.parseInt(numbers[i]);
			reminder = integerNumber%11;
			wordList[reminder].insertAtLast(numbers[i]);
			
		}
		//Calling to show function to display Linked List
		for(int i=0;i<11;i++)
		{
			if(wordList[i].isEmpty())
				continue;
			wordList[i].show();
		}	
		System.out.println("Enter a Number:=");
		//calling to function to get an input from user
		element = Utility.singleStringInput();
		reminder = Integer.parseInt(element)%11;
		
		//calling to search function to search element in Linked List
		
		if(wordList[reminder].search(element))
			wordList[reminder].delete(element);
		else
		{
			wordList[reminder].insertAtLast(element);
		}
		//Calling to show function to display Linked List
		for(int i=0;i<11;i++)
		{
			if(wordList[i].isEmpty())
				continue;
			wordList[i].show();
		}	
		FileWriter fw = new FileWriter("xyz.txt");
		fw.write("");
		fw.close();
		//Calling to writeFile function to write a file a file
		for(int i=0;i<11;i++)
		{
			if(wordList[i].isEmpty())
				continue;
			LinkedList list= DSUtility.writeFile(wordList[i]);
		}	
	}

}
