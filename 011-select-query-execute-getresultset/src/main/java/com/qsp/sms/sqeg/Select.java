package com.qsp.sms.sqeg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager
			.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", "postgres", "root");
			Statement statement = connection.createStatement();
			boolean execute = statement.execute("SELECT * FROM student");
			if (execute) {
				ResultSet resultSet = statement.getResultSet();
				while(resultSet.next())
				{
					System.out.println("id:" +resultSet.getInt(1));
					System.out.println("name:" +resultSet.getString(2));
				}
				System.out.println("record exist");
			} else {
				System.out.println("record not exist");
			}
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
