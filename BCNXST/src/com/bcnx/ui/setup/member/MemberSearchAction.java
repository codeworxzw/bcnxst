package com.bcnx.ui.setup.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.MemberService;

public class MemberSearchAction implements ActionListener {
	private JTable table;
	private JTextField iinText;
	public MemberSearchAction(JTable table, JTextField iinText) {
		this.table = table;
		this.iinText = iinText;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		MemberService service = (MemberService) context.getBean("memberService");
		String iin = iinText.getText().trim();
		Member mem = service.getMemberFromIIN(iin);
		if(mem==null)
			return;
		MemberParamTable tableModel = (MemberParamTable) table.getModel();
		Object[] rowData = new Object[]{new Boolean(false),mem.getId(),mem.getIin(),mem.getMemId(),mem.getName(),mem.getLocation()};
		tableModel.updateTable(rowData);
	}

}
