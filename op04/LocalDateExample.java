package op04;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Example how to use LocalDate.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class LocalDateExample {

  public static void main(String[] args) {
    LocalDate today   = LocalDate.now();
    LocalDate tmpDate = LocalDate.parse("1970-12-24");//parse mit sintax 1970-12-24
    LocalDate xmas    = tmpDate.withYear(today.getYear()); //weihnachten von 1970
    
    if (today.isBefore(xmas)) { //wenn heute vor weihnachten ist, rechne wie viele Tage bis weihnachten 
      System.out.println("Noch "
        + today.until(xmas, ChronoUnit.DAYS)  
        + " Tage bis Weihnachten"); 
    } 
  }
}
