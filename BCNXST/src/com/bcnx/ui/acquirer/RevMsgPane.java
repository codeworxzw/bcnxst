package com.bcnx.ui.acquirer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

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
import javax.swing.SwingConstants;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.CardAcct;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.CardAcctService;
import com.bcnx.data.service.MemberService;
import com.bcnx.data.service.RevMsgService;
import com.bcnx.ui.acquirer.action.RevMsgSaveAction;

public class RevMsgPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField mtiField;
	private JScrollPane scrollPane;
	private JTextField de11Field;
	private JTextField de12Field;
	private JTextField de13Field;
	private JTextField de04Field;
	private JTextField de07Field;
	private JTextField de14Field;
	private JTextField de15Field;
	private JTextField de18Field;
	private JTextField de19Field;
	private JTextField de22Field;
	private JTextField de25Field;
	private JTextField de42Field;
	private JTextField de35Field;
	private JTextField de28Field;
	private JTextField de37Field;
	private JTextField de43Field;
	private JTextField de49Field;
	private JTextField de41Field;
	private JTextField de90Field;
	private JTextField de39Field;
	private JLabel de03Label;
	private JComboBox<String> de03Box;
	private JLabel de12Label;
	private JLabel de13Label;
	private JLabel mitLabel;
	private JLabel de02Label;
	private JComboBox<String> de02Box;
	private JLabel de07Label;
	private JLabel de04Label;
	private JLabel de14Label;
	private JLabel de15Label;
	private JLabel de18Label;
	private JLabel de42Label;
	private JLabel de90Label;
	private JLabel de25Label;
	private JLabel de32Label;
	private JLabel de35Label;
	private JLabel de37Label;
	private JLabel de41Label;
	private JLabel de43Label;
	private JLabel de49Label;
	private JLabel de19Label;
	private JLabel de22Label;
	private JLabel de28Label;
	private JLabel de11Label;
	private JComboBox<String> de32Box;
	private JButton saveButton;
	private JLabel de39Label;
	public RevMsgPane(){
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		de03Label = new JLabel("DE03");
		de03Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de03Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de03Box = new JComboBox<String>();
		de03Box.setModel(new DefaultComboBoxModel<String>(new String[]{"010000","011000","012000","013000"}));
		de03Box.setFont(new Font("Courier New", Font.PLAIN, 11));
		
		de11Label = new JLabel("DE11");
		de11Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de11Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de11Field = new JTextField();
		de11Field.setText("AUTO");
		de11Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de11Field.setEnabled(false);
		de11Field.setEditable(false);
		de11Field.setColumns(10);
		
		de12Label = new JLabel("DE12");
		de12Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de12Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de12Field = new JTextField();
		de12Field.setText("AUTO");
		de12Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de12Field.setEnabled(false);
		de12Field.setEditable(false);
		de12Field.setColumns(10);
		
		de13Label = new JLabel("DE13");
		de13Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de13Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de13Field = new JTextField();
		de13Field.setText("AUTO");
		de13Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de13Field.setEnabled(false);
		de13Field.setEditable(false);
		de13Field.setColumns(10);
		
		mitLabel = new JLabel("MTI");
		mitLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mitLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de02Label = new JLabel("DE02");
		de02Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de02Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de02Box = new JComboBox<String>();
		de02Box.setFont(new Font("Courier New", Font.PLAIN, 11));
		
		mtiField = new JTextField();
		mtiField.setText("0420");
		mtiField.setFont(new Font("Courier New", Font.PLAIN, 11));
		mtiField.setEnabled(false);
		mtiField.setEditable(false);
		mtiField.setColumns(10);
		
		de07Label = new JLabel("DE07");
		de07Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de07Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de04Label = new JLabel("DE04");
		de04Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de04Field = new JTextField();
		de04Field.setText("000000000000");
		de04Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de04Field.setColumns(10);
		de04Field.setBackground(Color.WHITE);
		
		de07Field = new JTextField();
		de07Field.setEditable(false);
		de07Field.setText("AUTO");
		de07Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de07Field.setEnabled(false);
		de07Field.setColumns(10);
		
		de14Label = new JLabel("DE14");
		de14Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de14Field = new JTextField();
		de14Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de14Field.setText("AUTO");
		de14Field.setEnabled(false);
		de14Field.setEditable(false);
		de14Field.setColumns(10);
		
		de15Label = new JLabel("DE15");
		de15Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de15Field = new JTextField();
		de15Field.setText("AUTO");
		de15Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de15Field.setEnabled(false);
		de15Field.setEditable(false);
		de15Field.setColumns(10);
		
		de18Label = new JLabel("DE18");
		de18Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de18Field = new JTextField();
		de18Field.setText("6011");
		de18Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de18Field.setEnabled(false);
		de18Field.setEditable(false);
		de18Field.setColumns(10);
		
		de42Label = new JLabel("DE42");
		de42Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de90Label = new JLabel("DE90");
		de90Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de25Label = new JLabel("DE25");
		de25Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de32Label = new JLabel("DE32");
		de32Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de35Label = new JLabel("DE35");
		de35Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de37Label = new JLabel("DE37");
		de37Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de41Label = new JLabel("DE41");
		de41Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de43Label = new JLabel("DE43");
		de43Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de49Label = new JLabel("DE49");
		de49Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de19Label = new JLabel("DE19");
		de19Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de22Label = new JLabel("DE22");
		de22Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de28Label = new JLabel("DE28");
		de28Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de19Field = new JTextField();
		de19Field.setText("418");
		de19Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de19Field.setEnabled(false);
		de19Field.setEditable(false);
		de19Field.setColumns(10);
		
		de22Field = new JTextField();
		de22Field.setText("021");
		de22Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de22Field.setEnabled(false);
		de22Field.setEditable(false);
		de22Field.setColumns(10);
		
		de25Field = new JTextField();
		de25Field.setText("01");
		de25Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de25Field.setEnabled(false);
		de25Field.setEditable(false);
		de25Field.setColumns(10);
		
		de42Field = new JTextField();
		de42Field.setText("1111 AAAA 0000B");
		de42Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de42Field.setColumns(10);
		de42Field.setBackground(Color.WHITE);
		
		de35Field = new JTextField();
		de35Field.setEnabled(false);
		de35Field.setEditable(false);
		de35Field.setText("AUTO");
		de35Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de35Field.setColumns(10);
		
		de28Field = new JTextField();
		de28Field.setText("C00002000");
		de28Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de28Field.setColumns(10);
		
		de32Box = new JComboBox<String>();
		de32Box.setFont(new Font("Courier New", Font.PLAIN, 11));
		
		de37Field = new JTextField();
		de37Field.setText("AUTO");
		de37Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de37Field.setEnabled(false);
		de37Field.setEditable(false);
		de37Field.setColumns(10);
		
		de43Field = new JTextField();
		de43Field.setText("A");
		de43Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de43Field.setColumns(10);
		de43Field.setBackground(Color.WHITE);
		
		de49Field = new JTextField();
		de49Field.setText("418");
		de49Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de49Field.setEnabled(false);
		de49Field.setEditable(false);
		de49Field.setColumns(10);
		
		de41Field = new JTextField();
		de41Field.setText("01000100");
		de41Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de41Field.setColumns(10);
		de41Field.setBackground(Color.WHITE);
		
		de90Field = new JTextField();
		de90Field.setText("AUTO");
		de90Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de90Field.setEnabled(false);
		de90Field.setEditable(false);
		de90Field.setColumns(10);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Courier New", Font.BOLD, 12));
		saveButton.addActionListener(new RevMsgSaveAction(de02Box,de03Box,de04Field,de28Field,de32Box,de41Field,de42Field,de43Field));
		de39Label = new JLabel("DE39");
		de39Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de39Field = new JTextField();
		de39Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de39Field.setEnabled(false);
		de39Field.setEditable(false);
		de39Field.setText("00");
		de39Field.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(mitLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(mtiField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de02Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de02Box, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de03Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de03Box, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de04Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de04Field, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de07Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de07Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de11Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de11Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de12Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de12Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de13Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de13Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de14Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de14Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de15Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de15Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de18Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(de18Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de19Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(de19Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(de90Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(de49Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de43Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(de42Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(de41Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(de39Label)
												.addContainerGap())
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(de37Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
													.addContainerGap())
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(de35Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(de32Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
															.addContainerGap())
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addGroup(groupLayout.createSequentialGroup()
																.addComponent(de25Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
															.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																	.addComponent(de28Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																	.addContainerGap())
																.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																	.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(de22Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
																	.addGroup(groupLayout.createSequentialGroup()
																		.addGap(64)
																		.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																			.addComponent(de25Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de22Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de28Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de32Box, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de37Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de90Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de39Field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de41Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de42Field, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de43Field, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de49Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(de35Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																			.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(68, GroupLayout.PREFERRED_SIZE)))))))))))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(mitLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(mtiField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addComponent(de22Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(de22Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(de02Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de02Box, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(de03Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(de03Box, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(de25Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de28Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de25Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(de28Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de04Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de04Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de07Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de07Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de11Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de11Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de12Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de12Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de13Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de13Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(de14Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de14Field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de15Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de15Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de18Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de18Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de32Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de32Box, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de35Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de37Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de37Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de90Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de39Label)
								.addComponent(de39Field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de41Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de41Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de42Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de42Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de43Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de43Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(de49Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(de49Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(de90Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(de35Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(de19Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(de19Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(saveButton)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout);
		initComponent();
	}
	
	private void initComponent(){
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		CardAcctService cardAcctService = (CardAcctService) context.getBean("cardAcctService");
		RevMsgService revMsgService = (RevMsgService) context.getBean("revMsgService");
		MemberService memberService = (MemberService) context.getBean("memberService");
		
		List<CardAcct> list = cardAcctService.getCardAccts();
		String[] cards = new String[list.size()];
		int i =0;
		for(CardAcct item : list)
			cards[i++] = item.getCard();
		DefaultComboBoxModel<String> aModel = new DefaultComboBoxModel<String>(cards);
		de02Box.setModel(aModel);
		
		List<Member> members = memberService.getMembers();
		String[] iins = new String[members.size()];
		i = 0;
		for(Member mem:members)
			iins[i++] = mem.getIin();
		DefaultComboBoxModel<String> bModel = new DefaultComboBoxModel<String>(iins);
		de32Box.setModel(bModel);
		
		String de02 = revMsgService.getDe02();
		String de03 = revMsgService.getDe03();
		String de04 = revMsgService.getDe04();
		String de28 = revMsgService.getDe28();
		String de32 = revMsgService.getDe32();
		String de41 = revMsgService.getDe41();
		String de42 = revMsgService.getDe42();
		String de43 = revMsgService.getDe43();
		if(de02 != null)
			de02Box.setSelectedItem(de02);
		if(de03!=null)
			de03Box.setSelectedItem(de03);
		if(de04!=null)
			de04Field.setText(de04);
		if(de28!=null)
			de28Field.setText(de28);
		if(de32!=null)
			de32Box.setSelectedItem(de32);
		if(de41!=null)
			de41Field.setText(de41);
		if(de42!=null)
			de42Field.setText(de42);
		if(de43!=null)
			de43Field.setText(de43);
	}
}
