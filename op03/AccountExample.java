package op03;

/**
 * Example how to use try-catch.
 * 
 * <p>Adaption of class Test from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class AccountExample {
  /**
   * Creates an account and provokes an exception.
   * @param args not used here
   */  
  public static void main(String[] args) {
    Account acc = null;
    try {
      acc = new Account(4711, 500); 
      acc.payOut(1000); // won't work!
      acc.info();
    } catch (AccountException e) {
      System.out.println(e);
    }

    if (acc != null) {
      acc.info();
    }
  }
}
