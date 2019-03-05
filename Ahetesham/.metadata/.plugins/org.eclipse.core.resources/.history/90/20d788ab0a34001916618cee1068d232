/**
 * Agenda:

 * 	a.Read the Text from a file, split it into words and arrange it as Linked List.
	Take a user input to search a Word in the List. If the Word is not found then add it
	to the list, and if it found then remove the word from the List. In the end save the
	list into a file.
	
	b. I/P ­> Read from file the list of Words and take user input to search a Text

	c. Logic ­> Create a Unordered Linked List. The Basic Building Block is the Node
	Object. Each node object must hold at least two pieces of information. One reference to
	the data field and second the reference to the next node object.
	
	d. O/P ­> The List of Words to a File.
 */
package com.bridgelabz.datastructure;
import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.*;

public class UnOrderesList {
	
	public static void main(String[] args) {
		
			String element;
			//Creation of Linked List Object
			LinkedList wordList = new LinkedList();
			String word[] = null;
			//Calling to readFile function to read a file
			word = DSUtility.readFile(word);
			
			for(String item : word)
			{
				wordList.insertAtLast(item);
			}
			//Calling to show function to display Linked List
			wordList.show();
			System.out.println("Enter a Number:=");
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
			//Calling to show function to display Linked List
			wordList.show();
			//Calling to writeFile function to write a file a file
			wordList = DSUtility.writeFile(wordList);
			
	}

}
