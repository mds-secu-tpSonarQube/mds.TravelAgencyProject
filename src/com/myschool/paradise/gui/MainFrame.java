package com.myschool.paradise.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.myschool.paradise.util.Globals;

public class MainFrame extends JFrame {
	JButton jButt2 ; 
	
	JPanel pan_thePanel ;
	JButton butt_goToAddPlace ; 
	JButton butt_goToAddTrip ; 
	
	public MainFrame() {
		setTitle("JavaParadise");
		this.setSize(Globals.DEFAULT_DIMENSIONS);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pan_thePanel = new JPanel(new BorderLayout());

		this.butt_goToAddPlace = new JButton("Add a place"); 
		this.butt_goToAddPlace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddPlaceFrame();
			}
		});
		this.pan_thePanel.add(butt_goToAddPlace, BorderLayout.WEST);
		
		this.butt_goToAddTrip = new JButton("Add a trip"); 
		this.butt_goToAddTrip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddTripFrame();
			}
		});
		this.pan_thePanel.add(butt_goToAddTrip, BorderLayout.EAST);
		
//		JButton jButt = new JButton("Hello action !");
//		this.pan_thePanel.add(jButt, BorderLayout.NORTH); 
//		
//		jButt.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				jButt2.setText(jButt2.getText() + "!");
//				JOptionPane.showConfirmDialog(null, "Hop Popup");
//			}
//		});
		
//		this.jButt2 = new JButton("hey"); 
//		this.pan_thePanel.add(jButt2, BorderLayout.WEST); 
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("File");
		JMenuItem jMenuItem = new JMenuItem("Close"); 
		jMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		jMenu.add(jMenuItem);
		jMenuBar.add(jMenu); 
		
		
		setContentPane(this.pan_thePanel);
		setJMenuBar(jMenuBar);
	}
}
