package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Login 
{
	public static void main(String []args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "password");
		String sql = "select * from userData where userName=?";
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Enter the User Name:=");
		String userName = sc.nextLine();
		System.out.println("Enter the Password:=");
		String password = sc.nextLine();
		PreparedStatement pstate = connect.prepareStatement(sql);
		pstate.setString(1, userName);
		ResultSet data = pstate.executeQuery();
		if(data.next() && password.equals(data.getString("password"))) {
			System.out.println("Login successful.");
		}else {
			System.out.println("Your credential are wrong.");
		}
	}
}
