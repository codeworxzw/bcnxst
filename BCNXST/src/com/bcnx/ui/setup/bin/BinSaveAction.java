package com.bcnx.ui.setup.bin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Bin;
import com.bcnx.data.service.BinService;

public class BinSaveAction implements ActionListener {
	private JTable table;
	private JComboBox<String> iinBox;
	private JComboBox<String> typeBox;
	private JTextField binText;
	
	public BinSaveAction(JTable table, JComboBox<String> iinBox,
			JComboBox<String> typeBox, JTextField binText) {
		this.table = table;
		this.iinBox = iinBox;
		this.typeBox = typeBox;
		this.binText = binText;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		BinService service = (BinService) context.getBean("binService");
		IinComboBoxModel comboModel = (IinComboBoxModel) iinBox.getModel();
		String iin = (String) comboModel.getSelectedItem();
		String bin = binText.getText().trim();
		String type = (String) typeBox.getSelectedItem();
		
		if(iin==null||iin.isEmpty()){
			JOptionPane.showMessageDialog(null, "Empty IIN", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(bin==null||bin.isEmpty()){
			JOptionPane.showMessageDialog(null, "Empty BIN", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(type==null||type.isEmpty()){
			JOptionPane.showMessageDialog(null, "Empty TYPE", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Bin b = service.getBin(bin);
		if(b==null){
			Bin bi = new Bin();
			bi.setBin(bin);
			bi.setType(type);
			bi.setIin(iin);
			service.save(bi);
			Bin bb = service.getBin(bin);
			BinParamTable model = (BinParamTable) table.getModel();
			model.addRow(new Object[]{new Boolean(false),bb.getId(),bb.getBin(),bb.getType(),bb.getIin()});
			//table.setModel(model);
		}
		else
			JOptionPane.showMessageDialog(null, "Duplicate BIN", "Error Dialog", JOptionPane.ERROR_MESSAGE);
	}

}
