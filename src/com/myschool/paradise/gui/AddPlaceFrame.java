package com.myschool.paradise.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.myschool.paradise.util.Globals;

public class AddPlaceFrame extends JFrame {
	JPanel pan_thePanel ;
	JButton butt_addPlace ; 
	JTextField txtField_namePlace ; 
	
	public AddPlaceFrame() {
		this.setTitle("Add place");
		this.setSize(Globals.SMALL_DIMENSIONS);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.pan_thePanel = new JPanel(new GridLayout(1,2));
		this.pan_thePanel.setSize(Globals.ASKBOX_DIMENSIONS);
		
		this.txtField_namePlace = new JTextField(); 
		this.pan_thePanel.add(this.txtField_namePlace);

		this.butt_addPlace = new JButton(); 
		this.butt_addPlace.setText("Add place");
		this.pan_thePanel.add(this.butt_addPlace);
		
		setContentPane(this.pan_thePanel);
		this.setVisible(true);
	}
}
