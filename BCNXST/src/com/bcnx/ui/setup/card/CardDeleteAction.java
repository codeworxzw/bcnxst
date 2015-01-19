package com.bcnx.ui.setup.card;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.CardAcct;
import com.bcnx.data.service.CardAcctService;

public class CardDeleteAction implements ActionListener {
	private JTable table;
	public CardDeleteAction(JTable table) {
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
		service.delete(c);
		model.deleteData(i);
	}

}
