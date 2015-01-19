package com.bcnx.ui.setup.bin;

import javax.swing.table.AbstractTableModel;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.BinService;

public class BinParamTable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"CHK","NO","BIN","TYPE","IIN"};
	private Object[][] data;
	public BinParamTable(){
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		BinService service = (BinService) context.getBean("binService");
		data = UtilPackage.binsToArray(service.getBin());
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
		else
			return null;
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex!=1)
			return true;
		else
			return false;
	}
	@Override
	public void setValueAt(Object val, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = val;
		this.fireTableCellUpdated(rowIndex, columnIndex);
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
