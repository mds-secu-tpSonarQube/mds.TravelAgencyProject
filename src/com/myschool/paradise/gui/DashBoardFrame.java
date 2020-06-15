package com.myschool.paradise.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DashBoardFrame extends JFrame {
	JMenuBar theJMB ; 
	JMenu theJM ; 
	JMenuItem theJMI_AddPlace ; 
	JMenuItem theJMI_AddTrip ; 
	JMenuItem theJMI_Quit ; 
	
	public DashBoardFrame() {
		this.setSize(new Dimension(600,400));
		this.setTitle("Travel Agency - Dashboard");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		
//		this.theJMI_AddPlace = new JMenuItem("Add a Place"); 
//		this.theJMI_AddPlace.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { new AddPlaceFrame(); }
//		});
//		this.theJMI_AddTrip = new JMenuItem("Add a Trip"); 
//		this.theJMI_AddTrip.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { new AddTripFrame(); }
//		});
//		this.theJMI_Quit = new JMenuItem("Quit"); 
//		this.theJMI_Quit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { new AddPlaceFrame(); }
//		});
//		
//		this.theJM = new JMenu("Menu") ; 
//		this.theJM.add(theJMI_AddPlace);
//		this.theJM.add(theJMI_AddTrip);
//		this.theJM.add(theJMI_Quit);
//		this.theJM.setVisible(true);
//		
//		this.theJMB = new JMenuBar();
//		this.theJMB.add(theJM);
//		this.theJMB.setVisible(true);
		
		this.setJMenuBar(new CustomMenuBar());
		this.setVisible(true);
	}
}
