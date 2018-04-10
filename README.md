# Scoutoliers: FIRST Power Up Edition
![A gondola with a telescope](scoutoliers-logo.png?raw=true "Scoutoliers Logo")

This is a scouting service designed for FIRST Power Up 2018.
We are The Gongoliers, FRC Team 5112.  We are based in North Scituate, Rhode Island at Ponaganset High School.
Developed by Lead Programmer Nicholas Bottone, with special thanks to mentors Greg Gongoleski, Greg Coffey, Joseph Mazzone, and Kyle Corry.

## What is the FIRST Robotics Competition? 🤖
The FIRST® Robotics Competition (or FRC) is an event where high school-aged teams compete head to head on a special playing field with robots they have designed, built, and programmed.  For more information about FIRST and FRC, please visit www.firstinspires.org.

## What is the Scoutoliers service? 💻
The Scoutoliers service allows dedicated competition scouters to observe and efficiently record data.  Scouters may use any internet-connected device (phones, tablets, laptops, etc) to input and upload their data.  The Scoutoliers service allows scouters to  watch matches and record the performance of each robot on the field to understand each team's real-world abilities and usefulness.  All this data will be processed and turned into ranked statistics which can be quickly read and understood.  This data can be used to inform the driveteam about their opponents' and teammates' abilities before a match, it can be used to gauge and rank robot performance, and it can be used to select the best teams based on point-scoring ability for your playoff alliance.  This information is especially important when drafting alliances for the playoffs, as you can see which teams would benefit your alliance the most.  The Scoutoliers service is a Java application that imports data collected using [Google Forms](https://www.google.com/forms/about/), then processes the data and exports it as a CSV file.

## How does the service work?
Drop the JAR file that I have provided in the releases section into the same directory as a .CSV export of your Google Form's data and a .TXT file containing a list of every team number competing in the competition.  The .CSV file can be easily downloaded on the Google Forms website by pressing the ellipsis button in the "Responses" section, then pressing "Download responses (.csv)". The .TXT file of team numbers must be filled out manually with one team number on each line.  Double click the JAR executable to generate a report, which will be automatically be exported to a CSV file (which can be opened with any simple spreadsheet editor).  You may notice that one CSV contains all data while another contains "SundayOnly".  For this feature to be useful, you must edit the code to adjust the ideal date of the final day of your competition, but is completely optional.

## How does the Google Form work?
We have two separate Google Forms that we use - one for Pit Scouting and another for Match Scouting.  The use of our program requires that you create an exact question-for-question copy of our Google Form(s), or else the program will not import data properly.  You may edit this program for your own needs as you wish, as this is licensed under the MIT License.  Below you can see two screen-shots of our forms...
![Scoutoliers Pit Scouting Form Screenshot](PitScoutingScreenshot.png?raw=true "Pit Scouting") ![Scoutoliers Match Scouting Form Screenshot](MatchScoutingScreenshot.png?raw=true "Match Scouting")

## Can my team use it? 🤝
Sure!  If you understand the code, you are free to adapt it to your team's needs.  This code is licensed under the MIT License, so you must provide attribution to Nicholas Bottone and The Gongoliers when using any piece of it in your work.  In the future, we plan on making it easier for other teams to use our scouting solutions.  Right now, using our service would require creating a copy of our Google Forms to use for your team.  If you'd like any help with this process, I'd be delighted to help you, just contact Nicholas Bottone on GitHub.

## What is the current state of the app? ⭐
The Scoutoliers app was originally created in 2017 for the game FIRST Steamworks.  At that time, it was a simple Android app that communicated with Backendless servers (www.backendless.com).  You can view the discontinued Android source code at https://www.turbotech.us/frc5112/src/.  We have since completely scrapped that approach due to the limitations of Backendless.  The scouting service was completely rebuilt from the ground up to be completely cross-platform and to use the free Google Cloud.

## Features 🌟
- **Easy to use** Google Forms allows scouters to quickly start collecting useful information without spending too much time practicing or preparing ahead of time.
  - Google Forms work on **any internet-connected device**, making the service available to all types of teams, regardless of the device you use.
- **Field-Scouting** allows the client to set stats and real-world statistical data of each robot's performance during matches.  All 12 matches for each robot will be recorded and uploaded to the server.
  - Integrates with **The Blue Alliance** servers to gather match scores and stats without requiring that the scouters type some of the info manually.
- **Statistical Analysis** allows the server to quickly analyze all the robot's recorded information and use it to generate a score that can be used to quickly rank and compare each robot's point-scoring ability.
  - **Graphs and Charts** will allow users to visually see and understand how each robot improved and changed throughout the competition.
