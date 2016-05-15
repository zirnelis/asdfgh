package org.ircclient.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;


import com.ircclient.R;
import org.ircclient.Server;

import java.util.ArrayList;

/**
 * Created by pfff on 15.05.2016.
 */
public class ServerAdapter extends ArrayAdapter<Server> {

    public ServerAdapter(Context context, ArrayList<Server> servers) {
        super(context, 0, servers);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Server server = getItem(position);  // Get data for this position
        if(convertView == null) {           // Check if existing view is being reused
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_server, parent);
        }
        // Lookup for view population
        TextView servName = (TextView) convertView.findViewById(R.id.serverName);
        TextView ipAddress = (TextView) convertView.findViewById(R.id.ipAddress);
        // Gets data for template view
        servName.setText(server.getServerName());
        ipAddress.setText(server.getIpAddress());

        return convertView;                 // Return completed view
    }
}
