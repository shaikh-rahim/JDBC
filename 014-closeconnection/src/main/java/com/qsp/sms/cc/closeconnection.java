package com.qsp.sms.cc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class closeconnection {

	public static void main(String[] args) {
		Driver driver=new Driver();
		Connection connection=null;
		try {
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection != null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
