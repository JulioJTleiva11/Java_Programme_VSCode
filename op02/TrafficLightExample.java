package op02;

/**
 * Example how to use enums.
 * 
 * <p>Adaption of class Test from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class TrafficLightExample {
  /**
   * prints out some information about the color. 
   * @param color the color of interest
   */
  public static void info(TrafficLightColor color) {
	// ordinal returns the number 
  //System.out.print(color.ordinal());     //ordinal beginnt bei 0
  //System.out.print((color.ordinal()+1)); //deshalb +1 in Klammern!
	System.out.print("Nummer " + (color.ordinal()+1)); //Für die Numerierung: 0, 1, 2,...ordinal beginnt bei 0, deshalb +1
    switch (color) {    //WichtigSwitchEnum
      case RED: // works in cases!
        System.out.println(": Anhalten");
        break;
      case YELLOW: 
        System.out.println(": Achtung");
        break;
      case GREEN:
        System.out.println(": Weiterfahren");
        break;
      default: 
        System.out.println(": Unbekannte Farbe");
    }
  }

  /**
   * Plays around with the enum features. 
   * @param args not used here
   */
  public static void main(String[] args) { 
    //neuer Var erzeugen und initialisieren
    TrafficLightColor extraColor = TrafficLightColor.BLUE;

    info(TrafficLightColor.RED);
    info(TrafficLightColor.YELLOW);
    info(TrafficLightColor.GREEN);
    info(extraColor);  //info(TrafficLightColor.BLUE); //geht auch

    // TrafficLightColor.values returns all values on for-each 
    for (TrafficLightColor color : TrafficLightColor.values()) { //values() liefert ein Array mit allen Elementen zurück
      // color.toString() returns the name of the element 
      System.out.println(color.toString()); //Farben ausdrucken
    }
  }
}
