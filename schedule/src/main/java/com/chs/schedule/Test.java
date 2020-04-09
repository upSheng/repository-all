package com.chs.schedule;

import java.net.InetAddress;

public class Test {


    public static void main(String[] args) {

        try{
            String ip1  = InetAddress.getLocalHost().getHostAddress();

            System.out.println("ip1:"+ip1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
