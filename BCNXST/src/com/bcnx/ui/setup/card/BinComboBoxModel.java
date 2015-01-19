package com.bcnx.ui.setup.card;

import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.data.entity.Bin;
import com.bcnx.data.service.BinService;

public class BinComboBoxModel extends AbstractListModel<String> implements
		ComboBoxModel<String> {

	private static final long serialVersionUID = 1L;
	private Vector<String> bins ;
	private String selectedItem;
	public BinComboBoxModel(Vector<String> bins){
		this.bins = bins;
	}
	public BinComboBoxModel(){
		ApplicationContext context = BcnxApplicationContext.getApplicationContext();
		BinService service = (BinService) context.getBean("binService");
		List<Bin> list = service.getBin();
		bins = new Vector<String>();
		for(Bin bin : list){
			bins.add(bin.getBin());
		}
	}
	public void setBins(Vector<String> bins){
		this.bins = bins;
	}
	@Override
	public String getElementAt(int index) {
		return bins.get(index);
	}

	@Override
	public int getSize() {
		return bins.size();
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object obj) {
		selectedItem = (String) obj;
	}
	@Override
	protected void fireContentsChanged(Object source, int index0, int index1) {
		super.fireContentsChanged(source, index0, index1);
	}
	
}
