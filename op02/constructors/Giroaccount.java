package op02.constructors;

/**
 * Simple Giro account extending class account
 * 
 * <p>
 * Adaption of class Girokonto from D. Abts
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class Giroaccount extends Account {
  // additional attribute
  private double limit; 

  // constructors
  public Giroaccount(int accountnumber,
                     double balance,
                     double limit) {
    super(accountnumber, balance); // construct superclass  DYNAMISCHE POLYMORPHIE  
                                   // object first
    this.limit = limit; // then proceed with additional
                        // attributes
  }

  // a setter for limit, no getter
  /**
   * Setter for limit.
   * 
   * @param limit must be >=0 otherwise limit is set to 0
   */
  public void setLimit(double limit) {
    if (limit > 0.0) {
      this.limit = limit;
    } else {
      this.limit = 0.0;
    }
  }

  // now we override methods of the superclass
  // in order to adjust the behaviour
  
  @Override  //muss man das schreiben damit die andere fkt payOut überschrieben werden kann!!!
  public void payOut(double amount) {
    double balance = getBalance();
    if (balance - amount >= -limit) {
      balance -= amount;
      setBalance(balance); // method in superclass
    }
  }

  @Override
  public void info() { // super.info(); nur für die superclasse. Für die subclasse ist nur info()!!!
    super.info(); // produce the superclass info
    System.out.println("Limit: " + limit);
  }
}