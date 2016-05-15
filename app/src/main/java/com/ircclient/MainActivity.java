package com.ircclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Server> listOfServers = new ArrayList<Server>(){{
        // Add default servers to the list
        // TODO add ports later
        add(new Server("uni-erlangen.de",               "IRCnet"));     // IRCnet
        add(new Server("euroserv.fr.quakenet.org",      "QuakeNet"));   // QuakeNet
        add(new Server("tirc.servercentral.net",        "EFnet"));      // EFnet
        add(new Server("irc.infoqb.se",                 "Rizon"));      // Rizon
        add(new Server("amsterdam.nl.eu.undernet.org",  "Undernet"));   // Undernet
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateList();

    }

    private void populateList() {   // Populate ListView
        // TODO created new serverAdapter &  add server select
        // Build serverAdapter
        ServerAdapter serverAdapter = new ServerAdapter (this,listOfServers);

        // Configure list view
        ListView list = (ListView) findViewById(R.id.textView_serverSelect);
        try{
            list.setAdapter(serverAdapter);
        }catch(NullPointerException e) {

        }


    }

}
