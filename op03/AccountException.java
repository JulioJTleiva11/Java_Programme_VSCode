package op03;

/**
 * Exception for class Account.
 * 
 * <p>Adaption of class Division from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class AccountException extends Exception {

  public AccountException() {
    // exception with no explanation 
  }

  public AccountException(String message) {
    super(message); // with explanation in message
  }
}
