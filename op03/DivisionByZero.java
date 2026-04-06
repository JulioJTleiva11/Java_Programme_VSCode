package op03;

/**
 * Example of a runtime exception.
 * 
 * <p>Adaption of class Division from D. Abts
 * @author Henning Dierks
 * @version 1.1
 */

public class DivisionByZero {
  /**
   * Produces an division by zero exception.
   * @param args not used here
   */
  public static void main(String[] args) {
    for (int i = 5; i > 0; i--) {
      System.out.println("10:"+i+"=" + 10 / i); // bad thing
      
    }


    int x = 1;
    System.out.println(++x); //2
    System.out.println();
    int y = 15;
    System.out.println(y++); //15
    System.out.println(y++/5); //es wird nicht addiert also 15 / 5 = 3;    ++ wird ignoriert

  }    
}
