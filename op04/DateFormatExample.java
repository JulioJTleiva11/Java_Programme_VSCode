package op04;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Example how to format a date.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
class DateFormatExample {
  public static void main(String[] args) {
    Date now = new Date();
    // some formatting patterns
    SimpleDateFormat[] formats = new SimpleDateFormat[] {
        new SimpleDateFormat("d.M.yy"),
        new SimpleDateFormat("dd.MM.yyyy E H:mm:ss"),
        new SimpleDateFormat("dd.MM.yyyy E H:mm"),
        new SimpleDateFormat("EEEE, dd.MM.yyyy HH:mm:ss")
    };  

    for (SimpleDateFormat dateFormat : formats) {
      System.out.println("F: " + dateFormat.format(now));
    }
  } 
}
