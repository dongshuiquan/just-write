package com.dsq.net.nio;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NioClient {

	static int count;
	static long currentTimeMillis = 0;

	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {

			serverSocket = new ServerSocket(7070);
			while (true) {
				Socket socket = serverSocket.accept();
				currentTimeMillis = System.currentTimeMillis();

				long time = 0;
				while (time < 3_000) {
					time = System.currentTimeMillis() - currentTimeMillis;
					read(socket);
				}
				socket.close();
				count = 0;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void read(Socket socket) throws IOException {
		byte[] bytes = new byte[100];
		InputStream inputStream = socket.getInputStream();
		int read = inputStream.read(bytes);
		String s = new String(bytes, 0, read);
		System.out.println(s);
		count++;
		System.out.println("count " + count);
		OutputStream outputStream = socket.getOutputStream();

		String response = "From server : " + s;
		outputStream.write(response.getBytes());
		outputStream.flush();
	}

}
