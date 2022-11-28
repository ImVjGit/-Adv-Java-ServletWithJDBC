package com.fbs.advance.Lec.First;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Servlet")
public class LoginServlet extends HttpServlet {
	
	public void service(HttpServletRequest Request , HttpServletResponse Response) throws IOException {
		//System.out.println("hello web from server ");
		/*
		 * int a = 10; PrintWriter pw = Response.getWriter();
		 * //pw.println("<h1>Helloo i am server</h1>" +a);
		 * pw.write("<h1>Heloo web from server </h1>");
		 */
		
		String name = Request.getParameter("user");//read it 
		String pass = Request.getParameter("password");
		PrintWriter pw = Response.getWriter();//show on display 
		//pw.println("Username is : "+name);
		//pw.println("Sirname  is : "+pass);
		System.out.println("username : "+name);
		System.out.println("pass ; "+pass);
		Validation v = new Validation(name, pass);
	if(v.isValid())
	{
		pw.println("Welcome in employee id");
		System.out.println(name+"  "+pass);
	}else {
		pw.println("Sorry invalid Pass and user  ");
	}
	
	
	}
}
