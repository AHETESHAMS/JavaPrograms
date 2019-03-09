package com.bridgelabz.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TransactionExample {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData", "root", "password");
		connect.setAutoCommit(false);
		PreparedStatement ps = connect.prepareStatement("insert into Student values(?,?,?,?)");
		System.out.println("Enter Id:=>");
		int id = sc.nextInt();
		System.out.println("Enter Name:=>");
		String name = sc.next();
		System.out.println("Enter PhNumber:=>");
		String phNumber = sc.next();
		System.out.println("Enter Address:=>");
		String address = sc.next();
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, phNumber);
		ps.setString(4, address);
		ps.executeUpdate();
		System.out.println("1.commit");
		System.out.println("2.rollback");
		System.out.println("Enter choice:=");
		int ch = sc.nextInt();
		if(ch == 1)
		{
			connect.commit();
			System.out.println("Transaction Succeed!");
		}
		else
		{
			connect.rollback();
			System.out.println("Transaction Failed!");
		}
	}

}
