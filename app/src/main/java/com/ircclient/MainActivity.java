package com.ircclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ircclient.activity.AddServerActivity;

public class MainActivity extends AppCompatActivity {

    ViewGroup view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populateList();
        Button moveBtn = (Button) findViewById(R.id.moveBtn);

        moveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddServerActivity.class));
            }
        });


    }
}
