package com.bridgelabz.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcExample
{
	public static void main(String []args) throws Exception
	{
		String name;
		int cnt=0;
		Scanner sc = new Scanner(System.in);
		ConnectionEstablishment ce = new ConnectionEstablishment();
		Statement st = ce.establishConnection();
		String sql;
		do
		{	
			System.out.println("1.Insert");
			System.out.println("2.Delete by name");
			System.out.println("3.Update address by name");
			System.out.println("4.Exit");
			System.out.println("Enter choice:=>");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1:
						System.out.println("Enter name:=");
						name = sc.next();
						System.out.println("Enter Id:=");
						int id = sc.nextInt();
						System.out.println("Enter phNumber:=");
						String phNumber = sc.next();
						System.out.println("Enter address:=");
						String address = sc.next();
						sql = "insert into Student values('"+id+"','"+name+"','"+phNumber+"','"+address+"')";
						st.executeUpdate(sql);
						System.out.println("Element inserted!");
						break;
				case 2:
						System.out.println("Enter name of Student:=>");
						name = sc.next();
						ResultSet result = st.executeQuery("select * from Student");
						while(result.next())
						{
							if(name.equals(result.getString(2)))
							{
								sql = "delete from Student where name='"+name+"'";
								st.executeUpdate(sql);
								System.out.println("Student is deleted!");
								cnt++;
								break;
							}
							else
								cnt=0;
						}
						if(cnt==0)
							System.out.println("Not Found");
						break;
				case 3:
						System.out.println("Enter name of Person has to change the address:=>");
						name = sc.next();
						System.out.println("Enter new address:=>");
						String add = sc.next();
						sql = "update Student set address='"+add+"' where name='"+name+"'";
						st.executeUpdate(sql);
						System.out.println("Address is changed!");
						break;
				case 4:
						return;
				default:
						System.out.println("Wrong Choice!");
					}
				
			}while(true);
		
		}
}