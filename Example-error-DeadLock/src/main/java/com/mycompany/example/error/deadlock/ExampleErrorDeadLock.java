/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.example.error.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ezequiel
 */
public class ExampleErrorDeadLock {

    public static void main(String[] args) {
        Fox robin = new Fox();
        Fox miki = new Fox();
        Water water = new Water();
        Food food = new Food();
        
        ExecutorService service = null;
        try{
            service = Executors.newScheduledThreadPool(10);
            service.submit(()-> robin.drinkAndEat(food, water));
            service.submit(()-> miki.eatAndDrink(food, water));
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            if(service != null) service.shutdown();
    }
        
    }
    
    static class Water{}
    static class Food{}
    
    static class  Fox {
        public void eatAndDrink(Food food , Water water){
            synchronized(food){
                System.out.println("Got Food!");
                move();
                synchronized(water){
                System.out.println("Got Water");
            }
            }
         
        }
        public void drinkAndEat(Food food, Water water){
            synchronized(water){
                System.out.println("Got Water");
                move();
                synchronized(food){
                System.out.println("Got Food!");
            }
            }
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
