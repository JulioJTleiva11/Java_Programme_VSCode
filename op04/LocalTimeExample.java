package op04;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Example how to use LocalTime.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class LocalTimeExample {

  public static void main(String[] args) {
    LocalTime now          = LocalTime.now();  //now object
    LocalTime endOfLecture = LocalTime.parse("15:25"); //rufe parse um string zu übergeben
    //vergleich mit IF ob es endOfLecture gleich wie now ist(1525)    
    if ( now.isBefore(endOfLecture) ) { //wenn das parsen klappt, if=1 == end of lecture
      System.out.println("Noch "
        + now.until( endOfLecture, ChronoUnit.MINUTES )  //
        + " Minuten bis Feierabend");
    } 
  }
}
