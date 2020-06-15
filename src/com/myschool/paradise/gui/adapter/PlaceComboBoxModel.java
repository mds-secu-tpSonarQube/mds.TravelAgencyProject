package com.myschool.paradise.gui.adapter;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import com.myschool.paradise.model.Place;

public class PlaceComboBoxModel implements ComboBoxModel<Place>{
	private List<Place> theList ; 
	private Place theSelectedItem ; 

	public PlaceComboBoxModel(List<Place> alist) {
		this.theList = alist ; 
	}
	
	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public Place getElementAt(int index) {
		return this.theList.get(index); 
	}

	@Override
	public int getSize() {
		return this.theList.size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object getSelectedItem() {
		return this.theSelectedItem ; 
	}

	@Override
	public void setSelectedItem(Object anItem) {
		this.theSelectedItem = this.theList.get(this.theList.indexOf(anItem)); 
	}

}
