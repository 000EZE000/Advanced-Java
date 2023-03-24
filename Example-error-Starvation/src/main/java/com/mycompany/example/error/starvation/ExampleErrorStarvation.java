/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.example.error.starvation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ezequiel
 */
public class ExampleErrorStarvation {

   public static void main(String[] args) {
        Fox robin = new Fox();
        Fox miki = new Fox();
        Elephant dumbo = new Elephant();
        Food food = new Food();
        
        ExecutorService service = null;
        try{
            service = Executors.newScheduledThreadPool(10);
            service.submit(()-> dumbo.eat(food));
            service.submit(()-> robin.eat(food));
            service.submit(()-> miki.eat(food));
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            if(service != null) service.shutdown();
    }
        
    }
    

    static class Food{}
    
    
    static class Elephant {
         public void eat(Food food){
            synchronized(food){
                System.out.println("Elephant Got Food!");
                try{
                    Thread.sleep(60*1000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
    }
         
    }
    static class  Fox {
        public void eat(Food food){
            move();        
            synchronized(food){
                System.out.println("Got Food!");
              
            }
        }
        public void move(){
            try{
               Thread.sleep(100);
            }catch(InterruptedException ex){
               System.out.println(ex.getMessage());
            }        
        }
         
        
    
    }
}
