package com.ircclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ircclient.activity.ServerSelectActivity;

import org.pircbotx.PircBotX;
import org.pircbotx.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewGroup view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populateList();

        view = (ViewGroup) findViewById(R.id.listView_servers);
        view.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButton();
                        return true;
                    }
                }
        );

    }

    public void moveButton() {

        Intent intent = new Intent(this, ServerSelectActivity.class);
        startActivity(intent);
        Configuration arg = new Configuration.Builder()
                .setName("Test Bot")
                .setLogin("MrTestBot")
                .setAutoNickChange(true)
                .addServer("irc.esper.net",6667)
                .buildConfiguration();
    }
}