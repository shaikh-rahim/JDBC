package com.qsp.sms.beups;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.postgresql.Driver;

public class batchExecution_using_prepareStatement {

	public static void main(String[] args) {
		try {
			//Register Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			//Establish Connection
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
			//Create Statement
			String query ="INSERT INTO student VALUES(?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			//
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "Rahim");
			prepareStatement.addBatch();
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "Shaikh");
			prepareStatement.addBatch();
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "abc");
			prepareStatement.addBatch();
			int[] executeBatch = prepareStatement.executeBatch();
			//
			for (int i = 0; i < executeBatch.length; i++) {
				System.out.println("Number of rows affected :" + executeBatch[i]);
			}
			connection.close();
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