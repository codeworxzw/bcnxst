package com.bcnx.application.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.bcnx.application.utility.UtilPackage;

public class ReceiverThread implements Runnable {
	private  ServerSocket serverSocket;
	private int port;
	public ReceiverThread(int port){
		this.port = port;
	}
	@Override
	public void run() {
		System.out.println("************ START RECEIVER *************");
		try {
			serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			while (true) {
				byte[] data = readBytes(socket);
				UtilPackage.printResponse(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private byte[] readBytes(Socket socket) throws IOException{
		DataInputStream dis = new DataInputStream(socket.getInputStream());
	    byte blen[] = new byte[4];
	    dis.read(blen);
	    int len = Integer.parseInt(new String(blen));
	    byte buf[] = new byte[len];
	    if(len>0){
	    	dis.readFully(buf);
	    }
	    return buf;
	}

}
