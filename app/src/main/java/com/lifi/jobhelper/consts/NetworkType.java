package com.lifi.jobhelper.consts;

public class NetworkType {

    public static NetworkType NETWORK_WIFI = new NetworkType("WiFi");
    public static NetworkType NETWORK_4G = new NetworkType("4G");
    public static NetworkType NETWORK_2G = new NetworkType("2G");
    public static NetworkType NETWORK_3G = new NetworkType("3G");
    public static NetworkType NETWORK_UNKNOWN = new NetworkType("Unknown");
    public static NetworkType NETWORK_NO = new NetworkType("No network");

    private String desc;

    NetworkType(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;

    }
}
