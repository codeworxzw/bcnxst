package com.bcnx.ui.setup.member;

import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.MemberService;

public class MemberIinTextSearch implements DocumentListener {
	private JTable table;
	private JTextField iinField;
	public MemberIinTextSearch(JTable table,JTextField iinField) {
		this.table = table;
		this.iinField = iinField;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		
		updateTable(iinField.getText().trim());
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateTable(iinField.getText().trim());
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateTable(iinField.getText().trim());
	}

	private void updateTable(String trim) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		MemberService service = (MemberService) context.getBean("memberService");
		List<Member> mems = service.getMembersLike(trim);
		if(mems==null)
			return;
		Object[][] data = UtilPackage.membersToArray(mems);
		MemberParamTable model = (MemberParamTable) table.getModel();
		model.refreshTable(data);
	}

}
