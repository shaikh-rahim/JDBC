package com.qsp.sms.ps;

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

public class insert_n_record {
public static void main(String[] args) {
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//step 2:establish connection
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
		//step 3:create statement
		String query="INSERT INTO student VALUES(?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		Scanner myInput=new Scanner(System.in);
		byte loop=1;
		boolean flag=true;
		do {
			System.out.println("ENTER ID: ");
			int id=myInput.nextInt();
            myInput.nextLine();
			prepareStatement.setInt(1, id);
			System.out.println("ENTER NAME: ");
			String name=myInput.nextLine();
			prepareStatement.setString(2, name);
			prepareStatement.execute();
			System.out.println("Do you want to add record YES/1 or NO/0");
			loop =myInput.nextByte();
			if(loop==0)
			{
				flag=false;
			}
		} while (flag);
		System.out.println("RECORD INSERTED !!!!!!!!!!!");
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
