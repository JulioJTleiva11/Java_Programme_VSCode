package op02.innerclasses;

/**
 * Simple Account with transactions.
 * 
 * <p>Adaption of class Konto from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class Account {
  // Attributes
  private int accountnumber;  // number of account
  private double balance;     // how much money 
  private Transaction last;   // Attribut for class transaction

  // constructor

  public Account(int accountnumber, double balance) {
    this.accountnumber = accountnumber;
    this.balance = balance;
  }

  public class Transaction { // Inner class Transaction
    private String name;
    private double amount;

    public Transaction(String name, double amount) {
      this.name = name;
      this.amount = amount;
    }

    public String toString() {
      //return accountnumber + ": " + name + " " + amount 
      //    + ", Balance " + balance + " LastTransaktion: " + last;
      return " LastTransaktion: " + last;
    }
  } // End of inner class Transaction

  // Getters and Setters
  public int getAccountnumber() {
    return accountnumber;
  }

  public void setAccountnumber(int newNumber) {
    accountnumber = newNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double newBalance) {
    balance = newBalance;
  }

  public Transaction getLast() {
    return last;
  }

  // Methods
  /**
   * Increase balance of the account.
   * @param amount How much money is paid in 
   */
  public void payIn(double amount) { 
    balance += amount;
    last = new Transaction("Pay in ",amount);
  }

  /**
   * Decrease balance of the account.
   * @param amount How much money is paid out
   */
  public void payOut(double amount) {
    balance -= amount;
    last = new Transaction("Pay out",amount);
  }

  public void info() {
    System.out.println("Account number: " + accountnumber 
        + " Balance: " + balance + " LastTransaktion : " + last.toString());
  }
}
 