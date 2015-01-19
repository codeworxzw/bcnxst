package com.bcnx.ui.acquirer.action;

import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.NetWk;
import com.bcnx.data.service.NetWkService;

public class AcqModePaneAction implements AncestorListener {
	private JTextField hostField;
	private JTextField portField;
	public AcqModePaneAction(JTextField hostField, JTextField portField) {
		this.hostField = hostField;
		this.portField = portField;
	}

	@Override
	public void ancestorAdded(AncestorEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		NetWkService service = (NetWkService) context.getBean("netWkService");
		NetWk netWk = service.getNetWk("ISS");
		if(netWk == null)
			return;
		hostField.setText(netWk.getIp());
		portField.setText(String.valueOf(netWk.getPort()));
	}

	@Override
	public void ancestorMoved(AncestorEvent e) {
	}

	@Override
	public void ancestorRemoved(AncestorEvent e) {
	
	}

}
