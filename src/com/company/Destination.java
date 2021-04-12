package com.company;

public class Destination {

    private String ipAddress;
    private int subNetMask;
    private String name;

    public Destination(String ipAddress, int subNetMask, String name) {
        this.ipAddress = ipAddress;
        this.subNetMask = subNetMask;
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getSubNetMask() {
        return subNetMask;
    }

    public void setSubNetMask(int subNetMask) {
        this.subNetMask = subNetMask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean ipMatchesSubnet(String ipToCheck){

        return false;
    }
}
