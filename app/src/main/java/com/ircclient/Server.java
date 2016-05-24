package com.ircclient;

/**
 * Created by pfff on 15.05.2016.
 */
public class Server {
    public Server() {
        this.serverName = "";
        this.ipAddress = "";
        this.port = 0;
        this.serverHostname = "";
    }

    public Server(String ipAddress, String serverName, String serverHostname, int port) {
        this.ipAddress = ipAddress;
        this.serverName = serverName;
        this.port = port;
        this.serverHostname = serverHostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getServerName() {
        return serverName;
    }

    public String getServerHostname() {
        return serverHostname;
    }

    public int getPort() {
        return port;
    }


    private String ipAddress;
    private String serverName;
    private String serverHostname;
    private String nick;
    private String userName;
    private String realName;
    private int port;
}
