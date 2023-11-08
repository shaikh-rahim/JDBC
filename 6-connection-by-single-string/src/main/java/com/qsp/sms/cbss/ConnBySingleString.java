package com.qsp.sms.cbss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnBySingleString {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program?user=postgres&password=root");
			Statement statement = connection.createStatement();
			statement.execute("INSERT INTO student VALUES(5,'xyz')");
			connection.close();
			System.out.println("Record inserted successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
