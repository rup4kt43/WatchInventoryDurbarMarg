package com.example.watchinventorydurbarmarg.Utilities;

public class LoginIPaddress {
  public  static String ipAddress="";

    public static void setIpAddress(String ip1,String ip2,String ip3,String ip4,String port){
        ipAddress = ip1+"."+ip2+"."+ip3+"."+ip4+":"+port;
    }
}
