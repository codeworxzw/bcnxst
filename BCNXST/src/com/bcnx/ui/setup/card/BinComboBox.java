package com.bcnx.ui.setup.card;

import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Bin;
import com.bcnx.data.service.BinService;

public class BinComboBox extends JComboBox<String> implements PopupMenuListener {
	private static final long serialVersionUID = 1L;
	public BinComboBox(){
		BinComboBoxModel model = new BinComboBoxModel();
		setModel(model);
		this.addPopupMenuListener(this);
	}
	
	@Override
	public void popupMenuCanceled(PopupMenuEvent e) {}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		BinService service = (BinService) context.getBean("binService");
		List<Bin> list = service.getBin();
		Vector<String> bins = new Vector<String>();
		for(Bin bin : list){
			bins.add(bin.getBin());
		}
		BinComboBoxModel aModel =  new BinComboBoxModel(bins);
		this.setModel(aModel);

	}

}
