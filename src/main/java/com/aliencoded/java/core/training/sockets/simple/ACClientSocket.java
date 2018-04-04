package com.aliencoded.java.core.training.sockets.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ACClientSocket {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		while (true) {
			String port = JOptionPane.showInputDialog("enter the port on localmachine that is running the service");
			if(port==null) {
				System.exit(0);
			}
			Socket socket = null;
			try {
				socket = new Socket("localhost", Integer.parseInt(port));
				BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
				String answer = input.readLine();
				JOptionPane.showMessageDialog(null, answer);
				
			} catch (ConnectException e) {
				JOptionPane.showMessageDialog(null, "No service could be found running on port:"+ port);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please provide a valid port#");
			}
				
		}
		
	}
}
