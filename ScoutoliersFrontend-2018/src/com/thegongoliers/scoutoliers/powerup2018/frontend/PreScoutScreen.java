package com.thegongoliers.scoutoliers.powerup2018.frontend;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Nicholas Bottone
 * @since 18.3.8
 */
public class PreScoutScreen {
	
	JFrame frame;
	
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JLabel l4;
	
	public JTextField f1;
	public JTextField f2;
	public JTextField f3;
	public JTextField f4;
	public JTextField f5;
	
	public JButton b1;
	public JButton b2;
	public JButton b3;
	
	public PreScoutScreen() {
		
		frame = new JFrame("Pre-Scouting - Scoutoliers");
		
		l1 = new JLabel("Scoutoliers Pre-Scouting");
		l2 = new JLabel("Please select a team.");
		l3 = new JLabel();
		l4 = new JLabel();
		
		f1 = new JTextField(12);
		f2 = new JTextField(12);
		f3 = new JTextField(12);
		f4 = new JTextField(12);
		f5 = new JTextField(12);
		
		b1 = new JButton("START");
		b2 = new JButton();
		b3 = new JButton();
		
		l1.setFont(new Font("", Font.BOLD, 36));
		l2.setFont(new Font("", Font.PLAIN, 20));
		l3.setFont(new Font("", Font.PLAIN, 20));
		l4.setFont(new Font("", Font.PLAIN, 20));
		
		// TODO
		
	}
	
	public void beginDataCollection(int teamNumber) {
		
		// TODO
		
	}
	
}
