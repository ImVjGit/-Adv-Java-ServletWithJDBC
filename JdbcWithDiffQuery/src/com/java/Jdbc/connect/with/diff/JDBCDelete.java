package com.java.Jdbc.connect.with.diff;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class JDBCDelete {

	public static void main(String[] args) {
		try {
			
			//Step 1 : Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver install..");
			
			//Step 2  : get the connection using driver manager 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbemp","root","toor");
			
			System.out.println("connected to Databases...");
			Statement stat = conn.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Delete User using name ");
			System.out.println("Enter a name  : ");
			String name = scanner.next();
			String query = "Delete from employee where name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("Delete User  Successfull......");	
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver(jar file ) not found !!!");

		} catch (SQLException e) {
			
			System.out.println("plz check the path .....");
		}

	}

}
