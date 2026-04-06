package op04;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Simple class to execute string comparisons.
 * 
 * <p>Adaption of class Vergleiche from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class StringComparisonExample {
  /**
   * Creates three strings with same content. 
   * @param args not used here
   */
  public static void main(String[] args) {
    String a = "Hallo";  
    String b = new String(a);  // new address!
    String c = "Hallo"; // same address as a 

    //WICHTIGvergleichEQUALstring EQUALS() prüft den Inhalt aber '==' prüft die Adresse, ob die gleich sind

    System.out.println(a.equals(b)); //vergleich den Inhalt, welche text in a und in b
    // true, because contents are equal
    System.out.println(a == b); //vergleich die speicheradresse, NICHT den Inhalt
    // false, because addresses differ
    System.out.println(a == c); 
    // true, because addresses are equal

    // WICHTIGcompareTo() wenn strings gleich sind dann 0 Rückgabewert, minusWerte oder pluswert ist String kleiner oder größer
    System.out.println(a.compareTo(c));  // 0 also gleich
    System.out.println(a.compareTo(b));  // 0 also gleich
    System.out.println(c.compareTo(b));  // 0 also gleich

    
    //Adresse auch vergleich: compareTo() muss oben haben-> implements Comparable <StringComparisonExample>{...} 
    String a1 = "Hallo1";  
    String b1 = new String(a1);  // new address!
    String c1 = "Hallo"; // same address as a 

    System.out.println(a1.compareTo(c1));  // 1 also a1 > c1
    System.out.println(a1.compareTo(b1));  // 0 also gleich
    System.out.println(c1.compareTo(b1));  // -1 also c1 < b1
    System.out.println();

    //Beispiel mit sort()
    /* String werkzeug0 = "Hammer";
    String werkzeug1 = "Schraubenzieher";
    String werkzeug2 = "Bohrer"; */
    
    //besser in ein Array packen:
    String [] werkzeugkasten = {"Hammer","Schraubenzieher","Bohrer"};  //Wichtig_StringArray
    for (int i = 0; i < werkzeugkasten.length; i++ ){
      System.out.println(werkzeugkasten[i]);
    }
    //Array.sort(werkzeugkasten); das funkti. nicht!!!
    System.out.println();
    
    //Sortierung NUR VON PRIMITIVE DATENTYPEN MIT sort()  WICHTIG_sort() OP04.Seite51
    int [] arr = {13, 7, 3, 11, 91, 35};   //Wichtig_intArray
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++ ){
      System.out.println(arr[i]);
    }
    
    System.out.println();
    //sortierung weiter in der Klasse Complex

  }
}
