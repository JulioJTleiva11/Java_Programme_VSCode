package op04;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Simple class to demonstrate the use of hash tables.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

class Kanzler {
  public static void main(String[] args) {
    // creates hash table first
    //Bei einem Array ist der Index immer ein Zahl 0,1,..deshalb hier unten als Vector ist ein String: adenauer...
    Hashtable<String,Integer[]> kanzler = new Hashtable<String, Integer[]> (); //Constructor<Key, Value> von Hashtable

    kanzler.put(new String("Adenauer"), new Integer[] {1949,1963});  
    kanzler.put(new String("Erhard"), new Integer[] {1963,1966});
    kanzler.put(new String("Kiesinger"), new Integer[] {1966,1969});
    kanzler.put(new String("Brandt"), new Integer[] {1969,1974});
    kanzler.put(new String("Schmidt"), new Integer[] {1974,1982});
    kanzler.put(new String("Kohl"), new Integer[] {1982,1998});
    kanzler.put(new String("Schröder"), new Integer[] {1998,2005});
    kanzler.put(new String("Merkel"), new Integer[] {2005,2021});
    kanzler.put(new String("Scholz"), new Integer[] {2021,2024});

    /* 
     * Hier unten alles ist der Pfad für die Kommandozeile
     * 'c:\UNI\Labor2346\Semester 3\Objektorientiertes Programmieren\Java_Programme_VSCode'; & 
     * 'C:\Program Files\Java\jdk-23\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' 
     * '-cp' 'C:\Users\tomle\AppData\Roaming\Code\User\workspaceStorage\0b45b6d928789ea847239912443b4ef1\redhat.java
     * \jdt_ws\Java_Programme_VSCode_57d3390a\bin' 'op04.Kanzler' MErkel Trump Dierks Erhard
    */
    for (String arg : args) {         // all arguments, args aus der Kommandozeile übergeben
      if (kanzler.containsKey(arg)) { // if found, containsKey(arg) ist dieser arg-String der Namme eines Kanzlers?
        //es gibt auch für values: if(kanzler.containsValue(arg)){...} //exists "...| values"?
        Integer[] years = kanzler.get(arg);  //get() gib mir alle Elemente
        System.out.println("Kanzler(in): " + arg + " von: " + years[0] + " bis: " + years[1]);
      } else {
        System.out.println(arg + " war nie Kanzler(in)");
      }
    }

    // Printing the whole table. Watch the order of the elements!
    Enumeration<String> e = kanzler.keys(); // enumeration of all elements
    while (e.hasMoreElements()) {  // is still one left ?
      String name =  e.nextElement(); ; // returns elements subsequently
      System.out.println("Kanzler(in) " + name);
    }
  }
}
