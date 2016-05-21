//File name: ConnectionHandler.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: Handles establishing the connection and sending the events to the server to be
//                  emailed to administration. When the connection is established, the events are
//                  loaded into the feed fragment to be shown in the event feed. This class also
//                  will load events from a stored file if the connection cannot be established.
//                  When the connection is established, it writes the new, most current data to
//                  the file.
//Last Edited: 05/08/2016

package com.example.bmathis.interactivemap;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ConnectionHandler extends Thread{

    Socket s;
    BufferedReader br, filereader;
    PrintWriter pw, filewriter;
    String temp;
    String[] tempItems;
    FeedFragment f;
    MapsActivity m;
    String command;
    boolean connectionOpen;


    ConnectionHandler(FeedFragment f, MapsActivity m){this.f = f;this.m = m;}

    public void run()
    {
        f.buildFeedStructures();
        //loadEventsFromFile();

        try {
            Log.d("debug", "Attempting to connect...");
            s = new Socket("", 0); // home server kept a secret
            Log.d("debug", "Connection Successful");
            connectionOpen = true;

            command = "";
            pw = new PrintWriter(s.getOutputStream(), true); // get an object to write to the server
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            try { // cache the events in case a connection cannot be established later
                filewriter = new PrintWriter(new FileOutputStream(new File(m.getFilesDir() + "datacache.txt")));
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("debug", "Error creating output file.");
            }

            while (!br.ready()) ; // wait until connection is ready

            temp = br.readLine();
            filewriter.println(temp); // cache line for later

            addPresentationItems(); // hard-coded events for presentation purposes

            while (!temp.startsWith("==ENDOFEVENTDATA==")) // signifies end of event data transmission
            {

                tempItems = temp.split(">>>");
                f.addFeedItem(tempItems[2], tempItems[6], tempItems[0], tempItems[5], tempItems[3], tempItems[4]);
                // add parsed line to feed data structures
                filewriter.println(temp);
                // write line to file for event cache
                temp = br.readLine();
            }

            Log.d("debug", "thread finishes grabbing events");

            while (connectionOpen) // we'll always be ready to communicate with the server if needed
            {
                if(command.startsWith("001EVENTEMAIL")) // another class may flag for a command to be sent
                                                        // via a method in this class. This signifies an email cmd
                {
                    Log.d("debug", "command being sent");
                    pw.println(command);
                    command = ""; // clear command
                }
            }

            s.close();

        }catch(Exception ioe)
        {
            Log.d("debug", "exception " + ioe);
            Log.d("debug", "Error connecting to server. Using cached events");
            loadEventsFromFile(); // load cached events from file. If no file, then just empty events
        }
    }

    public void setCommand(String cmd) // method for other classes to use in case an email needs sent
    {
        Log.d("debug", "Command Syntax: " + cmd);
        command = cmd;
    }

    private void loadEventsFromFile() // grabs the cached events from the file in case of connection failure
    {
        DataInputStream dis;

        Log.d("debug", "Attempting to grab events from file...");
        try{

            filereader = new BufferedReader(new FileReader(m.getFilesDir() + "datacache.txt"));

            while((temp = filereader.readLine()) != null)
            {
                tempItems = temp.split(">>>");
                Log.d("debug", temp);
                f.addFeedItem(tempItems[2], tempItems[6], tempItems[0], tempItems[5], tempItems[3], tempItems[4]);

                temp = filereader.readLine();
            }

            Log.d("debug", "File read complete");
        }

        catch(Exception e)
        {
            e.printStackTrace();
            Log.d("debug", "Cache file does not exist");
        }
    }


    // the events for the final presentation are pretty much only registrar events referring
    // to the final's schedule. We'd like to show some functionality with the event locations and
    // filtering, so we added a couple hard-coded events to demonstrate.
    private void addPresentationItems(){
        f.addFeedItem("Hamlet Screening",
                      "The School of Fine Arts will be hosting a screening of " +
                      "Hamlet. Admission is free, concessions will be sold. Do" +
                      "nations are greatly appreciated.",
                      "School of Fine Arts",
                      "Wallman Hall",
                      "Mon, 05/09/2016 - 7:00pm",
                      "Mon, 05/09/2016 - 9:00pm");

        f.addFeedItem("Baseball vs Shepherd",
                      "Fairmont State vs Shepherd (HOME)",
                      "Athletics",
                      "Bridgeport, WV",
                      "Mon, 05/09/2016 - 1:00pm",
                      "Mon, 05/09/2016 - 1:00pm");
    }
}
