/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.robot.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author ezequiel
 */
public class RobotCopy {

    public static void main(String[] args) throws Exception  {
        Count count = new Count();       
        Thread first = new Thread(count, "first");        
        Thread second = new Thread(count, "first");

        first.start();
        second.start();
       
        first.join();
        second.join();
        System.out.println(count.count + "");
 
     
    }
    
    static class Count extends Thread {
        public AtomicInteger count = new AtomicInteger(0);
        public void run(){
            for(int i=0; i < 100_000_000 ; i++){
                count.addAndGet(1);
            }
        } 
    }
    
    
   private List<String> getLinks(){
     List<String> links = new ArrayList<>();
     links.add("https://www.bbc.com/sport/live/football/65028436");    
     links.add("https://www.bbc.com/news/world-asia-india-65048602");
     links.add("https://www.bbc.com/sport/athletics/65051900");
     links.add("https://www.bbc.com/culture/article/20230321-succession-season-4-a-jaw-dropping-finale");
     links.add("https://www.bbc.com/travel/article/20230322-toheroa-a-fabled-shellfish-that-nearly-vanished");
     links.add("https://www.bbc.com/news/world-australia-65048226");
     return links;
   }
    
   
   private void getWebsContent(List<String> links){
        links.stream().parallel().forEach(link->System.out.println(getWebContent(link)) );
   }
   
     //Download Webs
   private static String getWebContent(String link) {
       try{
            URL url = new URL(link);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            String encoding = connect.getContentEncoding();
            InputStream input = connect.getInputStream();
            //download webs 
            String result = new BufferedReader(new InputStreamReader(input))
                            .lines().collect(Collectors.joining());
            return result;
       }catch(IOException ex){
            System.out.println(ex);
            return "" + ex.getMessage();
       }
       
   }
   
   private static void time(List<String> links){
     
     long timeStart = System.nanoTime();
     links.stream().parallel().forEach(link->System.out.println(getWebContent(link)) );
     long timeEnd = System.nanoTime();
     System.out.println("time fast " + (timeEnd - timeStart));
     
     timeStart = System.nanoTime();
     links.stream().forEach(link->System.out.println(getWebContent(link)) );
     timeEnd = System.nanoTime();
     System.out.println("time fast " + (timeEnd - timeStart));
   }
   
   private static void atomic() throws Exception{
       System.out.println("Start");
       Thread.sleep(2000);
       System.out.println("End");
   }
  
}
