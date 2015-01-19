package com.bcnx.application;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import com.bcnx.ui.acquirer.AcqModePane;
import com.bcnx.ui.acquirer.MessageDialog;
import com.bcnx.ui.issuer.IssModePane;
import com.bcnx.ui.setup.SetUpDialog;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Application frame = new Application();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(60, 60, 1100, 700);
		
		JMenuBar mainMenu = new JMenuBar();
		setJMenuBar(mainMenu);
		
		JMenu fileMenu = new JMenu("File");
		mainMenu.add(fileMenu);
		
		JMenuItem openMenuItem = new JMenuItem("Exit");
		fileMenu.add(openMenuItem);
		
		JMenu editMenu = new JMenu("Edit");
		mainMenu.add(editMenu);
		
		JMenuItem editMenuItem = new JMenuItem("Setup");
		JMenuItem msgMenuItem = new JMenuItem("Message");
		editMenu.add(editMenuItem);
		editMenu.add(msgMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setFont(new Font("Courier New", Font.BOLD, 12));
		contentPane.add(tabbedPane);
		
		JPanel issModePane = new AcqModePane();
		tabbedPane.addTab("ACQUIRER", null, issModePane, null);
		
		JPanel acqModePane = new IssModePane();
		tabbedPane.addTab("ISSUER", null, acqModePane, null);
		
		// add action
		editMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog setUpDialog = new SetUpDialog();
				setUpDialog.setVisible(true);
			}
			
		});
		msgMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog msgDialog = new MessageDialog();
				msgDialog.setVisible(true);
			}
			
		});
		openMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
	}

}
