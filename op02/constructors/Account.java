package op02.constructors;
/**
 * Simple Account with several constructors
 * 
 * <p>Adaption of class KontoTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class Account {
  // Attributes
  private int accountnumber;  // number of account
  private static int Accountnumber = 1111;  // number of account
  private double balance;     // how much money 
  private String owner; //als beispiel für den Konstruktor
  

  // constructors  STATISCHE POLYMORPHIE bei Konstr.: Mehrfachbelegung von Methodennamen innerhalb einer Klasse
  //siehe Beispiel von Konstruktoren mit mehreren Parameter

  // default constructor must be programmed explicitly 
  // as we have other constructors  
  public Account() { }                                           //   1 default Konstruktor

   public Account(int accountnumber) { // no balance given       //   2
    //this.accountnumber = accountnumber;
    //this.balance = 0.0; // not necessary, 0.0 is default
    this(accountnumber, 0.0, "");//schneller: eine "referenz auf den allgemeinen Konstruktor
  }

  public Account(int accountnumber, double balance) {  //   3 allgmeiner Konstruktor ohne owner
    this.accountnumber = accountnumber;
    this.balance = balance;
   
  }
    public Account(int accountnumber, double balance, String owner) {  //   3 allgmeiner Konstruktor mit owner
    this.accountnumber = accountnumber;
    this.balance = balance;
    this.owner = owner;
  }

  public Account(Account anOther) { // copy constructor           //   4
    //this.accountnumber = anOther.accountnumber; // copy 
    //this.balance       = anOther.balance;       // copy
    //this.owner = anOther.owner;

    //schneller :eine "referenz auf den allgemeinen Konstruktor
    this(anOther.accountnumber, anOther.balance, anOther.owner); // copy von beiden variablen/attributen
  }
    
  

   public Account(double balance, String owner) {
    this.balance = balance;
    this.owner = owner;
  }

  // Getters and Setters
  
  public int getAccountnumber() {
    return accountnumber;
  }

  public void setAccountnumber(int newNumber) {
    //if(newNumber <= 0){
     // return;
   // }else {
      accountnumber = newNumber;
      //accountnumber++;
   //}
 
  }

  /*
  public double getBalance() {
    return balance;
  }

  public void setBalance(double newBalance) {
    balance = newBalance;
  }

  public String getOwner() {
    return owner;
  }
  public void setOwner(String newOwner) {
    owner = newOwner;
  }
  
  
  /*
  public static int getAccountnumber() {
    return accountnumber;
  }

  public static void setAccountnumber(int accountnumber) {
    Account.accountnumber = accountnumber;
    Account.accountnumber++;
  }
   

  public static int generiereNeueKontonu(){
    return accountnumber++;
  }
   */

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
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
        + " Balance: " + balance);
  }

  /*
  public Account createPartnerAccount(Account acc){
    Account result = new Account();
    result.setAccountnumber(acc.getAccountnumber()+1);
    result.payIn(1);
    acc.payOut(1);
    return result;
  }
    */

    /*//beispiel für eine neue Konto inkrementiert
    
  public static void main(String[] args) {
    Account acc10 = new Account(100, "Ymelda Leiva");
    Account acc11 = new Account(70, "Julio Leiva");
    Account acc12 = new Account(10, "Anni");

    System.out.println("Kontonummer: " + Account.generiereNeueKontonu() + " Balance: " + acc10.getBalance() + " Owner: " + acc10.getOwner());
    System.out.println("Kontonummer: " + Account.generiereNeueKontonu() + " Balance: " + acc11.getBalance() + " Owner: " + acc11.getOwner());
    System.out.println("Kontonummer: " + Account.generiereNeueKontonu() + " Balance: " + acc12.getBalance() + " Owner: " + acc12.getOwner());
    //Account.accountnumber??? //von StaticKonstruktor aufgerufen
  }
    */

}


/*
public class KontoGenerator {
  private static int kontonummer = 1000; // Startwert für die Kontonummer
  
  public static int generiereNeueKontonummer() {
      return kontonummer++;
  }

  public static void main(String[] args) {
      // Generiere einige neue Kontonummern
      System.out.println("Neue Kontonummer: " + generiereNeueKontonummer());
      System.out.println("Neue Kontonummer: " + generiereNeueKontonummer());
      System.out.println("Neue Kontonummer: " + generiereNeueKontonummer());
      System.out.println("Neue Kontonummer: " + generiereNeueKontonummer());
  }
}*/