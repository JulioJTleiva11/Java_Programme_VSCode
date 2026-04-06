package op04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Example how to format a date.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class DateTimeFormatterExample {
  public static void main(String[] args) {
    LocalDateTime moon = LocalDateTime.of(1969,10,21,20,17,40);
    // some formatting patterns
    DateTimeFormatter[] formats = new DateTimeFormatter[] {
      DateTimeFormatter.ofPattern("d.M.yy"),  //pattern ist eine Art formatierer, zb. 1969 => yy = 69
      DateTimeFormatter.ofPattern("dd.MM.yyyy H:mm:ss"),
      DateTimeFormatter.ofPattern("E, dd. MMM yyyy H:mm"),  // E = wochentag
      DateTimeFormatter.ofPattern("EEEE, dd. MMMM yyyy, HH:mm:ss")
    };  

    for (DateTimeFormatter dateFormat : formats) {
      System.out.println("F: " + moon.format(dateFormat));
    }
  } 
}
