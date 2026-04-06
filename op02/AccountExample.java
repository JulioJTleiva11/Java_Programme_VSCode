package op02;

/**
 * Example how to use class Account.
 * 
 * <p>Adaption of class KontoTest from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class AccountExample {

  /**
   * Creates an account and invokes some methods.
   * @param args not used here
   */
  public static void main(String[] args) {
    // Creating an object of class Account
    Account myAccount = new Account();

    // Applying some methods to my account
    myAccount.setAccountnumber(4711);
    myAccount.setBalance(500.0);
    myAccount.payIn(10000.0);
    double balance = myAccount.getBalance();
    System.out.println("Balance: " + balance);
  }
}
