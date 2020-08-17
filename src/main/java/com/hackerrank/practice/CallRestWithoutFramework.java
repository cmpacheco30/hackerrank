package com.hackerrank.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallRestWithoutFramework {

    public static void main(String[] args) {

        try{
            String endpointGet="https://jsonmock.hackerrank.com/api/football_matches?year=2011";
            URL url=new URL(endpointGet);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept","application/json");

            BufferedReader br=new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder builder=new StringBuilder();
            String output;
            while((output=br.readLine())!=null){
                System.out.println(output);
                //builder.append(output);
            }

            conn.disconnect();

            //return Integer.parseInt(builder.toString().split(",\"")[2].split(":")[1]);

        }catch(Exception e){
            e.printStackTrace();
        }

        //return0;


    }
}
