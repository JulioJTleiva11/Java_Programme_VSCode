package op02;

/**
 * Example for static imports. 
 * 
 * <p>Adaption of class Test from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

import static java.lang.Math.*; // ALL static elements
import static java.lang.System.out; // "out" only

public class StaticImportExample {
  /**
   * Use static imports for demonstration purposes only. 
   * @param args not used here
   */
  public static void main(String[] args) {
    out.println("sin(PI/4) = " + sin(PI / 4));
    // "out" instead of "System.out"
    // "sin" instead of "Math.sin"
    // "PI" instead of "Math.PI"
  }
}
