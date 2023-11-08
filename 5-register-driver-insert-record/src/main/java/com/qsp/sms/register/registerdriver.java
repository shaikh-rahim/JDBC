package com.qsp.sms.register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;
  class registerdriver {
public static void main(String[] args) {
	try {
		//step 1:Register Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//step 2:establish connection
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", "postgres", "root");
//		//step 3:Create Statement
		Statement statement = connection.createStatement();
		//Step 4:Execute of a Statement
		statement.execute("INSERT INTO student VALUES (2,'Shaikh');INSERT INTO student VALUES (3,'abc')");
		//Step 5:Close Connection
		connection.close();
		
		System.out.println("Data Inserted Successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
