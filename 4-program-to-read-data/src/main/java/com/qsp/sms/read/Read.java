package com.qsp.sms.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
public static void main(String[] args) {
	try {
		//Step 1:Load or Register Driver
		Class.forName("org.postgresql.Driver");
		//step 2:Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", "postgres", "root");
		//Step 3:Create Statement
		Statement statement = connection.createStatement();
		//Step 4:Execution Statement
		ResultSet resultset = statement.executeQuery("SELECT * FROM student");
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			
		}
	}
		catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
