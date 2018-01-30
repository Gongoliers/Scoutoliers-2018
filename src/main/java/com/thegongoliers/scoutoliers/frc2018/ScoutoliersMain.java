package com.thegongoliers.scoutoliers.frc2018;

import static spark.Spark.*;

/**
 * @author Nicholas Bottone
 * @since 1.0-SNAPSHOT (1/30/2018)
 */
public class ScoutoliersMain {

    public static void main(String[] args) {

        get("/hello", (req, res) -> "Hello World");

    }

}