package com.bcnx.ui.setup.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.MemberService;

public class MemberDeleteAction implements ActionListener {
	private JTable table;
	public MemberDeleteAction(JTable table) {
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		MemberService service = (MemberService) context.getBean("memberService");
		Member member = new Member();
		int i = table.getSelectedRow();
		if(i<0){
			JOptionPane.showMessageDialog(null, "Data No Selected", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		Boolean chk = (Boolean) table.getModel().getValueAt(i, 0);
		if(chk.equals(new Boolean(false)))
			return;
		MemberParamTable tableModel = (MemberParamTable) table.getModel();

		int id = (int) tableModel.getValueAt(i, 1);
		String iin = (String) tableModel.getValueAt(i, 2);
		String memId = (String) tableModel.getValueAt(i, 3);
		String name = (String) tableModel.getValueAt(i, 4);
		String location = (String) tableModel.getValueAt(i, 5);
		member.setId(id);
		member.setIin(iin);
		member.setMemId(memId);
		member.setName(name);
		member.setLocation(location);
		service.delete(member);
		tableModel.deleteData(id);
			
	}

}
