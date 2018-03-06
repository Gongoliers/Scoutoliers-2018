# Scoutoliers-2018
This is a scouting service designed for FIRST Power Up 2018.
We are The Gongoliers, FRC Team 5112.  We are based in North Scituate, Rhode Island at Ponaganset High School.
Developed by Nicholas Bottone, with special thanks to Greg Gongoleski, Greg Coffey, Joseph Mazzone, and Kyle Corry.

## What is the FIRST Robotics Competition?
The FIRST® Robotics Competition (or FRC) is an event where high school-aged teams compete head to head on a special playing field with robots they have designed, built, and programmed.  For more information about FIRST and FRC, please visit www.firstinspires.org.

## What is the Scoutoliers app?
The Scoutoliers app allows dedicated competition scouters to observe and efficiently record data.  Scouters may use Windows-powered laptops and tablets to input and upload their data.  In the future, we hope to support more platforms.  The Scoutoliers app allows scouters to go through the pits and ask other teams questions about their robots to create a database full of useful information.  During the matches, scouters will also watch matches and record the performance of each robot on the field to understand each team's real-world abilities and usefulness.  All this data will be processed and turned into ranked statistics which can be quickly read and understood.  This data can be used to inform the driveteam about their opponents' and teammates' abilities before a match, it can be used to gauge and rank robot performance, and it can be used to select the best teams based on point-scoring ability.  This information is especially important when drafting alliances for the playoffs, as you can see which teams would benefit your alliance the most.  The Scoutoliers app is a Java application that has been tested on Windows, though it could hypothetically be easily ported to another desktop operating system (macOS/Linux).

## What is the backend server?
The Java-powered backend server allows a frontend client to connect to a mainframe computer, save collected scouting data from FRC matches, and calculate scores and rankings for the local competition.  The backend server is run at a remote location and constantly checks for connections by clients.  The data is stored and calculated on the backend server.  There is only one backend server per scouting system.

## What is the frontend client?
The Java-powered frontend client allows a dedicated scouter to use a Windows-powered device to input information about other robots' performance and capabilities.  The frontend client will then take this information and transmit it to the backend server at a remote location.  The backend will store the info for all teams, perform calculations, and then report the rankings and final data back to the client at the event.  There are normally several clients working at one time, each transmitting data back and forth to and from the server.  Administrative permissions are not required to install or use the client, however an active internet connection is required.

## Can my team use it?
Sure!  If you understand the code, you are free to adapt it to your team's needs.  This code is licensed under the MIT License, so you must provide attribution to Nicholas Bottone and The Gongoliers when using any piece of it in your work.  In the future, we plan on creating a shared backend server so other teams can use The Scoutoliers App without typing a single line of code!  We'll keep you updated on the status of this.

## What is the current state of the app?
The Scoutoliers app was originally created in 2017 for the game FIRST Steamworks.  At that time, it was a simple Android app that communicated with Backendless servers (www.backendless.com).  You can view the discontinued Android source code at https://www.turbotech.us/frc5112/src/.  We have since completely scrapped that approach due to the limitations of Backendless.  We are currently in the process of rebuilding the entire app from the ground up.  **The app and its server are currently incomplete.**  The app and server in its current state will likely not work properly.  **This is a work in progress and is incomplete.**

## Short Term To-Do List ❤
- **Pre-Scouting** allows the client to set descriptions for each team on the first day of the competition.  Specific abilities of the robot, quantitative speeds and accuracies estimated by the teams, and other info will be collected.
  - **Take a picture** of the robot and upload it to the server.
- **Field-Scouting** allows the client to set stats and real-world statistical data of each robot's performance during matches.  All 12 matches for each robot will be recorded and uploaded to the server.
  - Integrates with **The Blue Alliance** servers to gather match scores and stats without requiring that the scouters type some of the info manually.
- **Statistical Analysis** allows the server to quickly analyze all the robot's recorded information and use it to generate a score that can be used to quickly rank and compare each robot's point-scoring ability.
  - **Graphs and Charts** will allow users to visually see and understand how each robot improved and changed throughout the competition.

## Long Term Dream List 💖
- **Complimentary Shared Hosting** will allow other teams to use our scouting services without having to write a single line of code to adapt it to their needs.
  - **No backend server needed** in order to use the app, you can share our server!
- **Platform-independent** allows you to use any operating system, whether on a laptop, tablet, or mobile phone.  No app installation required.
  - **Online app** transmits data through your web browser instead of a dedicated app, saving space on your device.
- More? 
