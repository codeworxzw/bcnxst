package com.bcnx.ui.acquirer.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingWorker;

public class MsgSenderAction implements ActionListener {
	private JButton startButton;
	public MsgSenderAction(JButton startButton){
		this.startButton = startButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		startButton.setEnabled(false);;
		new StartMessageSender().execute();
	}
	
	private class StartMessageSender extends SwingWorker<Void, Void>{
		
		@Override
		protected Void doInBackground() throws Exception {
			
			
			
			return null;
		}
		
	}

}
