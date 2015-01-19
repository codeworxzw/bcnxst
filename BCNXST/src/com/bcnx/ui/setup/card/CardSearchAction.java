package com.bcnx.ui.setup.card;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.CardAcctService;

public class CardSearchAction implements DocumentListener {
	private JTable table;
	private JTextField searchText;
	
	public CardSearchAction(JTable table, JTextField searchText) {
		super();
		this.table = table;
		this.searchText = searchText;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateTable(searchText.getText());
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateTable(searchText.getText());
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateTable(searchText.getText());
	}

	private void updateTable(String text) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		CardAcctService service = (CardAcctService) context.getBean("cardAccountService");
		CardParamTable model = (CardParamTable) table.getModel();
		model.refreshTable(UtilPackage.cardAccountToArray(service.getCardLike(text)));
	}

}
