package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.ApplicationQueue;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.checker.response.ResMsgChecker;
import com.bcnx.message.service.request.MessageDefinition;
import com.bcnx.message.service.request.MessageGenerator;

public class AcqMsgAction implements ActionListener {
	private static Logger logger = Logger.getLogger(AcqMsgAction.class);
	private JComboBox<String> requestBox;
	private JTextArea requestArea;
	private JTextArea responseArea;
	public AcqMsgAction(JComboBox<String> requestBox, JTextArea requestArea, JTextArea responseArea) {
		this.requestBox = requestBox;
		this.requestArea = requestArea;
		this.responseArea = responseArea;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		AcqMsgSwingWorker worker = new AcqMsgSwingWorker(requestBox,requestArea,responseArea);
		worker.execute();
	}
	private class AcqMsgSwingWorker extends SwingWorker<Void, Void>{
		private JComboBox<String> requestBox;
		private JTextArea requestArea;
		private JTextArea responseArea;
		
		public AcqMsgSwingWorker(JComboBox<String> requestBox,
				JTextArea requestArea, JTextArea responseArea) {
			this.requestBox = requestBox;
			this.requestArea = requestArea;
			this.responseArea = responseArea;
		}

		@Override
		protected Void doInBackground() throws Exception {
			ApplicationContext context = BcnxApplicationContext.getApplicationContext();
			String selectedItem = (String) requestBox.getSelectedItem();
			String selectedReq = new String();
			String selectedRes = new String();
			if(selectedItem.equals("NETWORK")){
				selectedReq = "netMsgGen";
				selectedRes = "netResMsgChecker";
			}
			else if(selectedItem.equals("BALANCE")){
				selectedReq = "balMsgGen";
				selectedRes = "balResMsgChecker";
			}
			else if(selectedItem.equals("WITHDRAWAL")){
				selectedReq = "cwdMsgGen";
				selectedRes = "cwdResMsgChecker";
			}
			else if(selectedItem.equals("REVERSAL")){
				selectedReq = "revMsgGen";
				selectedRes = "revResMsgChecker";
			}
			else{
				selectedReq = "netMsgGen";
				selectedRes = "netResMsgChecker";
			}
			MessageGenerator messageService = (MessageGenerator) context.getBean(selectedReq);
			
			try {
				byte[] msg = messageService.messageBuilder();
				byte[] data  = UtilPackage.extractMessage(msg);
				ISOMsg isoMsg = new ISOMsg();
				isoMsg.setPackager(MessageDefinition.getGenericPackager());
				isoMsg.unpack(data);
				String data0 = UtilPackage.printRaw(msg)+"\r\n";
				String data1 = UtilPackage.printDumpString(msg)+"\r\n";
				String data2 = UtilPackage.printLoggerString(isoMsg);
				requestArea.setText("\r\n|>>>>>>>>>>>>> REQUEST <<<<<<<<<<<<<|\r\n");
				requestArea.append(data0);
				requestArea.append(data1);
				requestArea.append(data2);
				ApplicationQueue.getQueue().put(msg);
				// send request and get the response
				//ResMsgChecker resMsgChecker = (ResMsgChecker) context.getBean(selectedRes);
				/*MessageClient messageClient = new MessageSenderThread();
				messageClient.setResMsgChecker(resMsgChecker);
				//byte[] res = messageClient.runEchoClient(msg);
				ApplicationQueue.getQueue().put(msg);
				
				ISOMsg isoMsg1 = new ISOMsg();
				isoMsg1.setPackager(MessageDefinition.getGenericPackager());
				isoMsg1.unpack(res);
				String resData1 = UtilPackage.printRaw(UtilPackage.addHeader(res))+"\r\n";
				String resData2 = UtilPackage.printDumpString(res)+"\r\n";
				String resData3 = UtilPackage.printLoggerString(isoMsg1);
				responseArea.setText("\r\n>>>>>>>>>>>>> RESPONSE <<<<<<<<<<<<<\r\n");
				responseArea.append(resData1);
				responseArea.append(resData2);
				responseArea.append(resData3);
				*/
				
			} catch (ISOException e1) {
				logger.debug("Exception occured while try to c");
			}
			return null;
		}
		
	}
}
