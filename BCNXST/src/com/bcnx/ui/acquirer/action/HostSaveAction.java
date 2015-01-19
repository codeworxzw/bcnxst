package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.NetWk;
import com.bcnx.data.service.NetWkService;

public class HostSaveAction implements ActionListener {
	private JTextField ipField;
	private JTextField portField;
	public HostSaveAction(JTextField ipField,JTextField portField){
		this.ipField = ipField;
		this.portField = portField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String ipText = ipField.getText().trim();
		String portText = portField.getText().trim();
		
		if(ipText == null || ipText.isEmpty()){
			JOptionPane.showInternalMessageDialog(null, "HOST IP is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(portText == null || portText.isEmpty()){
			JOptionPane.showMessageDialog(null, "HOST Port is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		NetWk netWk = new NetWk();
		netWk.setId(1);
		netWk.setIp(ipText);
		netWk.setPort(Integer.parseInt(portText));
		netWk.setMode("ACQ");
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		NetWkService service = (NetWkService) context.getBean("netWkService");
		int chck = service.checkNetWk(1);
		if(chck==0)
			service.save(netWk);
		else
			service.update(netWk);
	}

}
