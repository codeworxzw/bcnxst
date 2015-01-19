package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class NetWkBoxAction implements ActionListener {
	private JTextField ipField;
	private JTextField portField;
	private JCheckBox editBox;
	
	public NetWkBoxAction(JTextField ipField, JTextField portField,
			JCheckBox editBox) {
		this.ipField = ipField;
		this.portField = portField;
		this.editBox = editBox;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(editBox.isSelected()){
			ipField.setEditable(true);
			ipField.setEnabled(true);
			portField.setEditable(true);
			portField.setEnabled(true);
		}
		else{
			ipField.setEditable(false);
			ipField.setEnabled(false);
			portField.setEditable(false);
			portField.setEnabled(false);
		}

	}

}
