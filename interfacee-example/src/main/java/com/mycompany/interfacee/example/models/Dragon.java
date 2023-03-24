/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfacee.example.models;

/**
 *
 * @author ezequiel
 */
public class Dragon extends Enemy implements Flyable {
    
    public Dragon(Double health, Integer posX, Integer posY) {
        super(health, posX, posY);
    }
    
    @Override
     public void fly() {
       System.out.println("FLYYYYY");
    }
    
}
