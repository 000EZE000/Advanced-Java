/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dessing.pattern.builder;

import com.mycompany.dessing.pattern.builder.Person;

/**
 *
 * @author ezequiel
 */
public class DessingPatternBuilder {

    public static void main(String[] args) {
      Person ezequiel = Person.Builder
                                .aPerson()
                                .withName("Ezequiel")
                                .withEmail("ezequie@gmail")
                                .withLastName("sosa")
                                .withPhone(12312313)
                                .build();
   
    
      System.out.println(ezequiel.toString());
    }
}
