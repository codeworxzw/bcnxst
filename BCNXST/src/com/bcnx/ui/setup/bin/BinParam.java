package com.bcnx.ui.setup.bin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class BinParam extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JLabel lblNewLabel_8;
	private JPanel panel_7;
	private JLabel lblNewLabel_10;
	private IinComboBox iinBox;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField binText;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JComboBox<String> typeBox;
	private JLabel lblNewLabel_15;
	private JButton saveButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JLabel lblNewLabel_9;
	private JPanel panel_6;
	private JTextField searchText;
	public BinParam(){
		setLayout(new BorderLayout());
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 2, 1, 1));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		lblNewLabel_8 = new JLabel("BIN REGISTER");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNewLabel_8);
		
		panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.CENTER);
		
		lblNewLabel_10 = new JLabel("IIN");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		iinBox = new IinComboBox();
		
		lblNewLabel_11 = new JLabel("required");
		
		lblNewLabel_12 = new JLabel("BIN");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		binText = new JTextField();
		binText.setColumns(10);
		
		lblNewLabel_13 = new JLabel("required");
		
		lblNewLabel_14 = new JLabel("TYPE");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		String[] list = new String[]{"","C","D","P"};
		typeBox = new JComboBox<String>(list);
		
		lblNewLabel_15 = new JLabel("required");
		
		saveButton = new JButton("Save");
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel_14)
							.addComponent(lblNewLabel_12))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel_10)))
					.addGap(18)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING, false)
						.addComponent(iinBox, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(typeBox, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(binText))
					.addGap(18)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_15)
						.addComponent(lblNewLabel_11)
						.addComponent(lblNewLabel_13))
					.addContainerGap(118, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
					.addContainerGap(226, Short.MAX_VALUE)
					.addComponent(saveButton)
					.addGap(70))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_11)
						.addComponent(lblNewLabel_10)
						.addComponent(iinBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_12)
						.addComponent(binText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13))
					.addGap(18)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_15)
						.addComponent(lblNewLabel_14)
						.addComponent(typeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(saveButton)
					.addContainerGap(215, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_5, BorderLayout.NORTH);
		
		lblNewLabel_9 = new JLabel("BIN");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblNewLabel_9);
		
		searchText = new JTextField("%");
		panel_5.add(searchText);
		searchText.setColumns(10);
		
		panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_6, BorderLayout.SOUTH);
		
		updateButton = new JButton("Update");
		panel_6.add(updateButton);
		
		deleteButton = new JButton("Delete");
		panel_6.add(deleteButton);
		
		BinParamTable tableModel = new BinParamTable();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();

		centerRender.setHorizontalAlignment(JLabel.CENTER);
		
		JTable table = new JTable(tableModel);
		table.setShowGrid(false);
		table.setDefaultRenderer(String.class, centerRender);
		table.setDefaultRenderer(Integer.class, centerRender);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columnModel = table.getColumnModel();
		TableColumn chkColumn = columnModel.getColumn(0);
		TableColumn noColumn = columnModel.getColumn(1);
		TableColumn iinColumn = columnModel.getColumn(2);
		TableColumn binColumn = columnModel.getColumn(3);
		TableColumn typeColumn = columnModel.getColumn(4);
		chkColumn.setPreferredWidth(50);
		noColumn.setPreferredWidth(50);
		iinColumn.setPreferredWidth(90);
		binColumn.setPreferredWidth(70);
		typeColumn.setPreferredWidth(120);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		// action of dialog
		BinParamTableListener tableListener = new BinParamTableListener(table);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(tableListener);
		BinSaveAction saveAction = new BinSaveAction(table,iinBox,typeBox,binText);
		saveButton.addActionListener(saveAction);
		searchText.getDocument().addDocumentListener(new BinSearchTextListener(searchText,table));
		updateButton.addActionListener(new BinUpdateAction(table));
		deleteButton.addActionListener(new BinDeleteAction(table));
	}
}
