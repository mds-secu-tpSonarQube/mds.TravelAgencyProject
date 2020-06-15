package com.myschool.paradise.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.myschool.paradise.dao.DaoFactory;
import com.myschool.paradise.dao.PlaceDao;
import com.myschool.paradise.dao.TripDao;
import com.myschool.paradise.gui.adapter.PlaceComboBoxModel;
import com.myschool.paradise.model.Place;
import com.myschool.paradise.model.Trip;
import com.myschool.paradise.util.Globals;

public class AddTripFrame extends JFrame {
	BorderLayout theMainLayout ; 
	GridBagLayout theGBLayout;
	FlowLayout theFLayout ; 

	JPanel pan_thePanel1 ;
	JPanel pan_thePanel2 ; 

	JLabel label_from ; 
	JLabel label_to ; 
	JLabel label_price ; 

	JComboBox<Place> cBox_from ; 
	JComboBox<Place> cBox_to ; 
	JTextField txtF_price ; 

	JButton butt_addTrip ;
	JButton butt_cancel ;

	private TripDao theTripDao ; 
	private PlaceDao thePlaceDao ; 

	public AddTripFrame() {
		this.setTitle("Add Trip");
		this.setSize(Globals.SMALL_DIMENSIONS);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



		this.theTripDao = DaoFactory.getTripDao();
		this.thePlaceDao = DaoFactory.getPlaceDao();



		this.theMainLayout = new BorderLayout();
		this.theGBLayout = new GridBagLayout();
		this.theFLayout = new FlowLayout();



		this.label_from = new JLabel("From : ");
		this.label_to = new JLabel("To : ");
		this.label_price = new JLabel("Price : ");



		List<Place> aListOfPlaces = this.thePlaceDao.findAllPlaces(); 

		this.cBox_from = new JComboBox<Place>( new PlaceComboBoxModel(aListOfPlaces) ); 
		this.cBox_from.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(cBox_from.getSelectedItem());
			}
		});

		this.cBox_to = new JComboBox<Place>( new PlaceComboBoxModel(aListOfPlaces) );

		this.txtF_price = new JTextField();



		this.butt_cancel = new JButton("Cancel"); 
		this.butt_addTrip = new JButton("Add Trip"); 
		this.butt_addTrip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Trip aNewTrip = new Trip() ; 
				aNewTrip.setDeparture( (Place) cBox_from.getSelectedItem() );
				aNewTrip.setDestination( (Place) cBox_to.getSelectedItem() );
				aNewTrip.setPrice( Double.valueOf(txtF_price.getText()) );

				try {
					Long idInserted = theTripDao.createTrip(aNewTrip); 
					if (idInserted != null ) {
						System.out.println("good");
						JOptionPane.showConfirmDialog(null, "Trip added with the id : "+idInserted);
					} 
					else 
						System.out.println("Not inserted, careful : no error might have been catched ?");
				} catch (NumberFormatException nFE) {
					System.err.println(nFE.getMessage());
				}


			}
		});



		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL ; 
		gbc.weightx = 1 ; 

		this.pan_thePanel1 = new JPanel(this.theGBLayout);

		//		this.pan_thePanel1.setSize(Globals.ASKBOX_DIMENSIONS); 
		gbc.gridx = 0 ;
		gbc.gridy = 0 ; 
		this.pan_thePanel1.add(this.label_from, gbc);
		gbc.gridx = 1 ;
		gbc.gridy = 0 ; 
		//		gbc.weightx = 0.5 ; 
		this.pan_thePanel1.add(this.cBox_from, gbc);

		gbc.gridx = 0 ;
		gbc.gridy = 1 ; 
		//		gbc.weightx = 0.5 ; 
		this.pan_thePanel1.add(this.label_to, gbc);

		gbc.gridx = 1 ;
		gbc.gridy = 1 ; 
		//		gbc.weightx = 0.5 ; 
		this.pan_thePanel1.add(this.cBox_to, gbc);

		gbc.gridx = 0 ;
		gbc.gridy = 2 ; 
		//		gbc.weightx = 0.5 ; 
		this.pan_thePanel1.add(this.label_price, gbc);

		gbc.gridx = 1 ;
		gbc.gridy = 2 ; 
		//		gbc.weightx = 0.5 ; 
		this.pan_thePanel1.add(this.txtF_price, gbc);



		this.pan_thePanel2 = new JPanel(this.theFLayout); 
		this.pan_thePanel2.add(this.butt_cancel);
		this.pan_thePanel2.add(this.butt_addTrip);



		this.setLayout(this.theMainLayout);
		this.add(pan_thePanel1, BorderLayout.PAGE_START);
		this.add(pan_thePanel2, BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
