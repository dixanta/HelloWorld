package com.cibt.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cibt.app.util.HttpClient;


public class Program{
    public static void main(String[] args){
        try{
            System.out.println("Web scrapping");
            String content = HttpClient.get("https://creators.institute");

            String regEx="<div class=\"card-body text-center\">";

           Pattern pattern=Pattern.compile(regEx);
           Matcher matcher=pattern.matcher(content);
           while(matcher.find()){
               System.out.println(matcher.group());
           }

        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}