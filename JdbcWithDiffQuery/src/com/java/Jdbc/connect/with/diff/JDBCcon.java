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

public class JDBCcon {

	public static void main(String[] args) {
		try {
			
			//Step 1 : Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver install..");
			
			//Step 2  : get the connection using driver manager 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbuser","root","toor");
			Scanner scanner =new Scanner(System.in);
			
			System.out.println("enter the name : ");
			String pname = scanner.next();
			System.out.println("enter the pass: ");
			int ppws = scanner.nextInt();
			String query = "select * from emp where User = ? and Pass = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,pname);
			ps.setInt(2,ppws);
			System.out.println(ps);
			ResultSet rs  = ps.executeQuery();
			while(rs.next());
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver(jar file ) not found !!!");

		} catch (SQLException e) {
			
			System.out.println("plz check the path .....");
		}

	}

}
