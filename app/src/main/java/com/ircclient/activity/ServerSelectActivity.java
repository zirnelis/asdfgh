package com.ircclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ircclient.R;

import java.util.ArrayList;
import java.util.List;

public class ServerSelectActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_select);

        lv = (ListView) findViewById(R.id.listView_servers);
        List servers = new ArrayList<String>();
        servers.add("IRCnet");
        servers.add("QuakeNet");
        servers.add("EFnet");
        servers.add("Rizon");
        servers.add("Undernet");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                servers
        );
        lv.setAdapter(arrayAdapter);
    }


}
