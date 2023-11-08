package com.qsp.sms.pstm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class insert {
public static void main(String[] args) {
	Driver driver = new Driver();
	try {
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
		//step 3:create statement
		String query="INSERT INTO student VALUES(?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, 6);
		prepareStatement.setString(2, "qwerty");
		//step 4:execute statement
		prepareStatement.execute();
		//step 5:close connection
		connection.close();
		System.out.println("Record Insert Successfully");
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
