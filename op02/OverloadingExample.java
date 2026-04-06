package op02;

/**
 * Example for overloading methods.
 * 
 * <p>Adaption of class OverloadingTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class OverloadingExample {
  public int max(int a, int b) {
    System.out.println("Signature: max int int");
    return a < b ? b : a;
  }

  public double max(double a, double b) {
    System.out.println("Signature: max double double");
    return a < b ? b : a;
  }

  public int max(int a, int b, int c) {
    System.out.println("Signature: max int int int");
    return max(max(a, b), c);
  }

  /**
   * Simple main-method invoking overloaded method several 
   * times.
   * @param args not used here
   */
  public static void main(String[] args) {
    OverloadingExample overExample 
      = new OverloadingExample();
    System.out.println("max(1, 3): " 
                       + overExample.max(1, 3));
    System.out.println();
    System.out.println("max(1, 3, 2): " 
                       + overExample.max(1, 3, 2));
    System.out.println();
    System.out.println("max(1.0, 3.0): " 
                       + overExample.max(1.0f, 3.0f));
    System.out.println();
    System.out.println("max(1.0, 3): " 
                       + overExample.max(1.0, 3));
  }
}
