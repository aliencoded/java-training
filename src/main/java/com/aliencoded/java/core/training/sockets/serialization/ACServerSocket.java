package com.aliencoded.java.core.training.sockets.serialization;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.aliencoded.java.core.training.sockets.serialization.domain.Account;

public class ACServerSocket {

	private static int accountId = 1;
	public static void main(String[] args) throws IOException {
		System.out.println("starting server 1... on port 9000");
		
		ServerSocket listener = new ServerSocket(9000);
		
		try {
			while(true) {
				Socket socket = listener.accept();
				try{ 
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					
					Account account = new Account(accountId, "account created in Server1");
					out.writeObject(account);
					accountId++;
				} catch (NotSerializableException e) {
					System.out.println("unable to serialize");
					
				} finally {
					socket.close();
				}
			}
		} finally {
			listener.close();
		}
	}

}
