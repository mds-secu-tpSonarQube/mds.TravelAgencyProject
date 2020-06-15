package com.myschool.paradise.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CustomMenuBar extends JMenuBar {
	JMenu theJM ; 
	JMenuItem theJMI_AddPlace ; 
	JMenuItem theJMI_AddTrip ; 
	JMenuItem theJMI_Quit ; 
	
	/**
	 * Create the MenuBar without the "Quit" option
	 */
	public CustomMenuBar() {
		this.theJMI_AddPlace = new JMenuItem("Add a Place"); 
		this.theJMI_AddPlace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new AddPlaceFrame(); }
		});
		this.theJMI_AddTrip = new JMenuItem("Add a Trip"); 
		this.theJMI_AddTrip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new AddTripFrame(); }
		});
		
		this.theJM = new JMenu("Menu") ; 
		this.theJM.add(theJMI_AddPlace);
		this.theJM.add(theJMI_AddTrip);
		this.theJM.setVisible(true);
		
		this.add(theJM);
		this.setVisible(true);
		
		this.setVisible(true);
	}
	
	/**
	 * Create the MenuBar with the "Quit" option
	 * @param context The JFrame that will be close at "Quit" option. The good use is to pass "this".
	 */
	public CustomMenuBar(JFrame context) {
		this.theJMI_AddPlace = new JMenuItem("Add a Place"); 
		this.theJMI_AddPlace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new AddPlaceFrame(); }
		});
		this.theJMI_AddTrip = new JMenuItem("Add a Trip"); 
		this.theJMI_AddTrip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new AddTripFrame(); }
		});
		this.theJMI_Quit = new JMenuItem("Quit"); 
		this.theJMI_Quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { context.dispose(); }
		});
		
		this.theJM = new JMenu("Menu") ; 
		this.theJM.add(theJMI_AddPlace);
		this.theJM.add(theJMI_AddTrip);
		this.theJM.add(theJMI_Quit);
		this.theJM.setVisible(true);
		
		this.add(theJM);
		this.setVisible(true);
		
		this.setVisible(true);
	}
}
