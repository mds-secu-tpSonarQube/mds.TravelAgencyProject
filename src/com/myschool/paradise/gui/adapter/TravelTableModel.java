package com.myschool.paradise.gui.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.myschool.paradise.model.Place;
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

	public void sortByPrice() {
		List<Trip> sortedTrips = new ArrayList<Trip>() ; 

		for (int i = 0; i < this.theTrips.size() ; i++) {


		}
	}

	public void bubbleSortByPrice() {
		List<Trip> sortedTrips = new ArrayList<Trip>() ; 

		for (int i=0  ;  i < this.theTrips.size() -1  ;  i++) {
			for (int j=0  ;  j < this.theTrips.size() -i -1  ;  j++) {

				if ( this.theTrips.get(j).getPrice() > this.theTrips.get(j+1).getPrice() ) {
					Collections.swap(this.theTrips, j, j+1);
					//					System.err.println("Swapped :" + Math.round(this.theTrips.get(j).getPrice()) + " with " + Math.round(this.theTrips.get(j+1).getPrice()) );
				}
			}
		}
	}
	public void bubbleSortById() {
		List<Trip> sortedTrips = new ArrayList<Trip>() ; 
		
		for (int i=0  ;  i < this.theTrips.size() -1  ;  i++) {
			for (int j=0  ;  j < this.theTrips.size() -i -1  ;  j++) {
				
				if ( this.theTrips.get(j).getId() > this.theTrips.get(j+1).getId() ) {
					Collections.swap(this.theTrips, j, j+1);
					//					System.err.println("Swapped :" + Math.round(this.theTrips.get(j).getPrice()) + " with " + Math.round(this.theTrips.get(j+1).getPrice()) );
				}
			}
		}
	}

	public static void test_bubbleSortByPrice() {
		// Init utils vars
		String testLabel = "_test_bubbleSortByPrice_ : ";
		System.out.println(testLabel + "Start test.");
		boolean testGood = true;
		int ctc = 0 ; // for Check Test Counter

		
		
		// Init tested vars
		Long idCounter = 0L ; 
		int nbTripToCreate = 20 ; 
		List<Trip> randomTrips = new ArrayList<Trip>() ; 
		TravelTableModel randomTripsInTable = new TravelTableModel(randomTrips); 

		System.out.println(testLabel + "Add Trips.");
		for (int i=0  ;  i < nbTripToCreate  ;  i++) 
			randomTrips.add( new Trip(idCounter++, new Place(), new Place(), Math.random()*100)  ); 			


		
		// PRE-CHECK if the List is already sorted ! Might never happens, but who knows... 
		testGood = true ; 
		ctc = 0 ; 
		while(testGood  &&  ctc < randomTrips.size()-1 ) {
			if(randomTrips.get(ctc).getPrice() > randomTrips.get(ctc+1).getPrice() )
				testGood = false ; 
			ctc++;
		}
		if (testGood)
			System.err.println(testLabel+ "List ALREADY SORTED !") ;
		else 
	
			
			
		{
			System.out.println(testLabel + "Display Trips.");
			for (Trip trip : randomTrips) 
				System.out.print(Math.round(trip.getPrice())  + " | ");
			System.out.println();

			System.out.println(testLabel + "Sort Trips.");
			randomTripsInTable.bubbleSortByPrice();


			System.out.println(testLabel + "Display sorted Trips.");
			for (Trip trip : randomTrips)
				System.out.print(Math.round(trip.getPrice()) + " | ");
			System.out.println();


			
			// Check if the sorting has been done successfully
			testGood = true ; 
			ctc = 0 ; 
			while(testGood  &&  ctc < randomTrips.size()-1 ) {
				if(randomTrips.get(ctc).getPrice() > randomTrips.get(ctc+1).getPrice() )
					testGood = false ; 
				ctc++;
			}
			if (testGood)
				System.out.println(testLabel+ "List sorted successfuly !") ;
			else 
				System.err.println(testLabel+ "List NOT sorted successfuly !");
		}
		
		System.out.println(testLabel+ "End test.");
	}

}
