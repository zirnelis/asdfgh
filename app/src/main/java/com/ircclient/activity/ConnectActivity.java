package com.ircclient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ircclient.MainActivity;
import com.ircclient.R;
import com.ircclient.ServerList;
import com.ircclient.adapter.ServerAdapter;

public class ConnectActivity extends AppCompatActivity {

    ServerList serverList = new ServerList();

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectActivity.this, MainActivity.class);
        intent.putExtra("serverList", serverList);
        setResult(RESULT_OK, intent);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        try {
            serverList = (ServerList) getIntent().getSerializableExtra("serverList");
        } catch(NullPointerException ex) {
        }
        if(serverList == null) {
            serverList = new ServerList();
        }

        final ListView servList = (ListView) findViewById(R.id.servList_);
        ServerAdapter adapter = new ServerAdapter(serverList, getApplicationContext());
        try {
            servList.setAdapter(adapter);
        } catch(NullPointerException ex) {
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
        }

        servList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                serverList.remove(position);
                return false;
            }
        });

        servList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ConnectActivity.this, ChatActivity.class);
                intent.putExtra("serverList", serverList);
                startActivity(intent);
            }
        });

    }
}
