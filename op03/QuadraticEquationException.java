package op03;

/**
 * Exception for class QuadraticEquation.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

public class QuadraticEquationException extends Exception {

  public QuadraticEquationException() {
    // exception with no explanation 
  }

  public QuadraticEquationException(String message) {
    super(message); // with explanation in message
  }
}
