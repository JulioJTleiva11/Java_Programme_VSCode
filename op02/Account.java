package op02;

/**
 * Simple Account.
 * 
 * <p>Adaption of class KontoTest from D. Abts
 * @author Henning Dierks
 * @version 1.1
 */

public class Account {
  // Attributes
  private int accountnumber;  // number of account
  private double balance;     // how much money 
  private Transaktion last; // Attribut für die innere InstanzKlasse

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

  public Transaktion getLast(){  //Getter für das Attribut FÜR die innere InstanzKlasse
    return last;
  }
  
    //Innere InstanzKlasse PUBLIC  WichtigInnereKlassePublic: Attribute, Konstruktor, Methoden IN DER KLASSE!!! 
    // die Attribute FÜR die neue KLasse getter/Setter außerhalb!!!
    public class Transaktion {
      //Attribute
      private String name;
      private double amount;

      //Konstruktor
      public Transaktion (String name, double amount){
        this.name = name;
        this.amount = amount;
      }

      //Methode toString()
      public String toString(){ //WichtigReturnString+Value
        return "Transaktion: " + name + " Amount: " + amount; //Weitere Anpassung in der Methode info() siehe unten
      }
    }


  // Methods
  /**
   * Increase balance of the account.
   * @param amount How much money is paid in 
   */
  public void payIn(double amount) { 
    balance += amount;
  }

  /**
   * Decrease balance of the account.
   * @param amount How much money is paid out
   */
  public void payOut(double amount) {
    balance -= amount;
  }

  public void info() {
    System.out.println("Account number: " + accountnumber 
        + " Balance: " + balance + " Last Transaktion: " + last.toString());
  }
}
