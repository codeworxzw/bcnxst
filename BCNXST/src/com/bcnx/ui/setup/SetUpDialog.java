package com.bcnx.ui.setup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import com.bcnx.ui.setup.bin.BinParam;
import com.bcnx.ui.setup.card.CardParam;
import com.bcnx.ui.setup.member.MemberParam;

public class SetUpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel memberParam;
	private JPanel binParam;
	private JPanel cardParam;
	private JTabbedPane tabbedPane;
	private JPanel buttonPane;
	private JButton cancelButton;
	/*
	 * Create the dialog.
	 */
	public SetUpDialog() {
		setBounds(60, 60, 790, 561);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		this.setModal(true);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu paramMenu = new JMenu("File");
		menuBar.add(paramMenu);
		JMenuItem Open = new JMenuItem("Open");
		paramMenu.add(Open);
		setJMenuBar(menuBar);
		
		memberParam = new MemberParam();
		binParam = new BinParam();
		cardParam = new CardParam();
		
		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		
		tabbedPane.addTab("MEMBER", null, memberParam, null);
		tabbedPane.addTab("BIN", null, binParam, null);
		tabbedPane.addTab("CARD", null, cardParam, null);
		
		contentPanel.add(tabbedPane, BorderLayout.CENTER);

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		cancelButton = new JButton("Exit");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
	}
}
