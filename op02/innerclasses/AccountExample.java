package op02.innerclasses;
/**
 * Example how to use class Account.
 * 
 * <p>Adaption of class KontoTest from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class AccountExample {
  /**
   * Creates an account and uses transactions.
   * @param args not used here
   */  
  public static void main(String[] args) {
    Account acc = new Account(4711, 1000.);
    Account acc2 = new Account(7771, 7007.);

    acc.payIn(500.);
    acc.payOut(700.);

    acc2.payIn(7.0);
    acc2.payOut(13.0);

    //äußereKlasse.InnereKlasse nameObj = 
    //Account.Transaction t1 = acc1.getLast();
    //System.out.println(t1.toString());


    Account.Transaction t = acc.getLast();
    System.out.println(t.toString());
    
    t = acc2.getLast();
    System.out.println(t.toString());

  }
}
