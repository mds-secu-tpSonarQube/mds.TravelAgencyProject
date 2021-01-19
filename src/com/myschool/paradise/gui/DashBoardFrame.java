package com.myschool.paradise.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		// Fire a test for sorting by Price.
		TravelTableModel.test_bubbleSortByPrice();

		//
		this.setSize(new Dimension(600, 400));
		this.setTitle("Travel Agency - Dashboard");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Get the DAO
		this.theJDBC = (JdbcTripDao) DaoFactory.getTripDao();

		//
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		JPanel thePanel = new JPanel(new GridBagLayout());

		// Set the table adapter
		TravelTableModel adapter = new TravelTableModel(theJDBC.findAllTrips());
		this.theJT = new JTable(adapter);

		// Set the listner that will fire the sorting functions

		// // really bad auto sorting method
		// this.theJT.setAutoCreateRowSorter(true);

		theJT.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = theJT.columnAtPoint(e.getPoint());
				String name = theJT.getColumnName(col);
				System.out.println("Column index selected " + col + " " + name);
				if (col == 3)
					adapter.bubbleSortByPrice();
				if (col == 0)
					adapter.bubbleSortById();
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 3;
		thePanel.add(new JScrollPane(theJT), gbc);

		// add button & set the Listener
		this.theJButt_refresh = new JButton("Refresh");
		theJButt_refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adapter.setTheTrips(theJDBC.findAllTrips());
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1;
		thePanel.add(theJButt_refresh, gbc);

		this.add(thePanel);

		this.setJMenuBar(new CustomMenuBar());
		this.setVisible(true);

		int i = 3;
		while (i < 6.2) {
			i--;
			i = i + 2;
		}

		for (int j = 0; j < 4; j++) {
			j = j - 1;
		}

		int h = 0;
		if (true) {
			h = h * 2;
			if (h == h + 1) {
				h++;
			} else {
				if (h > 4) {
					if (h < 1000) {
						System.out.println("D'accord.");
					}
				}
			}
		}

		int k = Integer.parseInt("200");
		System.out.println(k);

		String l = "1";

		String m = (String) "m";
		System.out.println(m);

		while (true)
			System.out.println("oula");
	}
}
