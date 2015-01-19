package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.NetWk;
import com.bcnx.data.service.NetWkService;

public class NetWkSaveAction implements ActionListener {
	private JTextField hostField;
	private JTextField portField;
	public NetWkSaveAction(JTextField hostField, JTextField portField) {
		this.hostField = hostField;
		this.portField = portField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String host = hostField.getText().trim();
		String port = portField.getText().trim();
		if(host==null || host.isEmpty()){
			JOptionPane.showMessageDialog(null, "HOST IP is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(port==null || port.isEmpty()){
			JOptionPane.showMessageDialog(null, "PORT is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		NetWkService service = (NetWkService) context.getBean("netWkService");
		NetWk netWk = new NetWk();
		netWk.setIp(host);
		netWk.setPort(Integer.parseInt(port));
		netWk.setMode("ISS");
		int count = service.checkNetWk(1);
		if(count>0)
			service.update(netWk);
		else
			service.save(netWk);
	}

}
