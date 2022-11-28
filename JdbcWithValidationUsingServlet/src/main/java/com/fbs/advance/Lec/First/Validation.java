package com.fbs.advance.Lec.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Validation {

	String username;
	String Password;

	public Validation() {

	}

	public Validation(String Us, String Pa) {
		this.username = Us;
		this.Password = Pa;
	}

	public boolean isValid() {

//if(this.username.equals(username)&&this.Password.equals(Password))
		/*
		 * if(this.username.equals("admin")&&this.Password.equals("123")) { return true;
		 * 
		 * } return false;
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.err.println("Driver loaded....");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbuser", "root", "toor");
			String query = "select * from emp where User = ? and Pass = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("statement created...");
			ps.setString(1, this.username);
			ps.setString(2, this.Password);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			/*option 1 
			 * if (rs.next() == true) { return true; } else { return false; }
			 */
			
			/*option 2 
			 * if (rs.next()) { return true; } else { return false; }
			 */
			
			return rs.next();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
