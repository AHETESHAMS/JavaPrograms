package com.bridgelabz.jdbc;
import java.sql.*;
import java.util.Scanner;
public class PreparedStatementExample 
{
	public static void main(String []args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData", "root", "password");
		String sqlUpdate = "update Student set address=? where name=? and id =?";
		PreparedStatement stmntUpdate = connect.prepareStatement(sqlUpdate);
		System.out.println("Enter the name of Person to change address:=>");
		String name = scan.nextLine();
		System.out.println("Enter the new address:=>");
		String add = scan.nextLine();
		stmntUpdate.setString(1,add);
		stmntUpdate.setString(2, name);
		stmntUpdate.setInt(3, 2);
		stmntUpdate.executeUpdate();
		
	}
}
