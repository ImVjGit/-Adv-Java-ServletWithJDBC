package com.fbs.socket.baisc;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		System.out.println("server running ...");
		try {
			ServerSocket  serversocket = new ServerSocket (20000);
			
			
			Socket socket = serversocket.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String msg =dis.readUTF();
			System.out.println("msg from client : "+ msg);
			serversocket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
