package com.bcnx.ui.acquirer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class MessageDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			AcqSetupPane dialog = new AcqSetupPane();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 * Create the dialog.
	 */
	public MessageDialog() {
		setBounds(60, 60, 650, 780);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new NetWkPane();
			contentPanel.add(panel, BorderLayout.NORTH);
		}
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Courier New", Font.BOLD, 12));
			contentPanel.add(tabbedPane, BorderLayout.CENTER);
			{
				JPanel panel = new NetMsgPane();
				tabbedPane.addTab("NETWORK", null, panel, null);
			}
			{
				JPanel panel = new BalMsgPane();
				tabbedPane.addTab("BALANCE", null, panel, null);
			}
			{
				JPanel panel = new CwdMsgPane();
				tabbedPane.addTab("WITHDRAWAL", null, panel, null);
			}
			{
				JPanel panel = new RevMsgPane();
				tabbedPane.addTab("REVERSAL", null, panel, null);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnNewMenu = new JMenu("New menu");
				menuBar.add(mnNewMenu);
				{
					JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
					mnNewMenu.add(mntmNewMenuItem);
				}
			}
		}
	}
}
