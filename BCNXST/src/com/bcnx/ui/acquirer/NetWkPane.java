package com.bcnx.ui.acquirer;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bcnx.ui.acquirer.action.AcqModePaneAction;
import com.bcnx.ui.acquirer.action.NetWkBoxAction;
import com.bcnx.ui.acquirer.action.NetWkSaveAction;

public class NetWkPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel hostLabel;
	private JTextField hostField;
	private JLabel portLabel;
	private JTextField portField;
	private JCheckBox editBox;
	private JButton saveButton;

	public NetWkPane(){
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.setLayout(flowLayout);
		hostLabel = new JLabel("HOST");
		hostField = new JTextField();
		portLabel = new JLabel("PORT");
		portField = new JTextField();
		editBox = new JCheckBox("Edit");
		saveButton = new JButton("Save");
		
		hostLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		add(hostLabel);
		
		
		hostField.setEnabled(false);
		hostField.setEditable(false);
		hostField.setFont(new Font("Courier New", Font.BOLD, 12));
		hostField.setColumns(16);
		add(hostField);
		
		portLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		add(portLabel);
		
		portField.setEnabled(false);
		portField.setEditable(false);
		portField.setFont(new Font("Courier New", Font.BOLD, 12));
		portField.setColumns(6);
		add(portField);
		
		editBox.setFont(new Font("Courier New", Font.BOLD, 12));
		add(editBox);
		
		saveButton.setFont(new Font("Courier New", Font.BOLD, 12));
		add(saveButton);
		
		// action insert
		editBox.addActionListener(new NetWkBoxAction(hostField,portField,editBox));
		addAncestorListener(new AcqModePaneAction(hostField,portField));
		saveButton.addActionListener(new NetWkSaveAction(hostField,portField));
	}
}
