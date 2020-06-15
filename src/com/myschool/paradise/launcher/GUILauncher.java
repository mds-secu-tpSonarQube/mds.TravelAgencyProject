package com.myschool.paradise.launcher;

import javax.swing.SwingUtilities;

import com.myschool.paradise.gui.DashBoardFrame;
import com.myschool.paradise.gui.MainFrame;

public class GUILauncher {
	public static void main(String[] args) {
		System.out.println("GUILauncher launching");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DashBoardFrame(); 
			}
		});
	}
}
