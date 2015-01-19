/**
 * 
 */
package com.bcnx.ui.setup.bin;

import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.MemberService;

public class IinComboBox extends JComboBox<String> implements PopupMenuListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IinComboBox(){
		IinComboBoxModel model = new IinComboBoxModel();
		setModel(model);
		addPopupMenuListener(this);
	}
	@Override
	public void popupMenuCanceled(PopupMenuEvent e) {}
	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		MemberService service = (MemberService) context.getBean("memberService");
		List<Member> list = service.getMembers();
		Vector<String> iins = new Vector<String>();
		for(Member item : list){
			String iin = item.getIin();
			iins.add(iin);
		}
		setModel(new IinComboBoxModel(iins));
		
	}

}
