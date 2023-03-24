/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dates.after.before;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author ezequiel
 */
public class DatesAfterBefore {

    public static void main(String[] args) {
       // after
       Calendar afterDate = Calendar.getInstance();
       afterDate.set(12, Calendar.FEBRUARY);
       
       //before
       
       LocalDate beforeDate = LocalDate.of(2022,Month.FEBRUARY,1);
       LocalTime beforeTime = LocalTime.of(2,12);
       LocalDateTime beforeDateTime = LocalDateTime.of(beforeDate, beforeTime);
       LocalDateTime beforeDateTime2 = LocalDateTime.of(2012, Month.DECEMBER, 21, 21, 32);
       LocalDateTime lessSevenDay = beforeDateTime.minusDays(7);
       LocalDateTime addSevenDay = beforeDateTime2.plusDays(7);
       
       String parseStringDate = lessSevenDay.format(DateTimeFormatter.ISO_DATE);
       String parseStringDate2 = addSevenDay.format(DateTimeFormatter.ISO_DATE);
       
       System.out.println(parseStringDate + " "  +parseStringDate2);
       
    }


       
    
}
