package op02.constructors;

/**
 * Example how to use class Account.
 * 
 * <p>Adaption of class KontoTest from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class AccountExample {
  /**
   * Creates some accounts using various constructors.
   * @param args not used here
   */  
  public static void main(String[] args) {
    Account acc1 = new Account();    // mit NEW wird neuer Speicher geholt auf dem Heap(Speicherhaufen)
    acc1.info();

    Account acc2 = new Account(4711);
    acc2.info();

    Account acc3 = new Account(1234, 1000.0);

    Account acc4 = new Account(acc3);
    acc4.info();

    new Account(5678, 2000.0).info(); // anonymous object
    /* An account is created by a constructor, 
     * which returns a reference. To this reference
     * the method info() is applied immediately.
     * The reference is stored nowhere and will be
     * forgotten after this line. No chance to get it
     * back! 
     */
  }
}
