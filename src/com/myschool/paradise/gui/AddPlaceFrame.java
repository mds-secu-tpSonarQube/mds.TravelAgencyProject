package com.myschool.paradise.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.myschool.paradise.dao.DaoFactory;
import com.myschool.paradise.dao.PlaceDao;
import com.myschool.paradise.dao.TripDao;
import com.myschool.paradise.dao.jdbc.JdbcPlaceDao;
import com.myschool.paradise.model.Place;
import com.myschool.paradise.util.Globals;

public class AddPlaceFrame extends JFrame {
	JPanel pan_thePanel ;
	JButton butt_addPlace ; 
	JTextField txtField_namePlace ; 
	
	private PlaceDao placeDao;
	
	public AddPlaceFrame() {
		this.setTitle("Add place");
		this.setSize(Globals.SMALL_DIMENSIONS);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		placeDao = DaoFactory.getPlaceDao();
		
		this.pan_thePanel = new JPanel(new GridLayout(1,2));
		this.pan_thePanel.setSize(Globals.ASKBOX_DIMENSIONS);
		
		this.txtField_namePlace = new JTextField(); 
		this.pan_thePanel.add(this.txtField_namePlace);

		this.butt_addPlace = new JButton(); 
		this.butt_addPlace.setText("Add place");
		this.butt_addPlace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Place aNewPlace = new Place(); 
				aNewPlace.setName(txtField_namePlace.getText());
				placeDao.createPlace( aNewPlace ); 
				dispose();
			}
		});
		this.pan_thePanel.add(this.butt_addPlace);
		
		setContentPane(this.pan_thePanel);
		this.setVisible(true);
		this.setJMenuBar(new CustomMenuBar(this));
	}
}
