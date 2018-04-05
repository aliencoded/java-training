package com.aliencoded.java.core.training.sockets.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.aliencoded.java.core.training.sockets.serialization.domain.SerializedAccount;

public class ACServerSocket2 {
	
	private static int accountId = 1;
	public static void main(String[] args) throws IOException {
		System.out.println("starting server 2... on port 9010");
		
		ServerSocket listener = new ServerSocket(9010);
		
		try {
			while(true) {
				Socket socket = listener.accept();
				try{ 
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					
					SerializedAccount account = new SerializedAccount(accountId, "account created in Server2");
					out.writeObject(account);
					accountId++;
					
					
				} finally {
					socket.close();
				}
			}
		} finally {
			listener.close();
		}
	}
}
