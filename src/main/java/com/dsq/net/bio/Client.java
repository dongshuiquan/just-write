package com.dsq.net.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	
	static boolean stop;
	public static void main(String[] args) {
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 7070));
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(12);
			while(!stop) {
				read(socket);
			}
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void read(Socket socket) throws IOException {
		byte[] bytes = new byte[100];
		InputStream inputStream = socket.getInputStream();
		int read = inputStream.read(bytes);
		if(read == -1) {
			stop = true;
			return;
		}
		
		String s = new String(bytes, 0, read);
		System.out.println(s);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("I am Client.".getBytes());
		outputStream.flush();
	}
	

}
