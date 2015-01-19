package com.bcnx.ui.setup.member;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MemberParam extends JPanel {
	private JLabel iinLabel;
	private JLabel idLabel;
	
	private JTextField iinText;
	private JTextField memIdText;
	private JTextField nameText;
	private JTextField locationText;
	private static final long serialVersionUID = 1L;
	public MemberParam(){
		setLayout(new GridLayout(1, 2, 1, 1));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("MEMBER REGISTER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		
		iinLabel = new JLabel("IIN");
		iinLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		iinText = new JTextField();
		iinText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("required");
		
		idLabel = new JLabel("MEMBERID");
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		memIdText = new JTextField();
		memIdText.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("required");
		
		JLabel lblNewLabel_6 = new JLabel("NAME");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		nameText = new JTextField();
		nameText.setText("");
		nameText.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("required");
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		locationText = new JTextField();
		locationText.setColumns(10);
		
		JLabel lblRequired = new JLabel("required");
		
		JButton saveButton = new JButton("Save");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_6)
								.addComponent(idLabel)
								.addComponent(lblLocation)))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(46)
							.addComponent(iinLabel)))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(iinText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
							.addComponent(nameText, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addComponent(memIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(locationText)))
					.addGap(30)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel_5)
							.addComponent(lblNewLabel_3)
							.addComponent(lblNewLabel_7))
						.addComponent(lblRequired))
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addComponent(saveButton)
					.addGap(50))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(iinLabel)
						.addComponent(iinText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(memIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(locationText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRequired))
					.addGap(43)
					.addComponent(saveButton)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("IIN");
		panel_4.add(lblNewLabel_1);
		
		JTextField iinText2 = new JTextField("%");
		panel_4.add(iinText2);
		iinText2.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		JButton updateButton = new JButton("Update");
		panel_5.add(updateButton);
		
		JButton deleteButton = new JButton("Delete");
		panel_5.add(deleteButton);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		MemberParamTable model = new MemberParamTable();
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();

		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		JTable table = new JTable(model);
		table.setShowGrid(false);
		table.setDefaultRenderer(String.class, leftRenderer);
		table.setDefaultRenderer(Integer.class, centerRender);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columnModel = table.getColumnModel();
		TableColumn chkColumn = columnModel.getColumn(0);
		TableColumn noColumn = columnModel.getColumn(1);
		TableColumn iinColumn = columnModel.getColumn(2);
		TableColumn idColumn = columnModel.getColumn(3);
		TableColumn nameColumn = columnModel.getColumn(4);
		TableColumn locationColumn = columnModel.getColumn(5);

		chkColumn.setPreferredWidth(50);
		noColumn.setPreferredWidth(50);
		iinColumn.setPreferredWidth(70);
		idColumn.setPreferredWidth(70);
		nameColumn.setPreferredWidth(120);
		locationColumn.setPreferredWidth(280);
		
		scrollPane.setViewportView(table);
		
		// action on dialog
		MemberAddAction saveAction = new MemberAddAction(memIdText, iinText,nameText, locationText, table);
		saveButton.addActionListener(saveAction);
		MemberParamTableListener tableListener = new MemberParamTableListener(table);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(tableListener);
		MemberUpdateAction updateAction = new MemberUpdateAction(table);
		updateButton.addActionListener(updateAction);
		MemberDeleteAction deleteAction = new MemberDeleteAction(table);
		deleteButton.addActionListener(deleteAction);
		iinText2.getDocument().addDocumentListener(new MemberIinTextSearch(table,iinText2));
	}

}
