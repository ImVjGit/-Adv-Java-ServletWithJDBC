package com.java.Jdbc.connect.with.diff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBCInsertValue {

	public static void main(String[] args) {
		try {
			Scanner scannar = new Scanner(System.in);

			// Step 1 : Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver install..");

			// Step 2 : get the connection using driver manager
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbemp", "root", "toor");

			// Step 3 : create statement and query
			Statement stat = conn.createStatement();
			System.out.println("connected to Databases...");

			System.out.println("Enter the UId  : ");
			int uid = scannar.nextInt();
			System.out.println("ENter the Name : ");
			String name = scannar.next();
			System.out.println("enter the Sirname : ");
			String sirname = scannar.next();

			System.out.println("Enter the Address : ");
			String add = scannar.next();
			System.out.println("Enter the age : ");
			int age = scannar.nextInt();
			System.out.println("enter the mobile number :");
			int number = scannar.nextInt();

			String query = "insert into employee values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			ps.setString(2, name);
			ps.setString(3, sirname);

			ps.setString(4, add);
			ps.setInt(5, age);
			ps.setInt(6, number);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("record save in Databases");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("driver(jar file ) not found !!!");

		} catch (SQLException e) {

			System.out.println("plz check the path .....");
		}

	}

}
