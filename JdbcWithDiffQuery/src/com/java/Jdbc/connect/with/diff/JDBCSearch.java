
package com.java.Jdbc.connect.with.diff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCSearch {

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
			System.out.println("Search Name hear ");
			System.out.println("Enter a name : ");
			String nm = scanner.next();
			String query = "select * from employee where name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
		//	System.out.println("Query : "+query);
			ps.setString(1,nm);
			ResultSet rs  = ps.executeQuery();
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
