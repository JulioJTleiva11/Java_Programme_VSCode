package op04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Example how to parse a date.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class DateTimeParsingExample {
  public static void main(String[] args) {
    DateTimeFormatter parsingFormat 
      = DateTimeFormatter.ofPattern("d.M.yy H:mm:ss");
    DateTimeFormatter outputFormat 
      = DateTimeFormatter.ofPattern("EEEE, dd. MMM yyyy, HH:mm:ss");
	 
    String aText = "29.1.24 9:00:00";
    LocalDate aDate = LocalDate.parse(aText,parsingFormat); 
    LocalTime aTime = LocalTime.parse(aText,parsingFormat);


    LocalDateTime aDateTime= LocalDateTime.parse(aText, parsingFormat); // schlechtes beispiel

    System.out.println("Unformatiert : " + aDate);  //amerikanische uhrzeit
    System.out.println("Unformatiert : " + aTime);
    System.out.println("Unformatiert : " + aDateTime); //unformatiert von schlehcten beispiel

    
	
    LocalDateTime exam = LocalDateTime.of(aDate,aTime);
    System.out.println("Prüfungbeginn: "
                       + exam.format(outputFormat));  //hier wird formatiert alles
	}
}
