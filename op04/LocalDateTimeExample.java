package op04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Example how to use LocalDateTime.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class LocalDateTimeExample {
  public static void main(String[] args) {
    LocalDateTime now      = LocalDateTime.now();
    LocalDate     newYear  = LocalDate.of(now.getYear()+1,1,1);//das jahr von heute plus 1, ...
    LocalTime     midNight = LocalTime.of(00, 00);

    //LocalDate now  = LocalDatenow.plusYears(2);
   // Schaltjahr ist: durch 4 teilbar, duch 100 und durch 400!!!
    LocalDateTime 
      startOfFireworks = LocalDateTime.of(newYear,midNight);

    if (now.isBefore(startOfFireworks)) {
      long seconds = now.until(startOfFireworks, 
                               ChronoUnit.SECONDS);
      System.out.println("Noch " 
                         + seconds 
                         + " Sekunden bis zum neuen Jahr");
      System.out.println("Das sind " 
                         + seconds/(60*60) + " Stunden");
      System.out.println("Das sind "
                         + seconds/(60*60*24) + " Tage");
    }	 
  }
}
