package com.ircclient.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ircclient.R;

import org.pircbotx.Configuration;

public class AddServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_server);
        Button saveBtn = (Button) findViewById(R.id.saveBtn);
    }

    public void addServer() {
        String name = ((EditText) findViewById(R.id.nameField)).getText().toString();
        String address = ((EditText) findViewById(R.id.addressField)).getText().toString();
        String portTmp = ((EditText) findViewById(R.id.portField)).getText().toString();
        int port = 6667;
        if(!portTmp.contains("(")) {
            port = Integer.parseInt(portTmp);
        }
        String nick = ((EditText) findViewById(R.id.nickField)).getText().toString();
        String username = ((EditText) findViewById(R.id.usernameField)).getText().toString();
        String realName = ((EditText) findViewById(R.id.realNameField)).getText().toString();


        Configuration arg = new Configuration.Builder()
                .setName(name)
                .setLogin(nick)
                .setAutoNickChange(true)
                .addServer(address, port)
                .buildConfiguration();
    }


}
