/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dessing.pattern.builder;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author ezequiel
 */
public class Person {
    private  String name;
    private  String lastName;
    private  String email;
    private  int phone;

    private Person(String name, String lastName, String email, int phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    
    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }


    @Override
    public String toString() {
        return "Person { " +
                "\n  name = " + name +
                ",\n  lastName = " + lastName +
                ",\n  emial = " + email + 
                ",\n  phone = " +phone + 
                "\n }";
    }

    public static  class Builder {
        private  String name;
        private  String lastName;
        private  String email;
        private  int phone;

        
        
        public static  Builder aPerson(){
            return new Builder();
        }
        
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder withEmail(String email){
            this.email = email;
            return this;
        }
        public Builder withPhone(int phone){
            this.phone = phone;
            return this;
        }
        public Person build(){
            return new Person(name,lastName,email,phone);
        }
    }
   

 
   
}
