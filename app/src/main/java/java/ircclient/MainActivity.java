package java.ircclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    }

    private void populateList() {   // Populate ListView
        // TODO created new adapter &  add server select
        // Build adapter
        Adapter adapter = new Adapter(this,listOfServers);

        // Configure list view
        ListView list = (ListView) findViewById(R.id.textView_serverSelect);
        list.setAdapter(adapter);

    }

}
