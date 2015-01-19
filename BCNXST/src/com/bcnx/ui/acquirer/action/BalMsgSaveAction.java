package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.BalMsg;
import com.bcnx.data.service.BalMsgService;

public class BalMsgSaveAction implements ActionListener {
	private JComboBox<String> de02Box;
	private JComboBox<String> de03Box;
	private JTextField de28Field;
	private JComboBox<String> de32Box;
	private JTextField de41Field;
	private JTextField de42Field;
	private JTextField de43Field;
	private JTextField de52Field;
	
	public BalMsgSaveAction(JComboBox<String> de02Box, JComboBox<String> de03Box,
			JTextField de28Field, JComboBox<String> de32Box, JTextField de41Field,
			JTextField de42Field, JTextField de43Field, JTextField de52Field) {
		this.de02Box   = de02Box;
		this.de03Box   = de03Box;
		this.de28Field = de28Field;
		this.de32Box   = de32Box;
		this.de41Field = de41Field;
		this.de42Field = de42Field;
		this.de43Field = de43Field;
		this.de52Field = de52Field;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String de02 = (String) de02Box.getSelectedItem();
		String de03 = (String) de03Box.getSelectedItem();
		String de28 = de28Field.getText().trim();
		String de32 = (String) de32Box.getSelectedItem();
		String de41 = de41Field.getText().trim();
		String de42 = de42Field.getText().trim();
		String de43 = de43Field.getText().trim();
		String de52 = de52Field.getText().trim();
		
		if(de02 == null || de02.isEmpty()){
			JOptionPane.showMessageDialog(null, "CARD NUMBER is Empty", "ERROR MESSSAGE", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(de03 == null || de03.isEmpty()){
			JOptionPane.showMessageDialog(null, "PROCESSING CODE is Empty", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
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
		BalMsgService service = (BalMsgService) context.getBean("balMsgService");
		BalMsg balMsg = new BalMsg();
		String de02Val = String.format("%-16s", de02);
		String de03Val = String.format("%-6s", de03);
		String de28Val = String.format("%-9s", de28);
		String de32Val = String.format("%-6s", de32);
		String de41Val = String.format("%-8s", de41);
		String de42Val = String.format("%-15s", de42);
		String de43Val = String.format("%-40s", de43);
		String de52Val = String.format("%-16s", de52);
		balMsg.setDe02(de02Val);
		balMsg.setDe03(de03Val);
		balMsg.setDe28(de28Val);
		balMsg.setDe32(de32Val);
		balMsg.setDe41(de41Val);
		balMsg.setDe42(de42Val);
		balMsg.setDe43(de43Val);
		balMsg.setDe52(de52Val);
		
		int chk = service.checkRecord();
		if(chk > 0)
			service.update(balMsg);
		else
			service.save(balMsg);
	}

}
