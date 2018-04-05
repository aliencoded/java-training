package com.aliencoded.java.core.training.sockets.serialization;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ACSerializationClientSocket {
	
	public static void main(String[] args) throws UnknownHostException, IOException, HeadlessException, ClassNotFoundException {
		
		while (true) {
			String port = JOptionPane.showInputDialog("enter the port on localmachine that is running the service");
			if(port==null) {	
				System.exit(0);
			}
			Socket socket = null;
			try {
				socket = new Socket("localhost", Integer.parseInt(port));
				
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				
				JOptionPane.showMessageDialog(null, input.readObject().toString());
				
			} catch (ConnectException e) {
				JOptionPane.showMessageDialog(null, "No service could be found running on port:"+ port);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please provide a valid port#");
			}
				
		}
		
	}
}
