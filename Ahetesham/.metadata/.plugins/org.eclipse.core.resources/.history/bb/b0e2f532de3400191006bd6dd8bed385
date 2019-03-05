package com.bridgelabz.datastructure;

import com.BridgeLabz.FunctionalPrograms.Utility;
import com.bridgelabz.dsutility.LinkedList;
import com.bridgelabz.dsutility.Stack;

public class CalendarStack {

	public static void main(String[] args) {
		int year;
		int month;
		int startDayOfMonth;
		int spaces;
		LinkedList calendarStack1 = new LinkedList();
		LinkedList calendarStack2 = new LinkedList();
		System.out.println("Enter the Year");
		year = Utility.singleIntegerInput();
		System.out.println("Enter the Start Day of month");
		startDayOfMonth = Utility.singleIntegerInput();
		spaces = startDayOfMonth;
		String [] months = {"","January","February","March","April","May","June","July","August",
							"September","October","November","December"};
		int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int M=1;M<=12;M++)
		{
			if((year%400==0)&&(year%100!=0)||(year%4==0)&&M==2)
				days[M]=29;
			System.out.println("          "+ months[M] + " " + year);
			System.out.println("______________________________________");
            System.out.println("   Sun  Mon  Tue  Wed  Thu  Fri  Sat");
            spaces = (days[M-1] + spaces)%7;
            for(int i=1;i<=days[M];i++)
            {
            	calendarStack1.insertAtLast(Integer.toString(i));
            }
            for(int i=1;i<=days[M];i++)
            {
            	calendarStack2.insertAtLast(calendarStack1.deleteAtLast());
            }
            String item = calendarStack1.deleteAtLast();
            for (int i = 0; i < spaces; i++)
                System.out.print("     ");
            for(int i=1;i<=days[M];i++)
            {
         
            	 System.out.printf(" %3d ", Integer.parseInt(calendarStack2.deleteAtLast()));
            	if (((i + spaces) % 7 == 0) || (i == days[M])) System.out.println();
            }	
            System.out.println();

		}   
		

	}
	
}
