package org.ircclient;

/**
 * Created by pfff on 15.05.2016.
 */
public class Server {
    public Server() {
        this.serverName = "";
        this.ipAddress = "";
    }

    public Server(String ipAddress, String serverName) {
        this.ipAddress = ipAddress;
        this.serverName = serverName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getServerName() {
        return serverName;
    }


    private String ipAddress;
    private String serverName;

}
