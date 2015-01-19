package com.bcnx.ui.setup.member;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MemberParamTableListener implements ListSelectionListener {
	private JTable table;
	public MemberParamTableListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int i = table.getSelectedRow();
		if(i<0)
			return;
		Object check = table.getModel().getValueAt(i, 0);
		MemberParamTable model = (MemberParamTable) table.getModel();
		if(check.equals(new Boolean(false)))
			table.getModel().setValueAt(new Boolean(true), i, 0);
		else
			table.getModel().setValueAt(new Boolean(true), i, 0);
		
		for(int row =0;row<model.getRowCount();row++){
			if(row!=i){
				table.getModel().setValueAt(new Boolean(false), row, 0);
			}
		}
	}

}
