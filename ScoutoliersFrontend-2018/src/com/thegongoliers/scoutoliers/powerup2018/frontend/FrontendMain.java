package com.thegongoliers.scoutoliers.powerup2018.frontend;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Nicholas Bottone
 * @version 18.3.5
 */
public class FrontendMain {
	
	public static final String VERSION = "ALPHA 18.3.5";
	public static ArrayList<String> saveData;
	
	public static Socket server;
	public static PrintWriter out;
	public static BufferedReader in;
	
	public static JFrame frame;
	
	public static JLabel l1;
	public static JLabel l2;
	public static JLabel l3;
	public static JLabel l4;
	public static JLabel l5;
	public static JLabel l6;
	public static JLabel l7;
	public static JLabel l8;
	public static JLabel l9;
	
	public static JButton b1;
	public static JButton b2;
	public static JButton b3;
	public static JButton b4;
	public static JButton b5;
	public static JButton b6;
	public static JButton b7;
	public static JButton b8;
	public static JButton b9;
	
	public static void main(String[] args) {
		
		try {
			saveData = (ArrayList<String>) Files.lines(Paths.get("list.txt")).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new WelcomeScreen().show();
		
	}
	
	public static void displayError(String message) {
		
		JFrame frame = new JFrame();
		JLabel error = new JLabel("Error! ");
		JLabel label = new JLabel(message);
		
		error.setFont(new Font("", Font.BOLD, 32));
		label.setFont(new Font("", Font.PLAIN, 18));
		
		frame.add(error);
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.RED);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}
	
}
