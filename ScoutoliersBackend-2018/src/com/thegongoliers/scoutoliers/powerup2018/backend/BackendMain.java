package com.thegongoliers.scoutoliers.powerup2018.backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * @author Nicholas Bottone
 * @version 18.3.5
 */
public class BackendMain {
	
	public static final String VERSION = "ALPHA 18.3.5";
	
	public static ServerSocket server;
	public static ArrayList<Socket> clients;
	public static ArrayList<PrintWriter> outs;
	public static ArrayList<BufferedReader> ins;
	
	public static void main(String[] args) {
		
		System.out.println(">>> ScoutoliersBackend-2018 built for FIRST Power Up.");
		System.out.println(">>> Developed and designed by Nicholas Bottone of Team 5112.");
		System.out.println(">>> Special thanks to Greg Gongoleski, Greg Coffey, Joe Mazzone, and Kyle Corry.");
		System.out.println(">>> Version: " + VERSION);
		System.out.println("\n\n");
		
		System.out.println("[INFO] Booting up server backend.");
		
		try {
			
			server = new ServerSocket(5112);
			server.setSoTimeout(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[FATAL] Failed to setup server. Restarting...");
			main(args);
			return;
		}
		
		System.out.println("[INFO] Server backend operational.");
		System.out.println("[INFO] Configuring 100ms tick timer.");
		
		Timer timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				for (int i = 0; i < clients.size(); i++) {
					
					try {
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("[WARN] An error occurred while communicating with one of the clients. Ignoring them for a bit.");
					}
					
				}
				
			}
		});
		timer.start();
		
		System.out.println("[INFO] Tick timer started.");
		System.out.println("[INFO] Opening server to frontend client connections.");
		
		while (true) {
			
			try {
				
				while (true) {
					
					System.out.println("[INFO] Now ready for a client connection. Waiting...");
					Socket newClient = server.accept();
					
					System.out.println("[INFO] Found a client. Connecting...");
					newClient.setSoTimeout(2000);
					PrintWriter newOut = new PrintWriter(newClient.getOutputStream(), true);
					BufferedReader newIn = new BufferedReader(new InputStreamReader(newClient.getInputStream()));
					
					System.out.println("[INFO] Initialized communications with new client. Attempting contact...");
					newOut.println("Greetings.");
					String line = newIn.readLine();
					if (line.equals("SCOUTOLIERS-auth-18.3.5"))
						newOut.println("SCOUT");
					else {
						newOut.println("ERR");
						newOut.println("Invalid client software. Please try updating.");
						newClient.close();
						System.out.println("[WARN] Client was running outdated or unofficial software. Disconnected.");
					}
					
					System.out.println("[INFO] Authenticated client. Retrieving user sign-in data...");
					
					String user = newIn.readLine();
					String pass = newIn.readLine();
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("[WARN] Failed to communicate with the client. Abandoning the connection.");
			}
			
		}
		
	}
	
}
