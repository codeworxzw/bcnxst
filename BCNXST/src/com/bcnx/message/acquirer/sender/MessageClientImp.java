package com.bcnx.message.acquirer.sender;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.entity.NetWk;
import com.bcnx.data.service.NetWkService;
import com.bcnx.message.checker.response.ResMsgChecker;
import com.bcnx.message.service.request.MessageDefinition;

public class MessageClientImp implements MessageClient {
	private static final Logger logger = Logger.getLogger(MessageClientImp.class);
	private GenericPackager packager = MessageDefinition.getGenericPackager();
	private Socket clientSocket;
	private ResMsgChecker resMsgChecker;
	private static String host;
	private static int port;
	static{
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		NetWkService service = (NetWkService) context.getBean("netWkService");
		NetWk netWk = service.getNetWk("ISS");
		host = netWk.getIp();
		port = netWk.getPort();
	}
	@Override
	public void setResMsgChecker(ResMsgChecker resMsgChecker){
		this.resMsgChecker = resMsgChecker;
	}
	@Override
	public byte[] runEchoClient(byte[] input) throws UnknownHostException, IOException {
		try {
			clientSocket = new Socket(host,port);
			clientSocket.setSoTimeout(30000);
			
			sendBytes(input,0,input.length);
			byte[] data = readBytes();
			ISOMsg isoOrg = new ISOMsg();
			ISOMsg isoMsg = new ISOMsg();
			isoMsg.setPackager(packager);
			isoOrg.setPackager(packager);
			byte[] original = UtilPackage.extractMessage(input);
			byte[] raw = UtilPackage.extractMessage(data);
			UtilPackage.printResponse(data);
			UtilPackage.printDump(data);
			isoOrg.unpack(original);
			isoMsg.unpack(raw);
			UtilPackage.printLogger(isoMsg);
			
			boolean check = resMsgChecker.checker(isoMsg,isoOrg);
			UtilPackage.printStatus(check);
			return data;
		} catch (UnknownHostException e) {
			logger.debug("UnknownHostException occur while trying to connect server", e);
		} catch (IOException e) {
			logger.debug("IOException occur while trying to access data",e);
		} catch (ISOException e) {
			logger.debug("ISOException occur while trying to extract data",e);
		}
		return null;
	}
	
	private void sendBytes(byte[] data, int offset, int length) throws IOException {
		if(length < 0)
			throw new IllegalArgumentException("Negative length not allowed");
		if(offset < 0 || offset >= data.length)
			throw new IndexOutOfBoundsException("Out of bounds "+offset);
		OutputStream out = clientSocket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeInt(length);
		if(length > 0)
			dos.write(data, offset, length);
	}
	
	private byte[] readBytes() throws IOException{
		InputStream in = clientSocket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		int len = dis.readInt();
	    byte[] data = new byte[len];
	    if (len > 0) {
	        dis.readFully(data);
	    }
	    return data;
	}
}
