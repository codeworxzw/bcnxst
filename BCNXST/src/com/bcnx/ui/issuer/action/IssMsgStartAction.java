package com.bcnx.ui.issuer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class IssMsgStartAction implements ActionListener {
	private JButton startButton;
	private JButton stopButton;
	private MessageWorker startUpServer;
	public IssMsgStartAction(MessageWorker startUpServer,JButton startButton, JButton stopButton) {
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.startUpServer = startUpServer;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!startUpServer.isCancelled()){
			startUpServer.execute();
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
		}
	}

}
