/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfacee.example.models;

/**
 *
 * @author ezequiel
 */
public abstract class  Enemy {
    protected Double health;
    protected Integer posX;
    protected Integer posY;

    public Enemy(Double health, Integer posX, Integer posY) {
        this.health = health;
        this.posX = posX;
        this.posY = posY;
    }

    public Double getHealth() {
        return health;
    }

    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }

    @Override
    public String toString() {
        return "Enemy{" + "health=" + health + ", posX=" + posX + ", posY=" + posY + '}';
    }
    
}
