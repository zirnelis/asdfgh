package com.ircclient.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ircclient.R;
import com.ircclient.Server;

import java.util.ArrayList;

public class AddServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_server);
        Button saveBtn = (Button) findViewById(R.id.saveBtn);
        EditText nameField = (EditText) findViewById(R.id.nameField);
        EditText address = (EditText) findViewById(R.id.addressField);
        EditText port = (EditText) findViewById(R.id.portField);
        EditText nice = (EditText) findViewById(R.id.nickField);
        EditText usrName = (EditText) findViewById(R.id.usernameField);
        EditText realName = (EditText) findViewById(R.id.realNameField);
        final ArrayList<EditText> lol = new ArrayList<>();
        lol.add(nameField);
        lol.add(address);
        lol.add(port);
        lol.add(nice);
        lol.add(usrName);
        lol.add(realName);

        EditText.OnKeyListener myListener = new EditText.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == 66){
                    for(int i = 0; i < lol.size(); i++) {
                        if(lol.get(i).isFocused()) {
                            lol.get(i + 1).requestFocus();
                        }
                    }
                }
                return false;
            }
        };

        for(int i = 0; i < lol.size(); i++) {
            lol.get(i).setOnKeyListener(myListener);
        }



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

        Server newServer = new Server();

    }
}
