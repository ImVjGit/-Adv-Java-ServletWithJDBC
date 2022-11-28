package com.java.Jdbc.connect.with.diff;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class JDBDisplayAll {

	public static void main(String[] args) {
		try {
			
			//Step 1 : Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver install..");
			
			//Step 2  : get the connection using driver manager 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbemp","root","toor");
			
			System.out.println("connected to Databases...");
			
			//Step 3  : create statement  and query 
			Statement stat = conn.createStatement();
			String query = "select * from employee";
			
			//Step 4 :execute the query using resultset method   
			ResultSet rs = stat.executeQuery(query);
			
			
			//step 5 : Display all data using get command  and while loop 
			while(rs.next()) {
				System.out.println("Uid : "+rs.getInt(1)
									+"\nName :"+rs.getString(2)
									+"\nSirname : "+rs.getString(3)
									+"\nAddress :"+rs.getString(4)
									+"\nAge : "+rs.getInt(5)
									+"\nMobile :"+rs.getInt(6)
									+"\n ");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver(jar file ) not found !!!");

		} catch (SQLException e) {
			
			System.out.println("plz check the path .....");
		}

	}

}
