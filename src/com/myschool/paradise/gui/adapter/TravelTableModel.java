package com.myschool.paradise.gui.adapter;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.myschool.paradise.model.Trip;

public class TravelTableModel extends AbstractTableModel {
	List<Trip> theTrips ; 

	public TravelTableModel(List aNewTripList) {
		this.theTrips = aNewTripList ; 
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return this.theTrips.size(); 
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object ret = null ; 
		Trip aTrip = this.theTrips.get(row);

		if(col == 0 ) ret = aTrip.getId();
		else if(col == 1 ) ret = aTrip.getDeparture();
		else if(col == 2 ) ret = aTrip.getDestination();
		else if(col == 3 ) ret = aTrip.getPrice();
		else System.err.println("Error at getValueAt() #12385496");

		return ret ;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false ;
	}

	@Override
	public String getColumnName(int column) {
		String ret ; 

		switch (column) {
		case 0:
			ret = "ID"; 
			break;
		case 1:
			ret = "Departure"; 
			break;
		case 2:
			ret = "Destination"; 
			break;
		case 3:
			ret = "Price"; 
			break;
		default:
			//			ret = super.getColumnName(column);
			ret = "??";
			break;
		}
		return ret ; 
	}
	
	public void setTheTrips(List<Trip> theTrips) {
		this.theTrips = theTrips;
	}
	
}
