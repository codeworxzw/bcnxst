package com.bcnx.ui.setup.bin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Bin;
import com.bcnx.data.service.BinService;

public class BinSearchAction implements ActionListener {
	private JTextField searchText;
	private JTable table;
	public BinSearchAction(JTextField searchText, JTable table) {
		this.searchText = searchText;
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		BinService service = (BinService) context.getBean("binService");
		String bin = searchText.getText().trim();
		if(bin.isEmpty()||bin==null){
			return;
		}
		Bin b = service.getBin(bin);
		if(b==null)
			return;
		Object[] obj = new Object[]{new Boolean(false),b.getId(),b.getBin(),b.getType(),b.getIin()};
		BinParamTable model = (BinParamTable) table.getModel();
		model.updateTable(obj);
	}

}
