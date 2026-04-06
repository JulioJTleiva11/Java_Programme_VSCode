package op04;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Example how to use GregorianCalendar.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class GregorianCalendarExample {
  /**
   * Constructs two dates and prints them.
   * @param args not used here
   */
  public static void main(String[] args) {
    SimpleDateFormat 
      f = new SimpleDateFormat("d.M.yy H:mm");
    
    // Beware: Months are 0-11 !!!!
    GregorianCalendar 
      exam = new GregorianCalendar(2022,2 - 1,17,9,0); 
    GregorianCalendar 
      party = (GregorianCalendar) exam.clone();
    party.add(Calendar.HOUR,3); // + 3 hours

    System.out.println("Beginn der Prüfung : "
        + f.format(exam.getTime()));
    System.out.println("Beginn der Party   : "
        + f.format(party.getTime()));
  }
}
