package com.bcnx.ui.issuer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class IssMsgStopAction implements ActionListener {
	private JButton startButton;
	private JButton stopButton;
	private MessageWorker startUpServer;
	public IssMsgStopAction(MessageWorker startUpServer,JButton startButton, JButton stopButton) {
		this.startButton = startButton;
		this.stopButton = stopButton;
		this.startUpServer = startUpServer;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(">>>>>>>> server stop");
		startUpServer.cancel(true);
		startButton.setEnabled(true);
		stopButton.setEnabled(false);
	}

}
