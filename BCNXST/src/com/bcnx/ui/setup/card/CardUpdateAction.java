package com.bcnx.ui.setup.card;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.CardAcct;
import com.bcnx.data.service.CardAcctService;

public class CardUpdateAction implements ActionListener{
	private JTable table;
	
	public CardUpdateAction(JTable table) {
		super();
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		CardAcctService service = (CardAcctService) context.getBean("cardAccountService");
		int i = table.getSelectedRow();
		if(i<0){
			JOptionPane.showMessageDialog(null, "Data No Selected", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Boolean chk = (Boolean) table.getModel().getValueAt(i, 0);
		if(chk.equals(new Boolean(false)))
			return;
		
		CardParamTable model = (CardParamTable) table.getModel();
		CardAcct c = new CardAcct();
		c.setId((Integer)model.getValueAt(i, 1));
		c.setCard((String)model.getValueAt(i, 2));
		c.setType((String)model.getValueAt(i, 3));
		c.setCurr((String)model.getValueAt(i,4));
		c.setFlag((String)model.getValueAt(i, 5));
		c.setBal((Double)model.getValueAt(i, 6));
		c.setExp((String)model.getValueAt(i, 7));
		c.setCav((String)model.getValueAt(i, 8));
		c.setBin((String)model.getValueAt(i, 9));
		service.update(c);
		model.setValueAt(c.getId(), i, 1);
		model.setValueAt(c.getCard(), i, 2);
		model.setValueAt(c.getType(), i, 3);
		model.setValueAt(c.getCurr(), i, 4);
		model.setValueAt(c.getFlag(), i, 5);
		model.setValueAt(c.getBal(), i, 6);
		model.setValueAt(c.getExp(), i, 7);
		model.setValueAt(c.getCav(), i, 8);
		model.setValueAt(c.getBin(),i,9);
	}

}
