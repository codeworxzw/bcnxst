package com.bcnx.ui.acquirer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.bcnx.ui.acquirer.action.AcqMsgAction;
import com.bcnx.ui.acquirer.action.ResetConsoleAction;

public class AcqModePane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel requestPane;
	private JPanel setupPane;
	private JLabel requestLabel;
	private JComboBox<String> requestBox;
	private JLabel startLabel;
	private JButton startButton;
	private JButton submitButton;
	private JScrollPane requestScrollPane;
	private JTextArea requestArea;
	private JPanel responsePane;
	private JScrollPane responseScrollPane;
	private JTextArea responseArea;
	private JPanel consolePane;
	private JLabel responseLabel;
	private JButton clearButton;
	public AcqModePane(){
		setLayout(new GridLayout(1, 2, 1, 1));
		requestPane = new JPanel();
		add(requestPane);
		requestPane.setLayout(new BorderLayout(0, 0));
		
		setupPane = new JPanel();
		FlowLayout requestLayout = (FlowLayout) setupPane.getLayout();
		requestLayout.setAlignment(FlowLayout.LEFT);
		requestPane.add(setupPane, BorderLayout.NORTH);
		
		startLabel = new JLabel("START UP ");
		startLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		setupPane.add(startLabel);
		
		startButton = new JButton("Start");
		startButton.setFont(new Font("Courier New", Font.BOLD, 12));
		setupPane.add(startButton);
		
		requestLabel = new JLabel("REQUEST");
		requestLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		setupPane.add(requestLabel);
		
		requestBox = new JComboBox<String>();
		requestBox.setModel(new DefaultComboBoxModel<String>(new String[] {"NETWORK", "BALANCE", "WITHDRAWAL", "REVERSAL"}));
		requestBox.setFont(new Font("Courier New", Font.PLAIN, 11));
		requestBox.setMaximumRowCount(16);
		setupPane.add(requestBox);
		
		submitButton = new JButton("Send");
		submitButton.setFont(new Font("Courier New", Font.BOLD, 12));
		setupPane.add(submitButton);
		
		requestScrollPane = new JScrollPane();
		requestPane.add(requestScrollPane, BorderLayout.CENTER);
		
		requestArea = new JTextArea();
		requestArea.setWrapStyleWord(true);
		requestArea.setLineWrap(true);
		requestArea.setEditable(false);
		requestArea.setBackground(Color.WHITE);
		requestArea.setFont(new Font("Courier New", Font.PLAIN, 11));
		requestScrollPane.setViewportView(requestArea);
		
		responsePane = new JPanel();
		add(responsePane);
		responsePane.setLayout(new BorderLayout(0, 0));
		
		responseScrollPane = new JScrollPane();
		responsePane.add(responseScrollPane,BorderLayout.CENTER);
		
		responseArea = new JTextArea();
		responseArea.setWrapStyleWord(true);
		responseArea.setLineWrap(true);
		responseArea.setEditable(false);
		responseArea.setBackground(Color.WHITE);
		responseArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		responseScrollPane.setViewportView(responseArea);
		
		consolePane = new JPanel();
		FlowLayout responseLayout = (FlowLayout) consolePane.getLayout();
		responseLayout.setAlignment(FlowLayout.LEFT);
		responsePane.add(consolePane,BorderLayout.NORTH);
		responseLabel = new JLabel("RESPONSE");
		responseLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		consolePane.add(responseLabel);
		
		clearButton = new JButton("Clear");
		consolePane.add(clearButton);
		clearButton.setFont(new Font("Courier New", Font.BOLD, 12));
		
		// add action
		submitButton.addActionListener(new AcqMsgAction(requestBox,requestArea,responseArea));
		clearButton.addActionListener(new ResetConsoleAction(requestArea,responseArea));
	}
}
