package op04;
/**
 * Example how to use split and join for string.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class SplitJoinExample {
  /**
   * Splits a string and joins the parts again.                     
   * @param args not used here 
   * WICHTIGCSVdateienExportierenImportierenTrennenZusammenfügenbinden             ***CSV***
   */
  public static void main(String[] args) {
    //1. Text in einer String-Variable speichern
    String text = "Das ist-ein Text, der verschiedene?" + "Symbole enthält!Aha.Ist ja spannend.";

    //2. String-Variable spliten und in einem Array-String speichern...Split with " " as separator
    String[] parts = text.split(" "); //in split gibt das Zeichen (hier ein Leerzeichen) womit man das split oder teilt
    
    //3. Array-String mit einer For-Schleife ausgeben
    for (int i = 0; i < parts.length; i++) {
      System.out.println(" Teil " + i + " : >" + parts[i] + "<");
    }

    // Weitere Split-Beispiele
    // Split with severals symbols as separator
    parts = text.split("[- ,?!.]"); 

    for (int i = 0; i < parts.length; i++) {
      System.out.println(" Teil " + i + " : >" + parts[i] + "<");
    }

    //1. String-Array oder String direkt schreiben ("hola que tal..."), mit join(":", arrStringName) anbinden
    // and now join them with ":"  das Gegenteil von Split
    String j = String.join(":",parts); 
    System.out.println(j); //Das:ist:ein:Text::der:verschiedene:Symbole:enthält:Aha:Ist:ja:spannend
  }
}
