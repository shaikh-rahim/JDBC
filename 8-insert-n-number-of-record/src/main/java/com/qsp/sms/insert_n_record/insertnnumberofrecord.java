package com.qsp.sms.insert_n_record;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.postgresql.Driver;

public class insertnnumberofrecord {
	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", properties);
			Statement statement = connection.createStatement();
			boolean flag=true;
			byte loop=1;
			Scanner myInput=new Scanner(System.in);
			do {
				int id=0;
				String name=null;
				System.out.println("Enter id: ");
				id=myInput.nextInt();
				myInput.nextLine();
				System.out.println("Enter name: ");
				name=myInput.nextLine();
				statement.execute("INSERT INTO student VALUES("+id+",'"+name+"')");
				System.out.println("Do you want to insert more record YES/1 or NO/0");
				loop=myInput.nextByte();
				if(loop==0)
				{
					flag=false;
				}
				
			} while (flag);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
