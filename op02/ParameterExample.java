package op02;

/**
 * Example for parameters.
 * 
 * <p>Adaption of class ParamTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class ParameterExample {
  /**
   * Example of method with different kind of parameters.
   * 
   * <p>changes of account will be visible when method is
   * finished
   * @param amount is double (primitive type) 
   *                          -> value is copied
   * @param account is a reference to an object 
   *                          -> not copied
   */
  public void example(double amount, Account account) {
    amount += 100.0;       // increase amount
    account.payIn(amount); // and pay in
  }

  /**
   * Simple main-method creating an account and invoke 
   * a method.
   * @param args not used here
   */
  public static void main(String[] args) {
    ParameterExample p = new ParameterExample();

    double value = 1000.0;
    Account account = new Account();

    System.out.println("Before : value=" + value + " balance=" + account.getBalance());

    // method invocation: value is copied, account isn't
    p.example(value, account);

    System.out.println("After  : value=" + value + " balance=" + account.getBalance());
  }
}
