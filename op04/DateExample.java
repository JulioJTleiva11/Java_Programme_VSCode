package op04;
import java.util.Date;

/**
 * Example how to use Date.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

class DateExample {
  /**
   * Constructs three Date objects and prints them.
   * @param args not used here
   */
  public static void main(String[] args) {
    Date now   = new Date();  //Date() ist schon veraltet, besser LocalTime()
    Date later = new Date(now.getTime() + 1000 * 60 * 60); 

    System.out.println(" Jetzt : " + now);
    System.out.println(" Später: " + later);
    // and now wait for approximately 1 second
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }   
    Date now2  = new Date(); // later than now?
    System.out.println(" Jetzt2: " + now2);

    System.out.println(" Differenz in Millisekunden: " 
        + (now2.getTime() - now.getTime()));
  }
}
