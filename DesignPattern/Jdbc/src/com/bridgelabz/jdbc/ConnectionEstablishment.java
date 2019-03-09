package com.bridgelabz.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class ConnectionEstablishment 
{
	public Statement establishConnection() throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData", "root", "password");
		System.out.println("Connection established");
		return connect.createStatement();
	}
}