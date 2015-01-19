package com.bcnx.ui.setup.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.MemberService;

public class MemberAddAction implements ActionListener {
	private JTextField memIdText;
	private JTextField iinText;
	private JTextField nameText;
	private JTextField locationText;
	private JTable table;
	public MemberAddAction(JTextField memIdText, JTextField iinText,
			JTextField nameText, JTextField locationText, JTable table) {
		this.memIdText = memIdText;
		this.iinText = iinText;
		this.nameText = nameText;
		this.locationText = locationText;
		this.table = table;
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		MemberService memberService = (MemberService) context.getBean("memberService");
		String memId = memIdText.getText();
		String iin = iinText.getText();
		String name = nameText.getText();
		String location = locationText.getText();
		
		// validate input
		if(iin==null||iin.isEmpty()){
			JOptionPane.showMessageDialog(null, "EMPTY IIN", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(memId==null||memId.isEmpty()){
			JOptionPane.showMessageDialog(null, "EMPTY MEMBER ID", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(name==null||name.isEmpty()){
			JOptionPane.showMessageDialog(null, "EMPTY NAME", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(location==null||location.isEmpty()){
			JOptionPane.showMessageDialog(null, "EMPTY LOCATION", "Error Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Member member = new Member();
		member.setIin(iin);
		member.setMemId(memId);
		member.setName(name);
		member.setLocation(location);
		Member mem = memberService.getMemberFromIIN(iin);
		if(mem == null){
			memberService.save(member);
			Member memb = memberService.getMemberFromIIN(iin);
			MemberParamTable model = (MemberParamTable) table.getModel();
			Object[] mems = new Object[]{new Boolean(false),memb.getId(),memb.getIin(),memb.getMemId(),memb.getName(),memb.getLocation()};
			model.addRow(mems);
		}
		else{
			JOptionPane.showMessageDialog(null, "Duplicate IIN", "Error Dialog", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
