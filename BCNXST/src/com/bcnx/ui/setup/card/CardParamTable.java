package com.bcnx.ui.setup.card;

import javax.swing.table.AbstractTableModel;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.CardAcctService;

public class CardParamTable extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames= {"CHK","NO","CARD","TYPE","CURR","FLAG","BAL","EXP","CAV","BIN"};
	private Object[][] data;
	public CardParamTable(){
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		CardAcctService service = (CardAcctService) context.getBean("cardAcctService");
		data = UtilPackage.cardAccountToArray(service.getCardAccts());
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
		if(columnIndex==0)
			return Boolean.class;
		else if(columnIndex==1)
			return Integer.class;
		else if(columnIndex==2)
			return String.class;
		else if(columnIndex==3)
			return String.class;
		else if(columnIndex==4)
			return String.class;
		else if(columnIndex==5)
			return String.class;
		else if(columnIndex==6)
			return Double.class;
		else if(columnIndex==7)
			return String.class;
		else if(columnIndex==8)
			return String.class;
		else if(columnIndex==9)
			return String.class;
		return null;
	}
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex==1)
			return false;
		else if(columnIndex==2)
			return false;
		else if(columnIndex==9)
			return false;
		else
			return true;
	}
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = value;
		this.fireTableCellUpdated(rowIndex, columnIndex);
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
	public void refreshTable(Object[][] data2) {
		data = data2;
		this.fireTableDataChanged();
	}
	public void updateTable(Object[] obj) {
		data = null;
		data = new Object[1][columnNames.length];
		data[0] = obj;
		this.fireTableDataChanged();
	}
	public void deleteData(int index) {
		int size = data.length - 1;
		Object[][] dump = new Object[size][columnNames.length];
		int j = 0;
		for(int i=0;i<data.length;i++){
			if(i!=index)
				dump[j++] = data[i];
		}
		data = dump;
		this.fireTableRowsDeleted(index, index);
	}
}
