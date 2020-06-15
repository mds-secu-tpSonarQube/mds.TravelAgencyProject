package com.myschool.paradise.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.myschool.paradise.dao.DaoFactory;
import com.myschool.paradise.dao.jdbc.JdbcTripDao;
import com.myschool.paradise.gui.adapter.TravelTableModel;

public class DashBoardFrame extends JFrame {
	JMenuBar theJMB;
	JMenu theJM;
	JMenuItem theJMI_AddPlace;
	JMenuItem theJMI_AddTrip;
	JMenuItem theJMI_Quit;

	JdbcTripDao theJDBC;

	JTable theJT;

	JButton theJButt_refresh;

	public DashBoardFrame() {
		this.setSize(new Dimension(600,400));
		this.setTitle("Travel Agency - Dashboard");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.theJDBC = (JdbcTripDao) DaoFactory.getTripDao(); 


		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH ; 
		gbc.weightx = 1 ; 
		JPanel thePanel = new JPanel( new GridBagLayout() );


		TravelTableModel adapter = new TravelTableModel(theJDBC.findAllTrips()); 
		this.theJT = new JTable(adapter); 
		//		// really bad auto sorting methodes
		//		this.theJT.setAutoCreateRowSorter(true);

		gbc.gridx = 0 ;
		gbc.gridy = 0 ; 
		gbc.weighty = 3 ; 
		thePanel.add(new JScrollPane(theJT) , gbc);

		this.theJButt_refresh = new JButton("Refresh");
		theJButt_refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adapter.setTheTrips(theJDBC.findAllTrips()); 
			}
		});

		gbc.gridx = 0 ;
		gbc.gridy = 1 ; 
		gbc.weighty = 1 ; 
		thePanel.add(theJButt_refresh , gbc);

		this.add(thePanel) ;

		this.setJMenuBar(new CustomMenuBar());
		this.setVisible(true);
	}

}
