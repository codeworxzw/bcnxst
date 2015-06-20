package com.bcnx.ui.issuer.action;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.NetWk;
import com.bcnx.data.service.NetWkService;
import com.bcnx.message.checker.request.VerifyMsgSpec;
import com.bcnx.message.issuer.receiver.MessageThread;

public class MessageWorker extends SwingWorker<Void, Void> {
	private static final Logger logger = Logger.getLogger(MessageWorker.class);
	private JTextArea requestArea;
	private JTextArea responseArea;
	private ServerSocket serverSocket;
	public MessageWorker(JTextArea console, JTextArea responseArea) {
		this.requestArea = console;
		this.responseArea = responseArea;
	}
	@Override
	protected Void doInBackground() throws Exception {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		NetWkService service = (NetWkService) context.getBean("netWkService");
		VerifyMsgSpec verifyMsgSpec = (VerifyMsgSpec) context.getBean("verifyMsgSpec");
		NetWk netWk = service.getNetWk("ISS");
		int port = netWk.getPort();
		logger.info(" >>>>>>> Server Start");
		try{
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				socket.setKeepAlive(true);
				MessageThread thread = new MessageThread(socket, verifyMsgSpec, requestArea,responseArea);
				thread.run();
			}
		}
		catch(IOException ex){
			logger.debug("Exception occured while try to execute server mode",ex);
		}
		return null;
	}

}
