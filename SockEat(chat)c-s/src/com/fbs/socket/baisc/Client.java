/*
Date : 1 september 2022
Topic : Socket 
l

*/
package com.fbs.socket.baisc;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		try {
			Socket SenderSocket = new Socket("localhost", 20000);
			String clinetmsg = "i am client ";
			DataOutputStream dio = new DataOutputStream(SenderSocket.getOutputStream());
			dio.writeUTF(clinetmsg);
			SenderSocket.close();
			dio.close();

		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
