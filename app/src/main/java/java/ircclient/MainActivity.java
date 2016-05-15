package java.ircclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        registerClicks();
    }

    private void populateList() {   // Populate ListView
        // Create item list
        // TODO created new adapter &  add server select
        Integer n = listOfServers.size();
        String[] items = new  String[n + 1];
        items[0] = "Add new Server";
        for(int i = 0; i < listOfServers.size(); i++){
            items[i + 1] = listOfServers.get(i).getServerName();
        }

        // Build adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.serverlist,    // Layout to use
                items);                 // Items to display

        // Configure list view
        ListView list = (ListView) findViewById(R.id.textView_serverSelect);
        try{
            list.setAdapter(adapter);
        }catch (NullPointerException ex) {
            System.out.print(ex);
        }

    }

    private void registerClicks() {         // Register click + connect to selected server
                                            // or transition to Add a new Server activity

        // TODO add connection to server and transitioning + Success/Fail msg
        ListView list = (ListView) findViewById(R.id.textView_serverSelect);
        try{
            list.setOnClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView textView = (TextView) viewClicked;
                    String msg = "Connecting to Server: " + textView.getText().toString();
                    Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT);
                }
            });
        }catch(NullPointerException ex){
            System.out.print(ex);
        }
    }
}
