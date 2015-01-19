package com.bcnx.ui.issuer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.bcnx.ui.acquirer.action.ResetConsoleAction;
import com.bcnx.ui.issuer.action.IssMsgStartAction;
import com.bcnx.ui.issuer.action.IssMsgStopAction;
import com.bcnx.ui.issuer.action.MessageWorker;

public class IssModePane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel requestPane;
	private JPanel setupPane;
	private JLabel requestLabel;
	public IssModePane(){
		setLayout(new GridLayout(1, 2, 1, 1));
		
		requestPane = new JPanel();
		add(requestPane);
		requestPane.setLayout(new BorderLayout(0, 0));
		
		setupPane = new JPanel();
		FlowLayout requestLayout = (FlowLayout) setupPane.getLayout();
		requestLayout.setAlignment(FlowLayout.LEFT);
		requestPane.add(setupPane, BorderLayout.NORTH);
		
		requestLabel = new JLabel("REQUEST");
		requestLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		setupPane.add(requestLabel);
		
		JButton startButton = new JButton("Start");
		startButton.setFont(new Font("Courier New", Font.BOLD, 12));
		setupPane.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		stopButton.setFont(new Font("Courier New", Font.BOLD, 12));
		setupPane.add(stopButton);
		
		JScrollPane requsetScrollPane = new JScrollPane();
		requestPane.add(requsetScrollPane, BorderLayout.CENTER);
		
		JTextArea requestConsole = new JTextArea();
		requestConsole.setWrapStyleWord(true);
		requestConsole.setLineWrap(true);
		requestConsole.setEditable(false);
		requestConsole.setBackground(Color.WHITE);
		requestConsole.setFont(new Font("Courier New", Font.PLAIN, 11));
		requsetScrollPane.setViewportView(requestConsole);
		
		JPanel responsePane = new JPanel();
		add(responsePane);
		responsePane.setLayout(new BorderLayout(0, 0));
		
		JPanel consolePane = new JPanel();
		FlowLayout responseLayout = (FlowLayout) consolePane.getLayout();
		responseLayout.setAlignment(FlowLayout.LEFT);
		responsePane.add(consolePane, BorderLayout.NORTH);
		
		JLabel responseLabel = new JLabel("RESPONSE");
		responseLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		consolePane.add(responseLabel);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Courier New", Font.BOLD, 12));
		consolePane.add(clearButton);
		
		JScrollPane responseScrollPane = new JScrollPane();
		responsePane.add(responseScrollPane, BorderLayout.CENTER);
		
		JTextArea responseConsole = new JTextArea();
		responseConsole.setWrapStyleWord(true);
		responseConsole.setLineWrap(true);
		responseConsole.setEditable(false);
		responseConsole.setBackground(Color.WHITE);
		responseConsole.setFont(new Font("Courier New", Font.PLAIN, 11));
		responseScrollPane.setViewportView(responseConsole);
		
		// add Action
		MessageWorker worker = new MessageWorker(requestConsole,responseConsole);
		startButton.addActionListener(new IssMsgStartAction(worker,startButton,stopButton));
		stopButton.addActionListener(new IssMsgStopAction(worker,startButton,stopButton));
		clearButton.addActionListener(new ResetConsoleAction(requestConsole,responseConsole));
	}
}
