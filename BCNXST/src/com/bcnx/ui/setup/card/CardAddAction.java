package com.bcnx.ui.setup.card;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.CardAcct;
import com.bcnx.data.service.CardAcctService;

public class CardAddAction implements ActionListener {
	private JComboBox<String> binBox;
	private JFormattedTextField cardText;
	private JComboBox<String> typeBox;
	private JComboBox<String> currBox;
	private JComboBox<String> flagBox;
	private JFormattedTextField balText;
	private JFormattedTextField expText;
	private JFormattedTextField cavText;
	private JTable table;
	public CardAddAction(JComboBox<String> binBox,
			JFormattedTextField cardText, JComboBox<String> typeBox,
			JComboBox<String> currBox, JComboBox<String> flagBox,
			JFormattedTextField balText, JFormattedTextField expText,
			JFormattedTextField cavText, JTable table) {
		super();
		this.binBox = binBox;
		this.cardText = cardText;
		this.typeBox = typeBox;
		this.currBox = currBox;
		this.flagBox = flagBox;
		this.balText = balText;
		this.expText = expText;
		this.cavText = cavText;
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String bin = (String) binBox.getSelectedItem();
		String card = cardText.getText().trim();
		String type = (String) typeBox.getSelectedItem();
		String curr = (String) currBox.getSelectedItem();
		String flag = (String) flagBox.getSelectedItem();
		String bal  = balText.getText().replaceAll(",", "");
		String exp  = expText.getText();
		String cav  = cavText.getText();
		
		if(bin==null||bin.isEmpty()){
			JOptionPane.showMessageDialog(null, "BIN is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(card==null||card.isEmpty()){
			JOptionPane.showMessageDialog(null, "CARD is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(type==null||type.isEmpty()){
			JOptionPane.showMessageDialog(null, "TYPE is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(curr==null||curr.isEmpty()){
			JOptionPane.showMessageDialog(null, "CURRENCY is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(flag==null||flag.isEmpty()){
			JOptionPane.showMessageDialog(null, "FLAG is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(bal==null||bal.isEmpty()){
			JOptionPane.showMessageDialog(null, "BALANCE is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(exp==null||exp.isEmpty()){
			JOptionPane.showMessageDialog(null, "EXPIRE DATE is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(cav==null||cav.isEmpty()){
			JOptionPane.showMessageDialog(null, "CAV is Empty", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		CardAcctService service = (CardAcctService) context.getBean("cardAcctService");
		CardAcct acct = new CardAcct();
		acct.setBin(bin);
		acct.setCard(bin+card);
		acct.setType(type);
		acct.setCurr(curr);
		acct.setFlag(flag);
		acct.setBal(Double.parseDouble(bal));
		acct.setExp(exp);
		acct.setCav(cav);
		CardAcct ac = service.getCardAcct(acct);
		if(ac != null){
			JOptionPane.showMessageDialog(null, "Duplicate CARD", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		service.save(acct);
		CardAcct cardAccounts = service.getCardAcct(acct);
		CardParamTable model = (CardParamTable) table.getModel();
		model.addRow(new Object[] { new Boolean(false),cardAccounts.getId(),
				cardAccounts.getCard(), cardAccounts.getType(),
				cardAccounts.getCurr(), cardAccounts.getFlag(),
				cardAccounts.getBal(), cardAccounts.getExp(),
				cardAccounts.getCav(), cardAccounts.getBin() });
	}

}
