package com.thegongoliers.scoutoliers.powerup2018.backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.swing.Timer;

/**
 * @author Nicholas Bottone
 * @version 18.3.5
 */
public class BackendMain {
	
	public static final String VERSION = "ALPHA 18.3.6";
	
	public static ServerSocket server;
	public static ArrayList<Socket> clients = new ArrayList<>();
	public static ArrayList<PrintWriter> outs = new ArrayList<>();
	public static ArrayList<BufferedReader> ins = new ArrayList<>();
	public static ArrayList<String> activeUsers = new ArrayList<>();
	
	public static void main(String[] args) {
		
		System.out.println(">>> ScoutoliersBackend-2018 built for FIRST Power Up.");
		System.out.println(">>> Developed and designed by Nicholas Bottone of Team 5112.");
		System.out.println(">>> Special thanks to Greg Gongoleski, Greg Coffey, Joe Mazzone, and Kyle Corry.");
		System.out.println(">>> Version: " + VERSION);
		System.out.println("\n\n");
		
		System.out.println("[INFO] Booting up server backend.");
		
		try {
			
			server = new ServerSocket(5112);
			
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
					if (line.equals("SCOUTOLIERS-auth-applesauce"))
						newOut.println("SCOUT");
					else {
						newOut.println("ERR");
						newOut.println("Invalid client software. Please try updating.");
						newClient.close();
						System.out.println("[WARN] Client was running outdated or unofficial software. Disconnected.");
						break;
					}
					
					System.out.println("[INFO] Authenticated client software. Retrieving user sign-in data...");
					
					String user = newIn.readLine().toLowerCase();
					String pass = newIn.readLine();
					
					String lookup = loadLogins().get(user);
					if (lookup == null) {
						newOut.println("ERR");
						newOut.println("Incorrect username.");
						newClient.close();
						System.out.println("[WARN] Incorrect username given not in database. Disconnected.");
						break;
					}
					if (!lookup.equals(pass)) {
						newOut.println("ERR");
						newOut.println("Incorrect password.");
						newClient.close();
						System.out.println("[WARN] Correct username, but incorrect password. Disconnected.");
						break;
					}
					
					clients.add(newClient);
					ins.add(newIn);
					outs.add(newOut);
					activeUsers.add(user);
					
					System.out.println("[INFO] Client successfully signed in as " + user + ".");
					newOut.println("AUTH-COMPLETE");
					
					long time = System.currentTimeMillis();
					newIn.readLine();
					time = System.currentTimeMillis() - time;
					
					System.out.println("[INFO] " + user + " is connected with " + time + " ms ping.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("[WARN] Failed to communicate with the client. Abandoning the connection.");
			}
			
		}
		
	}
	
	public static void saveLogins(HashMap<String, String> logins) {
		
		try {
			
			PrintWriter save = new PrintWriter("login-database.csv");
			
			for (String key : logins.keySet()) {
				save.println(key + "," + logins.get(key));
			}
			
			save.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[WARN] Encountered an error while attempting to save the logins.");
		}
		
	}
	
	public static HashMap<String, String> loadLogins() {
		
		try {
			
			ArrayList<String> lines = (ArrayList<String>) Files.lines(Paths.get("login-database.csv")).collect(Collectors.toList());
			HashMap<String, String> logins = new HashMap<>();
			
			for (String line : lines) {
				String[] login = line.split(",");
				logins.put(login[0], login[1]);
			}
			
			return logins;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[WARN] Encountered an error while attempting to load the logins.");
			return new HashMap<>();
		}
		
	}
	
}
