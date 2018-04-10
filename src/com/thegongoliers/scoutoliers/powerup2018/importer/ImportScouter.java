package com.thegongoliers.scoutoliers.powerup2018.importer;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Nicholas Bottone
 */
public class ImportScouter {

	static HashMap<Integer, Double> overallScores = new HashMap<>(); // TeamNumber, OverallScore (S3)
	static HashMap<Integer, Double> autoScores = new HashMap<>(); // TeamNumber, AutoScore
	static HashMap<Integer, Double> teleopScores = new HashMap<>(); // TeamNumber, TeleopScore
	static HashMap<Integer, Double> endgameScores = new HashMap<>(); // TeamNumber, EndgameScore

	static HashMap<Integer, Double> autoBaselines = new HashMap<>();
	static HashMap<Integer, Double> autoSwitches = new HashMap<>();
	static HashMap<Integer, Double> autoScales = new HashMap<>();
	static HashMap<Integer, Double> teleopSwitches = new HashMap<>();
	static HashMap<Integer, Double> teleopScales = new HashMap<>();
	static HashMap<Integer, Double> teleopExchanges = new HashMap<>();
	static HashMap<Integer, Double> parks = new HashMap<>();
	static HashMap<Integer, Double> climbss = new HashMap<>();
	static HashMap<Integer, Double> foulss = new HashMap<>();

	// Sunday Data Only...

	static HashMap<Integer, Double> overallScores1 = new HashMap<>(); // TeamNumber, OverallScore (S3)
	static HashMap<Integer, Double> autoScores1 = new HashMap<>(); // TeamNumber, AutoScore
	static HashMap<Integer, Double> teleopScores1 = new HashMap<>(); // TeamNumber, TeleopScore
	static HashMap<Integer, Double> endgameScores1 = new HashMap<>(); // TeamNumber, EndgameScore

	static HashMap<Integer, Double> autoBaselines1 = new HashMap<>();
	static HashMap<Integer, Double> autoSwitches1 = new HashMap<>();
	static HashMap<Integer, Double> autoScales1 = new HashMap<>();
	static HashMap<Integer, Double> teleopSwitches1 = new HashMap<>();
	static HashMap<Integer, Double> teleopScales1 = new HashMap<>();
	static HashMap<Integer, Double> teleopExchanges1 = new HashMap<>();
	static HashMap<Integer, Double> parks1 = new HashMap<>();
	static HashMap<Integer, Double> climbss1 = new HashMap<>();
	static HashMap<Integer, Double> foulss1 = new HashMap<>();

	static ArrayList<Integer> teams = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("[Scoutoliers] WELCOME!");

		ArrayList<String> lines;
		ArrayList<String> list;

		System.out.println("[Scoutoliers] IMPORTING DATA!");

		try {
			lines = (ArrayList<String>) Files.lines(new File("RawData.csv").toPath()).collect(Collectors.toList());
			list = (ArrayList<String>) Files.lines(new File("Teams.txt").toPath()).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		lines.remove(0);

		for (String s : list) {
			teams.add(Integer.parseInt(s));
		}

		System.out.println("[Scoutoliers] IMPORT COMPLETED!");

		for (int team : teams) {

			System.out.println("[Scoutoliers] PROCESSING TEAM #" + team);

			int matchesTotal = 0;

			double autoBaseline = 0;
			double autoSwitch = 0;
			double autoScale = 0;
			double autoFactor = 0;

			double teleopSwitch = 0;
			double teleopScale = 0;
			double teleopExchange = 0;

			double parked = 0;
			double climbs = 0;

			double fouls = 0;

			double autoScore = 0;
			double teleopScore = 0;
			double endgameScore = 0;

			// Sunday data only...
			int matchesTotal1 = 0;

			double autoBaseline1 = 0;
			double autoSwitch1 = 0;
			double autoScale1 = 0;

			double teleopSwitch1 = 0;
			double teleopScale1 = 0;
			double teleopExchange1 = 0;

			double parked1 = 0;
			double climbs1 = 0;

			double fouls1 = 0;

			double autoScore1 = 0;
			double teleopScore1 = 0;
			double endgameScore1 = 0;

			for (String s : lines) {
				try {
					String[] split = s.split(",");
					int i = Integer.parseInt(removeQuotes(split[3]));
					if (team == i) {
						matchesTotal++;
						if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							matchesTotal1++;

						if (removeQuotes(split[4]).equals("SAME"))
							autoFactor = 1;
						else if (removeQuotes(split[4]).equals("OPPOSITE"))
							autoFactor = 3;
						else
							autoFactor = 2;

						if (removeQuotes(split[5]).equals("YES")) {
							autoBaseline++;
							autoScore += 3;
							if (removeQuotes(split[0]).contains("2018/03/25")) {// Sunday Only
								autoBaseline1++;
								autoScore1 += 3;
							}
						}

						int a = Integer.parseInt(removeQuotes(split[6]));
						autoSwitch += a;
						if (removeQuotes(split[0]).contains("2018/03/25"))
							autoSwitch1 += a;// Sunday Only
						if (a < 1)
							;
						else if (autoFactor == 1) {
							autoScore += 7 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							{
								autoScore1 += 7 * a;
							}
						} else if (autoFactor == 2) {
							autoScore += 10 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							{
								autoScore1 += 10 * a;
							}
						} else if (autoFactor == 3) {
							autoScore += 15 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							{
								autoScore1 += 15 * a;
							}
						}

						a = Integer.parseInt(removeQuotes(split[7]));
						autoScale += a;
						if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							autoScale1 += a;
						if (a < 1)
							;
						else if (autoFactor == 1) {
							autoScore += 15 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								autoScore1 += a * 15;
						} else if (autoFactor == 2 || autoFactor == 3) {
							autoScore += 25 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								autoScore1 += 25 * a;
						}
						a = Integer.parseInt(removeQuotes(split[8]));
						teleopSwitch += a;
						if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							teleopSwitch1 += a;
						if (a > 0) {
							teleopScore += 4 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								teleopScore1 += 4 * a;
						}

						a = Integer.parseInt(removeQuotes(split[9]));
						teleopScale += a;
						if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							teleopScale1 += a;
						if (a > 0) {
							teleopScore += 8 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								teleopScore1 += 8 * a;
						}
						a = Integer.parseInt(removeQuotes(split[10]));
						teleopExchange += a;
						if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							teleopExchange1 += a;
						if (a > 0) {
							teleopScore += 2 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								teleopScore1 += 2 * a;
						}
						a = Integer.parseInt(removeQuotes(split[11]));
						climbs += a;
						if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							climbs1 += a;
						if (a > 0) {
							endgameScore += 25 * a;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								endgameScore1 += 25 * a;
						}

						if (removeQuotes(split[12]).equals("YES")) {
							parked++;
							endgameScore += 3;
							if (removeQuotes(split[0]).contains("2018/03/25")) {// Sunday Only
								parked1++;
								endgameScore1 += 3;
							}
						}

						if (removeQuotes(split[13]).equals("RED")) {
							fouls += 50;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								fouls1 += 50;
						} else if (removeQuotes(split[13]).equals("YELLOW")) {
							fouls += 25;
							if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
								fouls1 += 25;
						}

						a = Integer.parseInt(removeQuotes(split[14]));
						fouls += a;
						if (removeQuotes(split[0]).contains("2018/03/25")) // Sunday Only
							fouls1 += a;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			autoBaseline /= matchesTotal;
			autoSwitch /= matchesTotal;
			autoScale /= matchesTotal;

			teleopSwitch /= matchesTotal;
			teleopScale /= matchesTotal;
			teleopExchange /= matchesTotal;

			parked /= matchesTotal;
			climbs /= matchesTotal;

			fouls /= matchesTotal;

			autoScore /= matchesTotal;
			teleopScore /= matchesTotal;
			endgameScore /= matchesTotal;

			//Sunday only...
			autoBaseline1 /= matchesTotal1;
			autoSwitch1 /= matchesTotal1;
			autoScale1 /= matchesTotal1;

			teleopSwitch1 /= matchesTotal1;
			teleopScale1 /= matchesTotal1;
			teleopExchange1 /= matchesTotal1;

			parked1 /= matchesTotal1;
			climbs1 /= matchesTotal1;

			fouls1 /= matchesTotal1;

			autoScore1 /= matchesTotal1;
			teleopScore1 /= matchesTotal1;
			endgameScore1 /= matchesTotal1;
			
			double overallScore = autoScore + teleopScore + endgameScore;
			double overallScore1 = autoScore1 + teleopScore1 + endgameScore1;

			overallScores.put(team, overallScore);
			autoScores.put(team, autoScore);
			teleopScores.put(team, teleopScore);
			endgameScores.put(team, endgameScore);
			autoBaselines.put(team, autoBaseline * 100);
			autoSwitches.put(team, autoSwitch);
			autoScales.put(team, autoScale);
			teleopSwitches.put(team, teleopSwitch);
			teleopScales.put(team, teleopScale);
			teleopExchanges.put(team, teleopExchange);
			parks.put(team, parked * 100);
			climbss.put(team, climbs);
			foulss.put(team, fouls);

			overallScores1.put(team, overallScore1);
			autoScores1.put(team, autoScore1);
			teleopScores1.put(team, teleopScore1);
			endgameScores1.put(team, endgameScore1);
			autoBaselines1.put(team, autoBaseline1 * 100);
			autoSwitches1.put(team, autoSwitch1);
			autoScales1.put(team, autoScale1);
			teleopSwitches1.put(team, teleopSwitch1);
			teleopScales1.put(team, teleopScale1);
			teleopExchanges1.put(team, teleopExchange1);
			parks1.put(team, parked1 * 100);
			climbss1.put(team, climbs1);
			foulss1.put(team, fouls1);
			
		}

		System.out.println("[Scoutoliers] STARTING PRIMARY EXPORT SAVEFILE!");

		PrintWriter save = null;
		try {
			save = new PrintWriter("ScoutoliersOutput.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Column Headers
		// Note: Rankings and team names will be manually entered and will not be filled
		// in by this program.
		save.println(
				"Team Number,Overall Rank,Auto Rank,Teleop Rank,Endgame Rank,,Overall Score,Auto Score,Teleop Score,Endgame Score,"
						+ "Baseline %,Switch Auto,Scale Auto,Switch Teleop,Scale Teleop,Exchange,Parked %,Climbs,"
						+ "Foul Pts");

		for (int team : teams) {

			save.println(team + ",,,,,," + overallScores.get(team) + "," + autoScores.get(team) + ","
					+ teleopScores.get(team) + "," + endgameScores.get(team) + "," + autoBaselines.get(team) + ","
					+ autoSwitches.get(team) + "," + autoScales.get(team) + "," + teleopSwitches.get(team) + ","
					+ teleopScales.get(team) + "," + teleopExchanges.get(team) + "," + parks.get(team) + ","
					+ climbss.get(team) + "," + foulss.get(team));

		}

		save.close();
		System.out.println("[Scoutoliers] PRIMARY EXPORT COMPLETED!");
		
		System.out.println("[Scoutoliers] STARTING SECONDARY EXPORT...");

		// SECONDARY EXPORT - SUNDAY ONLY
		save = null;
		try {
			save = new PrintWriter("ScoutoliersSundayOnly.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Column Headers
		// Note: Rankings and team names will be manually entered and will not be filled
		// in by this program.
		save.println(
				"Team Number,Overall Rank,Auto Rank,Teleop Rank,Endgame Rank,,Overall Score,Auto Score,Teleop Score,Endgame Score,"
						+ "Baseline %,Switch Auto,Scale Auto,Switch Teleop,Scale Teleop,Exchange,Parked %,Climbs,"
						+ "Foul Pts");
		
		for (int team : teams) {

			save.println(team + ",,,,,," + overallScores1.get(team) + "," + autoScores1.get(team) + ","
					+ teleopScores1.get(team) + "," + endgameScores1.get(team) + "," + autoBaselines1.get(team) + ","
					+ autoSwitches1.get(team) + "," + autoScales1.get(team) + "," + teleopSwitches1.get(team) + ","
					+ teleopScales1.get(team) + "," + teleopExchanges1.get(team) + "," + parks1.get(team) + ","
					+ climbss1.get(team) + "," + foulss1.get(team));

		}

		save.close();
		System.out.println("[Scoutoliers] SECONDARY EXPORT COMPLETED!");

	}

	public static String removeQuotes(String string) {
		return string.substring(1, string.length() - 1);
	}

}
