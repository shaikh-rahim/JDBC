package com.qsp.sms.connector;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
	public static void main(String[] args) {
		String url= "jdbc:postgresql://localhost:5432/my-first-jdbc-program";
		String user="postgres";
		String password="root";
		
		try {
			//Step 1: Load or Register driver
			Class.forName("org.postgresql.Driver");
			
			//Step 2:Establish connection
			Connection connection =DriverManager.getConnection(url, user, password);
			
			//Step 3:Creation of Statement
			Statement statement = connection.createStatement();
			
			//Step 4:Execute of a Statement
			statement.execute("INSERT INTO student VALUES (2,'Shaikh')");
			
			//Step 5:Close Connection
			connection.close();
			
			System.out.println("Data Inserted Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
