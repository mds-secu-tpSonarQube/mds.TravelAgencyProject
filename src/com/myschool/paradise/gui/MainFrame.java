package com.myschool.paradise.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	JButton jButt2 ; 
	
	public MainFrame() {
		setTitle("JavaParadise");
		setSize(580,400);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jPan = new JPanel(new BorderLayout());
		
		JButton jButt = new JButton("Hello action !");
		jPan.add(jButt, BorderLayout.NORTH); 
		
		jButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jButt2.setText(jButt2.getText() + "!");
			}
		});
		
		this.jButt2 = new JButton("hey"); 
		jPan.add(jButt2, BorderLayout.WEST); 
		
		
		setContentPane(jPan);
	}
}
