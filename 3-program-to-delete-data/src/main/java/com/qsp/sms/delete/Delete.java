package com.qsp.sms.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
public static void main(String[] args) {
	try {
		//Step 1:Load or register driver
		Class.forName("org.postgresql.Driver");
		//Step 2:Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", "postgres", "root");
		//Step 3:Create Statement
		Statement statement = connection.createStatement();
		//Step 4:Execution Statement
		statement.execute("DELETE from student WHERE id=1");
		//Step 5:Close Connection
		connection.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
