package op03;

/**
 * Simple Account using exceptions.
 * 
 * <p>Adaption of class Konto from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class Account {

  //Attribute
  private int accountnumber;
  private double balance;

  //Konstruktors
  public Account() {
  }

  public Account(int kontonummer) {
    this.accountnumber = kontonummer;
  }

  /**
   * Constructs an account with non-negative balance only.
   * 
   * @param accountnumber number of the new account
   * @param balance initial balance (must be >=0)
   * @throws AccountException thrown if balance<0
   */
  public Account(int accountnumber, double balance) throws AccountException {

    if (balance < 0) {
      throw new AccountException("Negative balance: " + balance);
    }
    
    this.accountnumber = accountnumber;
    this.balance = balance;
  }

  public int getAccountnumber() {
    return accountnumber;
  }

  public void setAccountnumber(int number) {
    accountnumber = number;
  }

  public double getBalance() {
    return balance;
  }

  /**
   * Sets the balance to a new value (>=0).
   * 
   * @param amount the new balance 
   * @throws AccountException thrown if balance<0
   */
  public void setBalance(double amount) throws AccountException {

    if (amount < 0) {
      throw new AccountException("Negative Balance: " + amount);
    }

    balance = amount;
  }

  /**
   * Increases balance of the account.
   * @param amount How much money is paid in (must be >=0) 
   * @throws AccountException thrown if amount<0.
   */
  public void payIn(double amount) throws AccountException {

    if (amount < 0) {
      throw new AccountException("Negative pay in: " + amount);
    }

    balance += amount;
  }

  /**
   * Decreases balance of the account.
   * @param amount How much is paid out (must be >=0) 
   * @throws AccountException thrown if amount<0.
   */
  public void payOut(double amount) throws AccountException {

    if (amount < 0) {
      throw new AccountException("Negative pay out: " + amount);
    }

    if (balance < amount) {
      throw new AccountException("Amount > balance");
    }
    
    balance -= amount;
  }

  public void info() {
    System.out.println("Account number: " + accountnumber + " Balance: " + balance);
  }
}
