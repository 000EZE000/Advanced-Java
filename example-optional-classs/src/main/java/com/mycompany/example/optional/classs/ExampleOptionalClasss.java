/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.example.optional.classs;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ezequiel
 */
public class ExampleOptionalClasss {

    public static void main(String[] args) {
        Optional average = averageScores(1.2,9.2, 5.6);
        if(average.isEmpty()){
            System.out.println("this emptiness");
           
        }else{
            System.out.println("The average is : " + average.get());
        }
        
        exampleLambda();
    }
    
    public static void exampleLambda(){
        List<String> contries = new ArrayList<>();
        contries.add("Argentina");       
        contries.add("Peru");
        contries.add("Dinamarca");
        contries.add("Inglaterra");
        contries.add("Alemania");
        
        Optional<String> country = contries.stream().filter(countryP -> countryP.startsWith("Arg")).findFirst();
        
        country.ifPresent(System.out::println);
        
    }       
    
    
    public static Optional<Double> averageScores(Double ...scores){
        if(scores.length == 0){
            return Optional.empty();
        }
        double sum = 0;
        for(Double score : scores) sum+= score;
        return Optional.of(sum/scores.length);
    }
}
