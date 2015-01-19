package com.bcnx.ui.acquirer;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.service.NetMsgService;
import com.bcnx.ui.acquirer.action.NetMsgSaveAction;

public class NetMsgPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel mtiLabel;
	private JTextField mtiField;
	private JLabel de07Label;
	private JLabel de11Label;
	private JLabel de70Label;
	private JComboBox<String> de70Box;
	private JLabel de37Label;
	private JTextField de37Txt;
	private JButton saveButton;
	public NetMsgPane(){
		setLayout(new GridLayout(1, 2, 1, 1));
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		mtiLabel = new JLabel("MTI");
		mtiLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		
		mtiField = new JTextField();
		mtiField.setFont(new Font("Courier New", Font.PLAIN, 12));
		mtiField.setEditable(false);
		mtiField.setEnabled(false);
		mtiField.setText("0800");
		mtiField.setColumns(10);
		
		de07Label = new JLabel("DE07");
		de07Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField de07Txt = new JTextField();
		de07Txt.setText("AUTO");
		de07Txt.setFont(new Font("Courier New", Font.PLAIN, 12));
		de07Txt.setEnabled(false);
		de07Txt.setEditable(false);
		de07Txt.setColumns(10);
		
		de11Label = new JLabel("DE11");
		de11Label.setFont(new Font("Courier New", Font.BOLD, 12));
		JTextField de11txt = new JTextField();
		de11txt.setText("AUTO");
		de11txt.setFont(new Font("Courier New", Font.PLAIN, 12));
		de11txt.setEditable(false);
		de11txt.setEnabled(false);
		de11txt.setColumns(10);
		
		de70Label = new JLabel("DE70");
		de70Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de70Box = new JComboBox<String>();
		de70Box.addAncestorListener(new De70AncestorListener(de70Box));
		de70Box.setModel(new DefaultComboBoxModel<String>(new String[]{"001","002","301"}));
		de70Box.setFont(new Font("Courier New", Font.PLAIN, 12));
		
		de37Label = new JLabel("DE37");
		de37Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de37Txt = new JTextField();
		de37Txt.setEnabled(false);
		de37Txt.setEditable(false);
		de37Txt.setFont(new Font("Courier New", Font.PLAIN, 11));
		de37Txt.setText("AUTO");
		de37Txt.setColumns(10);
		
		saveButton = new JButton("Save");
		
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(mtiLabel)
									.addGap(18)
									.addComponent(mtiField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de07Label)
									.addGap(18)
									.addComponent(de07Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de11Label)
									.addGap(18)
									.addComponent(de11txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(de37Label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(de37Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(de70Label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(de70Box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addComponent(saveButton)))
					.addContainerGap(301, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mtiLabel)
						.addComponent(mtiField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(de07Label)
						.addComponent(de07Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(de11Label)
						.addComponent(de11txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(de37Label)
						.addComponent(de37Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(de70Label)
						.addComponent(de70Box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(saveButton)
					.addContainerGap(339, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout);
		saveButton.addActionListener(new NetMsgSaveAction(de70Box));
	}
	
	private class De70AncestorListener implements AncestorListener{
		private JComboBox<String> de70Box;
		public De70AncestorListener(JComboBox<String> de70Box){
			this.de70Box = de70Box;
		}
		@Override
		public void ancestorAdded(AncestorEvent event) {
			ApplicationContext context = BcnxApplicationContext.getApplicationContext();
			NetMsgService service = (NetMsgService) context.getBean("netMsgService");
			String de70 = service.getDe70();
			if(de70!=null)
				de70Box.setSelectedItem(de70);
		}

		@Override
		public void ancestorMoved(AncestorEvent event) {}

		@Override
		public void ancestorRemoved(AncestorEvent event) {}
		
	}
}
