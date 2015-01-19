package com.bcnx.ui.setup.card;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class CardParam extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CardParam(){
		setLayout(new GridLayout(1, 2, 1, 0));
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_16 = new JLabel("CARD REGISTER");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_16);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		DecimalFormat df = new DecimalFormat("#,###.00");
		JFormattedTextField balText = new JFormattedTextField(df);
		balText.setColumns(10);
		
		JLabel lblRequired_5 = new JLabel("required");
		
		JLabel lblFlag = new JLabel("FLAG");
		lblFlag.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRequired_4 = new JLabel("required");
		
		JLabel lblCav = new JLabel("CAV");
		lblCav.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblExp = new JLabel("EXP");
		lblExp.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JFormattedTextField cavText = new JFormattedTextField();
		cavText.setColumns(10);
		cavText.setDocument(new InputLimiter(3));
		
		JFormattedTextField expText = new JFormattedTextField();
		expText.setColumns(10);
		expText.setDocument(new InputLimiter(4));
		JLabel lblRequired_6 = new JLabel("required");
		
		JLabel lblRequired_7 = new JLabel("required");
		
		JLabel lblCurr = new JLabel("CURR");
		lblCurr.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRequired_3 = new JLabel("required");
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRequired_2 = new JLabel("required");
		
		JLabel lblCard = new JLabel("CARD");
		lblCard.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JFormattedTextField cardText = new JFormattedTextField();
		cardText.setColumns(10);
		cardText.setDocument(new InputLimiter(13));
		JLabel lblRequired_1 = new JLabel("required");
		
		JLabel lblBin = new JLabel("BIN");
		lblBin.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRquired = new JLabel("required");
		
		JButton saveButton = new JButton("Save");
		JComboBox<String> binComboBox = new BinComboBox();
		
		JComboBox<String> typeComboBox = new JComboBox<String>(new String[]{"","01","02"});
		
		JComboBox<String> currComboBox = new JComboBox<String>(new String[]{"","418","764","840"});
		
		JComboBox<String> flagComboBox = new JComboBox<String>(new String[]{"","C","D"});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCav)
								.addComponent(lblExp)
								.addComponent(lblBalance))
							.addGap(18))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCard)
								.addComponent(lblBin)
								.addComponent(lblType)
								.addComponent(lblCurr)
								.addComponent(lblFlag))
							.addGap(18)))
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
							.addComponent(lblRequired_2, Alignment.TRAILING)
							.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
								.addComponent(cavText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
								.addComponent(lblRequired_7))
							.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
								.addComponent(expText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
								.addComponent(lblRequired_6))
							.addGroup(gl_panel_6.createSequentialGroup()
								.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
										.addComponent(flagComboBox, 0, 86, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
											.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
												.addComponent(typeComboBox, Alignment.LEADING, 0, 86, Short.MAX_VALUE)
												.addComponent(currComboBox, 0, 86, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addComponent(balText, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(81)
								.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
									.addComponent(lblRequired_5, Alignment.TRAILING)
									.addComponent(lblRequired_4, Alignment.TRAILING)
									.addComponent(lblRequired_3, Alignment.TRAILING))))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addComponent(cardText, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addComponent(binComboBox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRquired)
								.addComponent(lblRequired_1))))
					.addGap(49))
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(232, Short.MAX_VALUE)
					.addComponent(saveButton)
					.addGap(31))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(binComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBin)
						.addComponent(lblRquired))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(cardText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCard)
						.addComponent(lblRequired_1))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRequired_2)
						.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRequired_3)
						.addComponent(currComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCurr))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRequired_4)
						.addComponent(flagComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFlag))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(balText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBalance)
						.addComponent(lblRequired_5))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(expText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExp)
						.addComponent(lblRequired_6))
					.addGap(18)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(cavText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCav)
						.addComponent(lblRequired_7))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(saveButton)
					.addGap(24))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_17 = new JLabel("CARD");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblNewLabel_17);
		
		JTextField searchText = new JTextField("%");
		panel_4.add(searchText);
		searchText.setColumns(12);
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_5, BorderLayout.SOUTH);
			
		JButton updateButton = new JButton("Update");
		panel_5.add(updateButton);
		
		JButton deleteButton = new JButton("Delete");
		panel_5.add(deleteButton);
		
		CardParamTable tableModel =  new CardParamTable();
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
		TableColumn cardColumn = columnModel.getColumn(2);
		TableColumn typeColumn = columnModel.getColumn(3);
		TableColumn currColumn = columnModel.getColumn(4);
		TableColumn flagColumn = columnModel.getColumn(5);
		TableColumn balColumn = columnModel.getColumn(6);
		TableColumn expColumn = columnModel.getColumn(7);
		TableColumn	cavColumn = columnModel.getColumn(8);
		TableColumn binColumn = columnModel.getColumn(9);
		
		chkColumn.setPreferredWidth(40);
		noColumn.setPreferredWidth(40);
		cardColumn.setPreferredWidth(140);
		typeColumn.setPreferredWidth(50);
		currColumn.setPreferredWidth(50);
		flagColumn.setPreferredWidth(50);
		balColumn.setPreferredWidth(80);
		expColumn.setPreferredWidth(50);
		cavColumn.setPreferredWidth(50);
		binColumn.setPreferredWidth(50);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		// listener add to component
		CardParamTableListener tableListener = new CardParamTableListener(table);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(tableListener);
		saveButton.addActionListener(new CardAddAction(binComboBox, cardText,
				typeComboBox, currComboBox, flagComboBox, balText, expText,
				cavText, table));
		searchText.getDocument().addDocumentListener(new CardSearchAction(table,searchText));
		deleteButton.addActionListener(new CardDeleteAction(table));
		updateButton.addActionListener(new CardUpdateAction(table));
	}
	private class InputLimiter extends PlainDocument{
		
		private static final long serialVersionUID = 1L;
		private int limit;
		public InputLimiter(int limit){
			this.limit = limit;
		}
		public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
	            throws BadLocationException {
	        if(getLength() + str.length() <= limit)
	            super.insertString(offs, str, a);
	    }
	}
}
