package com.bcnx.message.issuer.receiver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.checker.request.VerifyMsgSpec;
import com.bcnx.message.service.request.MessageDefinition;

public class MessageThread{
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
	
	public void run() {	
		try {
			byte[] data = readBytes();
			// byte[] data = UtilPackage.extractMessage(incoming);
			ISOMsg isoMsg = new ISOMsg();
			isoMsg.setPackager(MessageDefinition.getGenericPackager());
			isoMsg.unpack(data);
			// check message structure
			logger.info("\r\n------------------ Server Receive Resquest Message -----------------\r\n");
			byte[] incoming = UtilPackage.addHeader(data);
			UtilPackage.printRequest(incoming);
			UtilPackage.printDump(data);
			UtilPackage.printLogger(isoMsg);

			// output to console
			String data1 = UtilPackage.printRaw(data) + "\r\n";
			String data2 = UtilPackage.printDumpString(data) + "\r\n";
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

			data1 = UtilPackage.printRaw(output) + "\r\n";
			data2 = UtilPackage.printDumpString(resBytes) + "\r\n";
			data3 = UtilPackage.printLoggerString(resIsoMsg);
			responseArea.setText("\r\n>>>>>>>>>> RESPONSE <<<<<<<<<<\r\n");
			responseArea.append(data1);
			responseArea.append(data2);
			responseArea.append(data3);
			sendBytes(output);
			logger.info("\r\n============= Transaction End =============\r\n");
		} catch (IOException e) {
			logger.debug("IOException occur while processing message request",
					e);
		} catch (ISOException e) {
			logger.debug("ISOException occur while processing message request",
					e);
		}
	}
	private void sendBytes(byte[] data) throws IOException{
		DataOutputStream dOut = new DataOutputStream(
				socket.getOutputStream());
		dOut.write(data);
	}
	private byte[] readBytes() throws IOException{
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
