package com.bcnx.message.issuer.receiver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.checker.request.VerifyMsgSpec;
import com.bcnx.message.service.request.MessageDefinition;

public class MessageThread implements Runnable{
	private static final Logger logger = Logger.getLogger(MessageThread.class);
	protected Socket socket;
	private VerifyMsgSpec verifyMsgSpec;
	private JTextArea requestArea;
	private JTextArea responseArea;
	public MessageThread(Socket socket, VerifyMsgSpec verifyMsgSpec, JTextArea requestArea, JTextArea responseArea) {
		this.socket = socket;
		this.verifyMsgSpec = verifyMsgSpec;
		this.requestArea = requestArea;
		this.responseArea = responseArea;
	}
	@Override
	public void run() {	
		try {
			byte[] incoming = readBytes();
			byte[] data = UtilPackage.extractMessage(incoming);
			ISOMsg isoMsg = new ISOMsg();
			isoMsg.setPackager(MessageDefinition.getGenericPackager());
			isoMsg.unpack(data);
			// check message structure
			logger.info("\r\n------------------ Server Receive Resquest Message -----------------\r\n");
			UtilPackage.printRequest(incoming);
			UtilPackage.printDump(incoming);
			UtilPackage.printLogger(isoMsg);
			
			// output to console
			String data1 = UtilPackage.printRaw(incoming)+"\r\n";
			String data2 = UtilPackage.printDumpString(data)+"\r\n";
			String data3 = UtilPackage.printLoggerString(isoMsg);
			requestArea.setText("\r\n>>>>>>>>>>>>> REQUEST <<<<<<<<<<<<<\r\n");
			requestArea.append(data1);
			requestArea.append(data2);
			requestArea.append(data3);
			
			// validate message format
			byte[] output = verifyMsgSpec.checkMsg(isoMsg);
			byte[] resBytes = UtilPackage.extractMessage(output);
			ISOMsg resIsoMsg = new ISOMsg();
			resIsoMsg.setPackager(MessageDefinition.getGenericPackager());
			resIsoMsg.unpack(resBytes);
			UtilPackage.printResponse(output);
			UtilPackage.printDump(output);
			UtilPackage.printLogger(resIsoMsg);
			
			data1 = UtilPackage.printRaw(output)+"\r\n";
			data2 = UtilPackage.printDumpString(resBytes)+"\r\n";
			data3 = UtilPackage.printLoggerString(resIsoMsg);
			responseArea.setText("\r\n>>>>>>>>>> RESPONSE <<<<<<<<<<\r\n");
			responseArea.append(data1);
			responseArea.append(data2);
			responseArea.append(data3);
			
			int len = output.length;
			sendBytes(output,0,len);
			logger.info("\r\n============= Transaction End =============\r\n");
		} catch (IOException e) {
			logger.debug("IOException occur while processing message request", e);
		} catch (ISOException e) {
			logger.debug("ISOException occur while processing message request",e);
		}
	}
	private void sendBytes(byte[] data, int offset, int length) throws IOException {
		if(length < 0)
			throw new IllegalArgumentException("Negative length not allowed");
		if(offset < 0 || offset >= data.length)
			throw new IndexOutOfBoundsException("Out of bounds "+offset);
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeInt(length);
		if(length > 0)
			dos.write(data,offset,length);
	}
	private byte[] readBytes() throws IOException{
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		int len = dis.readInt();
	    byte[] data = new byte[len];
	    if (len > 0) {
	        dis.read(data);
	    }
	    return data;
	}

}
