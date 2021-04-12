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

    public int getSubNetMask() {
        return subNetMask;
    }

    public String getSubNetMaskString(){
        StringBuilder sb = new StringBuilder("00000000000000000000000000000000");
        for(int i = 0; i < this.getSubNetMask(); i++){
            sb.replace(i, i + 1, "1");
        }

        return sb.toString();
    }

    private String and(String ip, String mask){
        ip = getAsBinary(ip);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 32; i++){
            sb.append(Integer.parseInt(ip.charAt(i) + "") & Integer.parseInt(mask.charAt(i) + ""));
        }

        return formatAsIp(sb.toString());

    }

    private String formatAsIp(String binary){
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 32; i++){

            sb.append(binary.charAt(i));
            if((i + 1) % 8 == 0){
                result.append(Integer.parseInt(sb.toString(), 2));
                result.append(".");
                sb = new StringBuilder();
            }
        }

        return result.substring(0, result.length() - 1);
    }

    private String getAsBinary(String ip){
        String[] parts = ip.split("\\.");
        StringBuilder sb = new StringBuilder();

        sb.append(getBinary(parts[0]));
        sb.append(getBinary(parts[1]));
        sb.append(getBinary(parts[2]));
        sb.append(getBinary(parts[3]));

        return sb.toString();

    }

    private String getBinary(String part){
        return String.format("%8s", Integer.toBinaryString(Integer.parseInt(part))).replace(' ', '0');
    }

    public String getName() {
        return name;
    }

    public boolean ipMatchesSubnet(String ipToCheck){
        return and(ipToCheck, getSubNetMaskString()).equals(this.ipAddress);
    }
}
