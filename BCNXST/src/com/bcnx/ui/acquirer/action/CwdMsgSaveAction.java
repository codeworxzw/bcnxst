package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.CwdMsg;
import com.bcnx.data.service.CwdMsgService;

public class CwdMsgSaveAction implements ActionListener {
	private JComboBox<String> de02Field;
	private JComboBox<String> de03Field;
	private JTextField de04Field;
	private JTextField de28Field;
	private JComboBox<String> de32Field;
	private JTextField de41Field;
	private JTextField de42Field;
	private JTextField de43Field;
	private JTextField de52Field;
	
	public CwdMsgSaveAction(JComboBox<String> de02Field, JComboBox<String> de03Field,
			JTextField de04Field, JTextField de28Field, JComboBox<String> de32Field,
			JTextField de41Field, JTextField de42Field, JTextField de43Field,
			JTextField de52Field) {
		this.de02Field = de02Field;
		this.de03Field = de03Field;
		this.de04Field = de04Field;
		this.de28Field = de28Field;
		this.de32Field = de32Field;
		this.de41Field = de41Field;
		this.de42Field = de42Field;
		this.de43Field = de43Field;
		this.de52Field = de52Field;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String de02 = (String) de02Field.getSelectedItem();
		String de03 = (String) de03Field.getSelectedItem();
		String de04 = de04Field.getText();
		String de28 = de28Field.getText();
		String de32 = (String) de32Field.getSelectedItem();
		String de41 = de41Field.getText();
		String de42 = de42Field.getText();
		String de43 = de43Field.getText();
		String de52 = de52Field.getText();
		if(de02 == null || de02.isEmpty()){
			JOptionPane.showMessageDialog(null, "CARD NUMBER is Empty", "ERROR MESSSAGE", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(de03 == null || de03.isEmpty()){
			JOptionPane.showMessageDialog(null, "PROCESSING CODE is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(de04 == null || de04.isEmpty()){
			JOptionPane.showMessageDialog(null, "Amount is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(de28==null||de28.isEmpty()){
			JOptionPane.showMessageDialog(null, "FEE is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(de32 == null || de32.isEmpty()){
			JOptionPane.showMessageDialog(null, "Acquirer ID is empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(de41 == null || de41.isEmpty()){
			JOptionPane.showMessageDialog(null, "ATM ID is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(de42 == null || de42.isEmpty()){
			JOptionPane.showMessageDialog(null, "ATM Name is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(de43 == null || de43.isEmpty()){
			JOptionPane.showMessageDialog(null, "ATM Location is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(de52==null || de52.isEmpty()){
			JOptionPane.showMessageDialog(null, "PIN Block is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		CwdMsgService service = (CwdMsgService) context.getBean("cwdMsgService");
		String de02Val = String.format("%-16s", de02);
		String de03Val = String.format("%-6s", de03);
		String de04Val = String.format("%-12s", de04);
		String de28Val = String.format("%-9s", de28);
		String de32Val = String.format("%-6s", de32);
		String de41Val = String.format("%-8s", de41);
		String de42Val = String.format("%-15s", de42);
		String de43Val = String.format("%-40s", de43);
		String de52Val = String.format("%-16s", de52);
		CwdMsg cwdMsg = new CwdMsg();
		cwdMsg.setDe02(de02Val);
		cwdMsg.setDe03(de03Val);
		cwdMsg.setDe04(de04Val);
		cwdMsg.setDe28(de28Val);
		cwdMsg.setDe32(de32Val);
		cwdMsg.setDe41(de41Val);
		cwdMsg.setDe42(de42Val);
		cwdMsg.setDe43(de43Val);
		cwdMsg.setDe52(de52Val);
		int chk = service.check();
		if(chk>0)
			service.update(cwdMsg);
		else
			service.save(cwdMsg);
	}

}
