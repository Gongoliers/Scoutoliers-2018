package com.thegongoliers.scoutoliers.powerup2018.frontend;

import java.awt.Color;
import java.awt.Font;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Nicholas Bottone
 * @since 18.3.5
 */
public class WelcomeScreen {
	
	public JFrame frame;
	
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JLabel l4;
	
	public JButton b1;
	public JButton b2;
	
	public void show() {
		
		frame = new JFrame("Welcome to Scoutoliers!");
		
		l1 = new JLabel("Welcome to Scoutoliers!");
		l2 = new JLabel("Presented by The Gongoliers Team 5112");
		l3 = new JLabel("Developed by Nicholas Bottone");
		l4 = new JLabel("Version " + FrontendMain.VERSION);
		
		b2 = new JButton("Sign in");
		
		l1.setFont(new Font("", Font.BOLD, 36));
		l2.setFont(new Font("", Font.BOLD, 22));
		l3.setFont(new Font("", Font.ITALIC, 18));
		l4.setFont(new Font("", Font.PLAIN, 16));
		
		b2.setFont(new Font("", Font.PLAIN, 20));
		
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		
		if (FrontendMain.saveData != null) {
			b1 = new JButton("Auto-Login as " + FrontendMain.saveData.get(0));
			b1.setFont(new Font("", Font.PLAIN, 20));
			frame.add(b1);
		}
		frame.add(b2);
		
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setIconImage(image); TODO
		frame.setSize(400, 400);
		frame.setVisible(true);
		
	}
	
	public static void autoLogin() {
		
		String user = FrontendMain.saveData.get(0);
		String pass = FrontendMain.saveData.get(1);
		
		
	}
	
	public static void signIn() {
		
		
		
	}
	
	public static void connectInit(String user, String pass) {
		
		try {
			FrontendMain.server = new Socket("IP", 5112);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
