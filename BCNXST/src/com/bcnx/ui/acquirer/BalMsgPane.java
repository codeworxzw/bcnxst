package com.bcnx.ui.acquirer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import com.bcnx.data.service.BalMsgService;
import com.bcnx.data.service.CardAcctService;
import com.bcnx.data.service.MemberService;
import com.bcnx.ui.acquirer.action.BalMsgSaveAction;

public class BalMsgPane extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel de03Label;
	private JComboBox<String> de03Box;
	private JLabel de11Label;
	private JTextField de11Field;
	private JLabel de12Label;
	private JTextField de12Field;
	private JLabel de13Label;
	private JTextField de13Field;
	private JLabel de02Label;
	private JComboBox<String> de02Box;
	private JLabel mtiLabel;
	private JTextField mtiField;
	private JLabel de07Label;
	private JTextField de07Field;
	private JLabel de04Label;
	private JLabel de14Label;
	private JTextField de14Field;
	private JTextField de04Field;
	private JLabel de15Label;
	private JTextField de15Field;
	private JLabel de18Label;
	private JTextField de18Field;
	private JLabel de42Label;
	private JLabel de52Label;
	private JLabel de28Label;
	private JLabel de32Lable;
	private JLabel de35Label;
	private JLabel de37Label;
	private JLabel de41Label;
	private JLabel de43Label;
	private JLabel de49Label;
	private JLabel de19Label;
	private JLabel de22Label;
	private JLabel de25Label;
	private JTextField de19Field;
	private JTextField de22Field;
	private JTextField de42Field;
	private JTextField de52Field;
	private JTextField de28Field;
	private JComboBox<String> de32Box;
	private JTextField de35Field;
	private JTextField de43Field;
	private JTextField de49Field;
	private JTextField de41Field;
	private JTextField de37Field;
	private JTextField de25Field;
	private JButton saveButton;
	
	public BalMsgPane(){
		setLayout(new GridLayout(1, 2, 1, 1));
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		de03Label = new JLabel("DE03");
		de03Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de03Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de03Box = new JComboBox<String>();
		de03Box.setModel(new DefaultComboBoxModel<String>(new String[]{"300000","301000","302000","303000"}));
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
		
		de02Label = new JLabel("DE02");
		de02Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de02Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de02Box = new JComboBox<String>();
		de02Box.setFont(new Font("Courier New", Font.PLAIN, 11));
		
		mtiLabel = new JLabel("MTI");
		mtiLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mtiLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		
		mtiField = new JTextField();
		mtiField.setText("0200");
		mtiField.setFont(new Font("Courier New", Font.PLAIN, 12));
		mtiField.setEnabled(false);
		mtiField.setEditable(false);
		mtiField.setColumns(10);
		
		de07Label = new JLabel("DE07");
		de07Label.setHorizontalAlignment(SwingConstants.RIGHT);
		de07Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de07Field = new JTextField();
		de07Field.setEditable(false);
		de07Field.setText("AUTO");
		de07Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de07Field.setEnabled(false);
		de07Field.setColumns(10);
		
		de04Label = new JLabel("DE04");
		de04Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de04Field = new JTextField();
		de04Field.setText("000000000000");
		de04Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de04Field.setEnabled(false);
		de04Field.setEditable(false);
		de04Field.setColumns(10);
		
		de14Label = new JLabel("DE14");
		de14Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de14Field = new JTextField();
		de14Field.setText("AUTO");
		de14Field.setFont(new Font("Courier New", Font.PLAIN, 12));
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
		
		de52Label = new JLabel("DE52");
		de52Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de28Label = new JLabel("DE28");
		de28Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
		de32Lable = new JLabel("DE32");
		de32Lable.setFont(new Font("Courier New", Font.BOLD, 12));
		
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
		
		de25Label = new JLabel("DE25");
		de25Label.setFont(new Font("Courier New", Font.BOLD, 12));
		
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
		
		de42Field = new JTextField();
		de42Field.setText("1111 AAAA 0000B");
		de42Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de42Field.setColumns(10);
		de42Field.setBackground(Color.WHITE);
		
		de52Field = new JTextField();
		de52Field.setText("1234567890ABCDEF");
		de52Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de52Field.setColumns(10);
		de52Field.setBackground(Color.WHITE);
		
		de28Field = new JTextField();
		de28Field.setText("D00000000");
		de28Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de28Field.setColumns(10);
		de28Field.setBackground(Color.WHITE);
		
		de32Box = new JComboBox<String>();
		de32Box.setFont(new Font("Courier New", Font.PLAIN, 11));
		
		de35Field = new JTextField();
		de35Field.setText("AUTO");
		de35Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de35Field.setEnabled(false);
		de35Field.setEditable(false);
		de35Field.setColumns(10);
		
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
		
		de37Field = new JTextField();
		de37Field.setText("AUTO");
		de37Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de37Field.setEnabled(false);
		de37Field.setEditable(false);
		de37Field.setColumns(10);
		
		de25Field = new JTextField();
		de25Field.setText("01");
		de25Field.setFont(new Font("Courier New", Font.PLAIN, 11));
		de25Field.setEnabled(false);
		de25Field.setEditable(false);
		de25Field.setColumns(10);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new BalMsgSaveAction(de02Box,de03Box,de28Field,de32Box,de41Field,de42Field,de43Field,de52Field));
		saveButton.setFont(new Font("Courier New", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(mtiLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(de18Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de19Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de19Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de22Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de22Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de25Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de25Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de28Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de28Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de32Lable, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de32Box, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de35Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de35Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de37Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de37Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de41Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de41Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de42Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de42Field, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de43Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de43Field, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de49Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de49Field, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(de52Label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(de52Field, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 82, GroupLayout.PREFERRED_SIZE)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addGap(85))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de19Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de19Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(de22Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(de22Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(de25Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(de25Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de28Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de28Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(de32Lable, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de32Box, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(de35Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de35Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(de37Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de37Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(de41Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de41Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(de42Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de42Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(de43Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de43Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(de49Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de49Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de52Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de52Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addComponent(saveButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(mtiLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(mtiField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
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
								.addComponent(de03Box, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
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
								.addComponent(de14Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de15Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de15Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(de18Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(de18Field, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout);
		initComponent();
	}

	
	public void initComponent() {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		CardAcctService cardAcctService = (CardAcctService) context.getBean("cardAcctService");
		BalMsgService balMsgService = (BalMsgService) context.getBean("balMsgService");
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
		
		String de02 = balMsgService.getDe02();
		String de03 = balMsgService.getDe03();
		String de28 = balMsgService.getDe28();
		String de32 = balMsgService.getDe32();
		String de41 = balMsgService.getDe41();
		String de42 = balMsgService.getDe42();
		String de43 = balMsgService.getDe43();
		String de52 = balMsgService.getDe52();
		if(de02 != null)
			de02Box.setSelectedItem(de02);
		if(de03!=null)
			de03Box.setSelectedItem(de03);
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
		if(de52!=null)
			de52Field.setText(de52);
	}
}
