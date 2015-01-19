/**
 * 
 */
package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ResetConsoleAction implements ActionListener {
	private JTextArea requestArea;
	private JTextArea responseArea;
	public ResetConsoleAction(JTextArea requestArea, JTextArea responseArea) {
		this.requestArea = requestArea;
		this.responseArea = responseArea;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		requestArea.setText("");
		responseArea.setText("");
	}

}
