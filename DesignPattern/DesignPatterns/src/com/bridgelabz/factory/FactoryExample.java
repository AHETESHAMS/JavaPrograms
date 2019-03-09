package com.bridgelabz.factory;

import java.util.Scanner;

public class FactoryExample
{
	public static void main(String []args)
	{
		Person s1 = new Student();
		Person t1 = new Teacher();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of student:=");
		String studentName = sc.next();
		System.out.println("Enter ph Number of student:=");
		String studentPhNumber = sc.next();
		System.out.println("Enter Address of student:=");
		String studentAddress = sc.next();
		System.out.println("Enter name of teacher:=");
		String teacherName = sc.next();
		System.out.println("Enter ph Number of teacher:=");
		String teacherPhNumber = sc.next();
		System.out.println("Enter Address of teacher:=");
		String tacherAddress = sc.next();
		s1.setName(studentName);
		s1.setPhNumber(studentPhNumber);
		s1.setAddress(studentAddress);
		t1.setName(teacherName);
		t1.setPhNumber(teacherPhNumber);
		t1.setAddress(tacherAddress);
		System.out.println(s1.getName());
		System.out.println(s1.getPhNumber());
		System.out.println(s1.getAddress());
		System.out.println(	t1.getName());
		System.out.println(t1.getPhNumber());
		System.out.println(t1.getAddress());
		
	}	
	
}
