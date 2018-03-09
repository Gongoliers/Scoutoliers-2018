package com.thegongoliers.scoutoliers.powerup2018.frontend;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		l2 = new JLabel("Enter a team number.");
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
		
		frame.add(l1);
		frame.add(l2);
		frame.add(f1);
		frame.add(b1);
		
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(FrontendMain.ws.icon.getImage());
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 700);
		frame.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int i;
				try {
					i = Integer.parseInt(f1.getText());
					if (i < 1 || i > 7000) Integer.parseInt("lol");
				} catch (Exception e) {
					f1.setText("");
					return;
				}
				b1.removeActionListener(this);
				beginDataCollection(i);
			}
		});
		
	}
	
	public void beginDataCollection(int teamNumber) {
		
		FrontendMain.out.println("PRESCOUT " + teamNumber);
		
		l2.setText("Now prescouting team " + teamNumber);
		
		// TODO
		
	}
	
}
