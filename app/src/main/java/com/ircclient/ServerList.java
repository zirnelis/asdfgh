package com.ircclient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pfff on 25.05.2016.
 */
public class ServerList extends Server implements Serializable {
    protected List<Server> serversInList = new ArrayList<>();

    public ServerList() {
        this.serversInList = new ArrayList<>();
    }

    public ServerList(ArrayList<Server> list) {
        this.serversInList = list;
    }

    public ArrayList<Server> getList() {
        return (ArrayList) serversInList;
    }

    public void setList(ArrayList<Server> serversInList) {
        this.serversInList = serversInList;
    }

    public void addServer(Server s) {
        serversInList.add(s);
    }

    public void remove(int pos) {
        serversInList.remove(pos);
    }
}
