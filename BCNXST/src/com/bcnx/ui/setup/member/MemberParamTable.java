package com.bcnx.ui.setup.member;

import javax.swing.table.AbstractTableModel;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.MemberService;

public class MemberParamTable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private String[] columnNames = { "CHK", "NO", "IIN", "ID", "NAME","LOCATION" };
	private Object[][] data;
	private MemberService service;
	public MemberParamTable() {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		service = (MemberService) context.getBean("memberService");
		this.data = UtilPackage.membersToArray(service.getMembers());
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0)
			return Boolean.class;
		else if (columnIndex == 1)
			return Integer.class;
		else if (columnIndex == 2)
			return String.class;
		else if (columnIndex == 3)
			return String.class;
		else if (columnIndex == 4)
			return String.class;
		else if (columnIndex == 5)
			return String.class;
		else if (columnIndex == 6)
			return String.class;
		else
			return null;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public void addRow(Object[] rowData) {
		int size = data.length + 1;
		int len = columnNames.length;
		Object[][] dump = new Object[size][len];
		for (int i = 0; i < data.length; i++) {
			dump[i] = data[i];
		}
		dump[size - 1] = rowData;
		data = dump;
		fireTableDataChanged();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex !=1)
			return true;
		else
			return false;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = value;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	public void deleteData(int row){
		data = UtilPackage.membersToArray(service.getMembers());
		fireTableRowsDeleted(row,row);
	}
	public void updateTable(Object[] rowData){
		data = null;
		data = new Object[1][columnNames.length];
		data[0] = rowData;
		fireTableDataChanged();
	}

	public void refreshTable(Object[][] data2) {
		data = data2;
		fireTableDataChanged();
	}
}
