package com.qsp.sms.be;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.postgresql.Driver;

public class BatchExecution {

	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
			Statement statement = connection.createStatement();
			//
			statement.addBatch("INSERT INTO student VALUES (1,'Abc')");
			statement.addBatch("INSERT INTO student VALUES (2,'pqr')");
			statement.addBatch("INSERT INTO student VALUES (3,'xyz')");
			statement.addBatch("INSERT INTO student VALUES (4,'abcd')");
			//
			int[] executeBatch = statement.executeBatch();
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
