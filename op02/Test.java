package op02;

/**
 * Example how to use imports.
 * 
 * <p>Adaption of class Test from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

import op02.innerclasses.Account;

public class Test {
  public static void main(String[] args) {
    //op02.constructors.Account acc = new op02.constructors.Account(1234, 1000.); // oder import op02...s.o. Zeile 11
    Account acc = new Account(1234, 1000.);
    acc.info();
  }
}
