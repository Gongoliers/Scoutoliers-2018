package com.thegongoliers.scoutoliers.frc2018;

import static spark.Spark.*;

/**
 * This is the backend server to a scouting web app made for FIRST Power Up
 * 2018. We are The Gongoliers, FRC Team 5112. We are based in North Scituate,
 * Rhode Island at Ponaganset High School. Developed by Nicholas Bottone, with
 * special thanks to Joseph Mazzone and Kyle Corry.
 * 
 * Visit our GitHub Repository:
 * https://github.com/Gongoliers/ScoutoliersBackend-2018
 * 
 * @author Nicholas Bottone
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT (01/30/2018)
 */
public class ScoutoliersMain {

	public static void main(String[] args) {

		/*
		 * Hosts an HTML page with the text "Hello World" at the address
		 * http://localhost:4567/hello
		 */
		get("/hello", (req, res) -> "Hello World");

	}

}
