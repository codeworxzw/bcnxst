package com.bcnx.application.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.jpos.iso.ISOException;
import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageGenerator;

public class SenderThread implements Runnable {
	private String ip;
	private int port;
	private Socket socket;
	public SenderThread(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	@Override
	public void run() {
		System.out.println("*********** START SENDER **********");
		try {
			
			ApplicationContext context = BcnxApplicationContext.getApplicationContext();
			MessageGenerator msgGenerator = (MessageGenerator) context.getBean("netMsgGen");
			socket = new Socket(ip,port);
			while(true){
				byte[] req = msgGenerator.messageBuilder();
				UtilPackage.printRequest(req);
				sendBytes(req);
				byte[] res = readBytes(socket);
				UtilPackage.printResponse(res);
				Thread.sleep(10000);
			}
		} catch (IOException | ISOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void sendBytes(byte[] data) throws IOException{
		DataOutputStream dOut = new DataOutputStream(
				socket.getOutputStream());
		dOut.write(data);
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
