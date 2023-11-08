package com.qsp.sms.csp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.postgresql.Driver;

public class call_stored_procedure {

	public static void main(String[] args) {
		Connection connection=null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
			CallableStatement callableStatement = connection.prepareCall("call fetch_student(?,?,?)");
			callableStatement.setInt(1, 3);
			callableStatement.registerOutParameter(2, Types.NUMERIC);
			callableStatement.registerOutParameter(3, Types.VARCHAR);
			callableStatement.execute();
			System.out.println("id : " + callableStatement.getBigDecimal(2));
			System.out.println("name :" + callableStatement.getString(3));
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
