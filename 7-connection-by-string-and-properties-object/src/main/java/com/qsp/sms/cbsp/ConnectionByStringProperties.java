package com.qsp.sms.cbsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionByStringProperties {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties"); 
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
			Statement statement = connection.createStatement();
			
			
			
			boolean flag=true;
			while (flag) {
				System.out.println("Insert Record");
				System.out.println("Enter id");
				int id=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				statement.execute("INSERT INTO student VALUES ("+id+",'"+name+"')"); 
				System.out.println("Do you want to insert record (0/1)");
				int input=sc.nextInt();
				if(input==0) {	
					flag=false;
				}
			}	  
			connection.close();
			System.out.println("RECORD INSERTED SUCCESSFULLY");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
