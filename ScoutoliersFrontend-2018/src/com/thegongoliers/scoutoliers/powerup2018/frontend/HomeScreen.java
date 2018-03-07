package com.thegongoliers.scoutoliers.powerup2018.frontend;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Nicholas Bottone
 * @since 18.3.6
 */
public class HomeScreen {
	
	private static final String space = FrontendMain.space;
	
	public JFrame frame;
	
	public JLabel im;
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JLabel l4;
	
	public JButton b1;
	public JButton b2;
	public JButton b3;
	
	public HomeScreen(long ping) {
		
		frame = new JFrame("Scoutoliers - FIRST Power Up");
		
		im = new JLabel(FrontendMain.ws.logo);
		l1 = new JLabel("Scoutoliers 2018");
		l2 = new JLabel("FIRST Power Up");
		l3 = new JLabel("Please select your desired action.");
		l4 = new JLabel("Approximate Ping: " + ping);
		
		b1 = new JButton("PRE-SCOUTING");
		b2 = new JButton("MATCH SCOUTING");
		b3 = new JButton("VIEW RANKINGS");
		
		l1.setFont(new Font("", Font.BOLD, 48));
		l2.setFont(new Font("", Font.BOLD, 24));
		l3.setFont(new Font("", Font.ITALIC, 16));
		
		b1.setFont(new Font("", Font.PLAIN, 20));
		b2.setFont(new Font("", Font.PLAIN, 20));
		b3.setFont(new Font("", Font.PLAIN, 20));
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				// TODO: Go to Pre-Scouting screen
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				// TODO: Go to Match Scouting screen
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				// TODO: Go to team ranking screen
			}
		});
		
		frame.add(l1);
		frame.add(im);
		frame.add(l2);
		frame.add(l3);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(l4);
		
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(FrontendMain.ws.icon.getImage());
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 650);
		frame.setVisible(true);
		
	}
	
}
