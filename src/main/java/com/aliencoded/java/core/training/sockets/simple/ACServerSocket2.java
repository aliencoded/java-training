package com.aliencoded.java.core.training.sockets.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class ACServerSocket2 {
	
	public static void main(String[] args) throws IOException {
		System.out.println("starting server 2... on port 9010");
		
		ServerSocket listener = new ServerSocket(9010);
		
		try {
			while(true) {
				Socket socket = listener.accept();
				try{ 
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(LocalDate.now() + " from server2");
				} finally {
					socket.close();
				}
			}
		} finally {
			listener.close();
		}
	}
}
