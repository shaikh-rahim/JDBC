package com.qsp.sms.sp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class storedProcedure {

	public static void main(String[] args) {
		Connection connection=null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
			CallableStatement callableStatement = connection.prepareCall("CALL insert_student(8,'okk')");
//			callableStatement.setInt(1, 7);
//			callableStatement.setString(2, "Shivam");
			callableStatement.execute();
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
		finally {
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}

}
