package com.qsp.sms.urc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class count_of_updated_record {
	public static void main(String[] args) {
		try {
			//Step 1:Load or Register connection
			Class.forName("org.postgresql.Driver");
			//Step 2:Establish Connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-jdbc-program", "postgres", "root");
			//Step 3:Creation of Statement
			Statement statement = connection.createStatement();
			//Step 4:Execution of statement
			int executeUpdate = statement.executeUpdate("UPDATE student SET name='abc' WHERE id=1");
			System.out.println(executeUpdate +" "+ "Record Updated");
//			int count=0;
//			boolean flag=true;
//			Scanner myInput=new Scanner(System.in);
//			while (flag) {
//				System.out.println("Enter the Name to update:");
//				String name=myInput.nextLine();
//				System.out.println("Enter id to which the given name is to update");
//				int id=myInput.nextInt();
//				myInput.nextLine();
//				int executeUpdate = statement.executeUpdate("UPDATE student SET name='"+name+"' WHERE id="+id+"");
//				count++;
//				System.out.println("Do you want to update more record YES/1 or NO/0");
//				int userInput=myInput.nextInt();
//				myInput.nextLine();
//				if (userInput==0) {
//					flag=false;
//				}
//			}
			//Step 5:Close Connection
			connection.close();
//			System.out.println(count +" "+ "Record Updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
