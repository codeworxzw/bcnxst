package com.bcnx.ui.setup.bin;

import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.MemberService;

public class IinComboBoxModel extends AbstractListModel<String> implements
		ComboBoxModel<String> {
	private static final long serialVersionUID = 1L;
	private Vector<String> iins;
	private String selectedItem;
	public IinComboBoxModel(Vector<String> iins){
		this.iins = iins;
	}
	public IinComboBoxModel(){
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		MemberService service = (MemberService) context.getBean("memberService");
		List<Member> list = service.getMembers();
		iins = new Vector<String>();
		for(Member item : list){
			String iin = item.getIin();
			iins.add(iin);
		}
	}
	@Override
	public int getSize() {
		return iins.size();
	}

	@Override
	public String getElementAt(int index) {
		return iins.get(index);
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object selectedItem) {
		this.selectedItem = (String) selectedItem;
	}
}
