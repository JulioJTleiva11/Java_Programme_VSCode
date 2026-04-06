package op03;

/**
 * Example for the effects of a finally-statement.
 * 
 * <p>Adaption of class FinallyTest from D. Abts
 * @author Henning Dierks
 * @version 1.0 
 */

public class FinallyExample {

  /**
   * Creates an account and executes four tests.
   * @param args not used here
   */  
  public static void main(String[] args) {
    try {
      Account acc = new Account(4711, 500);
      for (int i = 0; i <= 3; i++) {
        test(acc,i);
      }
    } catch (AccountException accException) {
      System.out.println(accException);
    }
  }

  /**
   * Executes one of four tests observing the 
   * behavior of the finally-statement.
   * @param testnumber number of test (0-3)
   */
  public static void test(Account acc, int testnumber) { //WichtigSwitchExceptionFinally
    System.out.println();
    System.out.println("BEGIN STEP  " + testnumber);

    try {
      switch (testnumber) {
      case 1: // OK, no exception
        acc.payIn(100);
        break;
      case 2: // Exception (caught)
        acc.payOut(700);
        break;
      case 3: // Exception (not caught)
        acc.payOut(200 / 0);
        break;
      default: // includes 0
        return;
      }
    } catch (AccountException accException) {
      System.out.println(accException);
    } finally { // ALWAYS do this:
      System.out.println("Output in finally block: "
          + acc.getBalance());
    }

    System.out.println("END OF STEP " + testnumber);
    System.out.println();
  }
}
