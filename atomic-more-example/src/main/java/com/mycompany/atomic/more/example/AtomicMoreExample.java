/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atomic.more.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author ezequiel
 */
public class AtomicMoreExample {
    private static Map<String , Double> pricesByAirline;
    
    public static void main(String[] args) {
        init();
        String to = "Brasil";
        String from = "Colombia";
        Double lowesPrice = getLowestPrice(from,to);
        Double averagePrice = totalPrice(from,to);
        
        System.out.println("lowest price : " + lowesPrice);        
        System.out.println("lowest average price : " + averagePrice);

    }
    private static Double getLowestPrice(String from , String to){
        AtomicReference<Double> lowesPrice = new AtomicReference<>(null);
        pricesByAirline.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline,from,to);
            if(lowesPrice.get() == null || price < lowesPrice.get()){
                lowesPrice.set(price);
            }
        });
        return lowesPrice.get();
    }
    
        private static Double totalPrice(String from , String to){
        AtomicReference<Double> sumPriceAirline = new AtomicReference<>(0.00);        
        AtomicInteger countAirlines = new AtomicInteger(0);

        pricesByAirline.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline,from,to);
                sumPriceAirline.set(price  + sumPriceAirline.get());
                countAirlines.incrementAndGet();
        });
        return sumPriceAirline.get()/ countAirlines.get();
    }
    
    private static void init(){
        pricesByAirline = new HashMap<>();
        pricesByAirline.put("America Airlines", 550.0);        
        pricesByAirline.put("US Airways", 610.0);
        pricesByAirline.put("Delta Airlines", 540.0);
        pricesByAirline.put("Singapore Airlines", 612.0);
        pricesByAirline.put("Qatar Pacific Airways", 590.0);
        pricesByAirline.put("Sky Airlines", 585.0);
        pricesByAirline.put("Copa Airlines Colombia", 540.0);
        pricesByAirline.put("Avianca", 610.0);
        pricesByAirline.put("LATAM Airlines Group", 600.0);
        pricesByAirline.put("Aeromexico", 740.0);
        pricesByAirline.put("Aerolineas Argentinas", 940.0);
    }
  
    
    private static Double getPriceTrip(String Airline, String from , String to){
 
        try{
            Thread.sleep(1500);
        }catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
            
        return pricesByAirline.get(Airline);
        
    }
    
   
}
