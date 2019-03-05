/**
 * Agenda: 
 * a.Read a List of Numbers from a file and arrange it ascending Order in a Linked List
 *   Take user input for a number, if found then pop the number out of the list 
 *   else insert the number in appropriate position.
 * b. I/P ­> Read from file the list of Numbers and take user input for a new number
 * c. Logic ­> Create a Ordered Linked List having Numbers in ascending order.
 * d. O/P ­> The List of Numbers to a File.
 */
package com.bridgelabz.datastructure;
import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.DSUtility;
import com.bridgelabz.dsutility.LinkedList;
public class OrderedList {

	public static void main(String[] args) {
		
		String element,str;
		//Creation of Linked List Object
		LinkedList wordList = new LinkedList();
		String word[] = null;
		//Calling to readFile function to read a file
		word = DSUtility.readFile(word);
		// Using for each loop to add item in linked list
		for(String item : word)
		{
			wordList.insertAtLast(item);
		}
		//Calling to show function to display Linked List
		wordList.show();
		System.out.println("Enter a Word:=");
		//calling to function to get an input from user
		element = Utility.singleStringInput();
		//calling to search function to search element in Linked List
		boolean found = Utility.searchString(word, element);
		if(found)
			wordList.delete(element);
		else
		{
			wordList.insertAtLast(element);
		}
		wordList.sortList();
		//Calling to show function to display Linked List
		wordList.show();
		//Calling to writeFile function to write a file a file
		wordList = DSUtility.writeFile(wordList);
		
		
	}

}
