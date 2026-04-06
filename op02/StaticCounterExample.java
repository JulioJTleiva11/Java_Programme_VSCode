package op02;

/**
 * Simple Example of a static variable.
 * 
 * <p>Adaption of class ZaehlerTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class StaticCounterExample {
  //* Attributes
  private static int counter; // static, no connection to
                              // an object.
  
  /**
   * Constructor increases static counter.
   */
  public StaticCounterExample() {
    counter++;
  }
  
  /**
   * Creates three objects and static counter is 
   * increased.
   * @param args not used here
   */
  public static void main(String[] args) {
    new StaticCounterExample();
    new StaticCounterExample();
    new StaticCounterExample();

    System.out.println(StaticCounterExample.counter);
  }
}
