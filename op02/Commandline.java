package op02;

/**
 * A simple class to show how to use command line arguments.
 * 
 * <p>Adaption of class Kommandozeile from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class Commandline {
  /**
   * Arguments from command line are listed. 
   * @param args from command line
   */
  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      System.out.println((i + 1) + ". Parameter: " + args[i]);
    }
  }
}
