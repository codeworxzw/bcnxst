package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.ApplicationQueue;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.checker.response.ResMsgChecker;
import com.bcnx.message.service.request.MessageDefinition;

public class AcqModeStartUpAction implements ActionListener {
	private static Logger logger = Logger.getLogger(AcqModeStartUpAction.class);
	private JTextArea responseArea;
	private JComboBox<String> requestBox;
	public AcqModeStartUpAction(JTextArea responseArea, JComboBox<String> requestBox){
		this.responseArea = responseArea;
		this.requestBox = requestBox;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ApplicationContext context = BcnxApplicationContext
					.getApplicationContext();
			String selectedItem = (String) requestBox.getSelectedItem();
			String selectedRes = new String();
			if (selectedItem.equals("NETWORK")) {
				selectedRes = "netResMsgChecker";
			} else if (selectedItem.equals("BALANCE")) {
				selectedRes = "balResMsgChecker";
			} else if (selectedItem.equals("WITHDRAWAL")) {
				selectedRes = "cwdResMsgChecker";
			} else if (selectedItem.equals("REVERSAL")) {
				selectedRes = "revResMsgChecker";
			} else {
				selectedRes = "netResMsgChecker";
			}
			ResMsgChecker resMsgChecker = (ResMsgChecker) context
					.getBean(selectedRes);
			byte[] res = ApplicationQueue.getQueue().take();
			//resMsgChecker.checker(isoMsg, isoOrg)
			ISOMsg isoMsg1 = new ISOMsg();
			isoMsg1.setPackager(MessageDefinition.getGenericPackager());
			isoMsg1.unpack(res);
			String resData1 = UtilPackage.printRaw(UtilPackage.addHeader(res))
					+ "\r\n";
			String resData2 = UtilPackage.printDumpString(res) + "\r\n";
			String resData3 = UtilPackage.printLoggerString(isoMsg1);
			responseArea
					.setText("\r\n|>>>>>>>>>>>>> RESPONSE <<<<<<<<<<<<<|\r\n");
			responseArea.append(resData1);
			responseArea.append(resData2);
			responseArea.append(resData3);
		} catch (ISOException | InterruptedException e1) {
			logger.debug("Exception occured while check response message", e1);
		}
		
	}

}
