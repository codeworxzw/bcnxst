package com.bcnx.message.acquirer.sender;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.ApplicationQueue;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.entity.NetWk;
import com.bcnx.data.service.NetWkService;
import com.bcnx.message.checker.response.ResMsgChecker;
import com.bcnx.message.service.request.MessageDefinition;

public class MessageSenderWorkImp implements MessageSenderWork {
	private static final Logger logger = Logger.getLogger(MessageSenderWorkImp.class);
	private GenericPackager packager = MessageDefinition.getGenericPackager();
	private ServerSocket socket;
	private Socket clientSocket;
	private ResMsgChecker resMsgChecker;
	private JTextArea responseArea;
	private static int port;
	
	static{
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		NetWkService service = (NetWkService) context.getBean("netWkService");
		NetWk netWk = service.getNetWk("ISS");
		port = netWk.getPort();
	}
	
	public void setResponseArea(JTextArea responseArea){
		this.responseArea = responseArea;
	}
	
	public void setResMsgChecker(ResMsgChecker resMsgChecker){
		this.resMsgChecker = resMsgChecker;
	}
	@Override
	public void doWork()  {
		
		while (true) {
			try {
				socket = new ServerSocket(port);
				clientSocket = socket.accept();
				BlockingQueue<byte[]> queue = ApplicationQueue.getQueue();
				while (true) {
					try {
						byte[] input = queue.take();
						if(input != null){
							sendBytes(input);
							byte[] data = readBytes();
							ISOMsg isoOrg = new ISOMsg();
							ISOMsg isoMsg = new ISOMsg();
							isoMsg.setPackager(packager);
							isoOrg.setPackager(packager);
							byte[] original = UtilPackage.extractMessage(input);
							UtilPackage.printResponse(data);
							UtilPackage.printDump(data);
							isoOrg.unpack(original);
							isoMsg.unpack(data);
							UtilPackage.printLogger(isoMsg);
							boolean check = resMsgChecker.checker(isoMsg,isoOrg);
							UtilPackage.printStatus(check);
							ISOMsg isoMsg1 = new ISOMsg();
							isoMsg1.setPackager(MessageDefinition.getGenericPackager());
							isoMsg1.unpack(data);
							String resData1 = UtilPackage.printRaw(UtilPackage.addHeader(data))+"\r\n";
							String resData2 = UtilPackage.printDumpString(data)+"\r\n";
							String resData3 = UtilPackage.printLoggerString(isoMsg1);
							responseArea.setText("\r\n>>>>>>>>>>>>> RESPONSE <<<<<<<<<<<<<\r\n");
							responseArea.append(resData1);
							responseArea.append(resData2);
							responseArea.append(resData3);
						}
						
					} catch (InterruptedException | ISOException e) {
						logger.debug("Exception occured while try to start send data",e);
					}

				}

			} catch (IOException e1) {
				logger.debug("Exception occured while try to establish connection",e1);
			}
		}
		
		
	}
	private void sendBytes(byte[] data) throws IOException{
		DataOutputStream dOut = new DataOutputStream(
				clientSocket.getOutputStream());
		dOut.write(data);
	}
	private byte[] readBytes() throws IOException{
		DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
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
