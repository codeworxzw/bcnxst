package com.bcnx.ui.setup.bin;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.BinService;

public class BinSearchTextListener implements DocumentListener {
	private JTable table;
	private JTextField binText;
	public BinSearchTextListener(JTextField binText,JTable table) {
		this.table = table;
		this.binText = binText;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		updateText(binText.getText().trim());
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		updateText(binText.getText().trim());
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		updateText(binText.getText().trim());
	}

	private void updateText(String trim) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		BinService service = (BinService) context.getBean("binService");
		Object[][] data = UtilPackage.binsToArray(service.getBinLike(trim));
		BinParamTable model = (BinParamTable) table.getModel();
		model.refreshTable(data);
		
	}
	
}
