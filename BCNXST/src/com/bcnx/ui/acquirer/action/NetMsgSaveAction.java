package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.NetMsg;
import com.bcnx.data.service.NetMsgService;

public class NetMsgSaveAction implements ActionListener {
	private JComboBox<String> de70Field;
	public NetMsgSaveAction(JComboBox<String> de70Field){
		this.de70Field = de70Field;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String de70 = (String) de70Field.getSelectedItem();
		if(de70==null||de70.isEmpty()){
			JOptionPane.showMessageDialog(null, "DE70 is empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		NetMsgService service = (NetMsgService) context.getBean("netMsgService");
		NetMsg netMsg = new NetMsg();
		netMsg.setDe70(de70);
		int count = service.check();
		if(count>0)
			service.update(netMsg);
		else
			service.save(netMsg);
	}

}
