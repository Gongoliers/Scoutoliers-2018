package com.thegongoliers.scoutoliers.powerup2018.frontend;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Nicholas Bottone
 * @since 18.3.5
 */
public class WelcomeScreen {
	
	private static final String IP_ADDRESS = "localhost"; // TODO: Replace with the IP Address of your server
	private static final String space = FrontendMain.space;
	
	public JFrame frame;
	
	public ImageIcon logo;
	public ImageIcon icon;
	
	public JLabel im;
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JLabel l4;
	
	public JButton b1;
	public JButton b2;
	
	public WelcomeScreen() {
		
		frame = new JFrame("Welcome to Scoutoliers!");
		
		logo = new ImageIcon(getClass().getResource("scoutoliers-logo.png"));
		icon = new ImageIcon(getClass().getResource("scoutoliers-icon.png"));
		
		im = new JLabel(logo);
		l1 = new JLabel("Welcome to Scoutoliers!");
		l2 = new JLabel("Presented by The Gongoliers Team 5112");
		l3 = new JLabel("Developed by Nicholas Bottone");
		l4 = new JLabel("Version " + FrontendMain.VERSION);
		
		b2 = new JButton("Sign in");
		
		l1.setFont(new Font("", Font.BOLD, 48));
		l2.setFont(new Font("", Font.BOLD, 22));
		l3.setFont(new Font("", Font.ITALIC, 18));
		l4.setFont(new Font("", Font.PLAIN, 16));
		
		b2.setFont(new Font("", Font.PLAIN, 20));
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				signIn();
			}
		});
		
		frame.add(l1);
		frame.add(im);
		frame.add(l2);
		frame.add(new JLabel(space));
		frame.add(l3);
		frame.add(new JLabel(space));
		frame.add(l4);
		frame.add(new JLabel(space));
		
		if (FrontendMain.saveData != null) {
			b1 = new JButton("Auto-Login as " + FrontendMain.saveData.get(0));
			b1.setFont(new Font("", Font.PLAIN, 20));
			b1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					frame.dispose();
					autoLogin();
				}
			});
			frame.add(b1);
		}
		frame.add(b2);
		
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(icon.getImage());
		frame.setLayout(new FlowLayout());
		frame.setSize(625, 470);
		frame.setVisible(true);
		
	}
	
	public void autoLogin() {
		
		String user = FrontendMain.saveData.get(0);
		String pass = FrontendMain.saveData.get(1);
		connectInit(user, pass);
		
	}
	
	public void signIn() {
		
		frame = new JFrame("Sign In");
		
		JLabel label = new JLabel("Sign In");
		JLabel instr = new JLabel("Contact admin for help.");
		
		JTextField user = new JTextField(16);
		JPasswordField pass = new JPasswordField(16);
		
		JButton button = new JButton("Sign In");
		
		label.setFont(new Font("", Font.BOLD, 52));
		instr.setFont(new Font("", Font.PLAIN, 16));
		
		user.setFont(new Font("", Font.PLAIN, 16));
		pass.setFont(new Font("", Font.PLAIN, 16));
		
		user.setText("Username");
		pass.setText("Password");
		
		button.setFont(new Font("", Font.PLAIN, 20));
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String u = user.getText();
				String p = new String(pass.getPassword());
				frame.dispose();
				
				connectInit(u, p);
			}
		});
		
		frame.add(label);
		frame.add(instr);
		frame.add(user);
		frame.add(pass);
		frame.add(button);
		
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(icon.getImage());
		frame.setLayout(new FlowLayout());
		frame.setSize(250, 250);
		frame.setVisible(true);
		
	}
	
	public void connectInit(String user, String pass) {
		
		try {
			
			FrontendMain.server = new Socket(IP_ADDRESS, 5112);
			FrontendMain.in = new BufferedReader(new InputStreamReader(FrontendMain.server.getInputStream()));
			FrontendMain.out = new PrintWriter(FrontendMain.server.getOutputStream(), true);
			FrontendMain.server.setSoTimeout(5000);
			
		} catch (Exception e) {
			e.printStackTrace();
			FrontendMain.displayError("Could not contact the server. Check your connection. The server may be offline.", true);
			return;
		}
		
		long time = 50;
		
		try {
			
			String line = FrontendMain.in.readLine();
			if (!line.equals("Greetings.")) {
				FrontendMain.displayError("Authentication error. Try updating your client software.", true);
				return;
			}
			
			time = System.currentTimeMillis();
			FrontendMain.out.println("SCOUTOLIERS-auth-applesauce");
			
			line = FrontendMain.in.readLine();
			if (!line.equals("SCOUT")) {
				FrontendMain.displayError("Authentication error. Try updating your client software.", true);
				return;
			}
			
			time = System.currentTimeMillis() - time;
			FrontendMain.out.println(user);
			FrontendMain.out.println(pass);
			
			line = FrontendMain.in.readLine();
			if (line.equals("ERR")) {
				signIn();
				FrontendMain.displayError(FrontendMain.in.readLine(), false);
				return;
			}
			FrontendMain.out.println("GRACIAS");
			
		} catch (Exception e) {
			e.printStackTrace();
			FrontendMain.displayError("Trouble communicating with the server. Check your connection.", true);
			return;
		}
		
		try {
			PrintWriter save = new PrintWriter("scoutoliers-autologin");
			save.println(user);
			save.println(pass);
			save.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to save auto-login file.");
		}
		
		FrontendMain.initLaunchHome(time);
		
	}
	
}
