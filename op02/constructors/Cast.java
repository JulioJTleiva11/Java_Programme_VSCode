package op02.constructors;

/**
 * Class to show up- and downcasting.
 * 
 * <p>Adaption of class Cast from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class Cast {
  /**
   * Creates an account (in fact a Giroaccount) and 
   * applies methods to demonstrate the effects of
   * casting.
   * @param args not used here
   */
  public static void main(String[] args) {
    // Upcast
    System.out.println("UPCAST");
    Account acc = new Giroaccount(1020, 800., 2000.);
    acc.payOut(2800.);
    System.out.println(acc.getBalance());  //bis hier balance -2000

    // Downcast
    System.out.println("DOWNCAST");
    ((Giroaccount) acc).setLimit(2500.);
    acc.payOut(500.);  // -2000 -500 = -2500, falls -501 dann balance overflow
    System.out.println(acc.getBalance());
  }
}
