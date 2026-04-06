package op03;

/**
 * QuadraticEquationAlternative models a quadratic 
 * function f(x)=ax^2+bx+c.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

import static java.lang.Math.sqrt;


public class QuadraticEquationAlternative {
  private double a;
  private double b;
  private double c;

  /**
   * Constructs a quadratic function with the usual 
   * three coefficients.
   * 
   * @param a 1st coefficient (ax^2)
   * @param b 2nd coefficient (bx)
   * @param c 3rd coefficient (c)
   */
  public QuadraticEquationAlternative(double a, double b, double c) { // f(x) = ax^2 + bx + c
    this.a=a;
    this.b=b;
    this.c=c;
  }

  /**
   * Computes the smaller zero of the function if existent
   * @return smaller zero
   * @throws QuadraticEquationException thrown if no real 
   *     valued solution exists
   *     or the function is not a real quadratic function
   */
  public double firstZero() throws QuadraticEquationException { // no ArithmeticException anymore!
    try {
      double p = b / a; // ArithmeticException, if a==0 
      double q = c / a; // ArithmeticException, if a==0 

      if (p * p / 4 - q < 0) {
        throw new QuadraticEquationException("No real valued solution");
      } 
      else {
        return -p / 2 - sqrt(p * p / 4 - q);
      }
    } 
    
    catch (ArithmeticException arithmException) {
      // we throw another exception instead which is 
      // more meaningful here)  
      throw new QuadraticEquationException("This is not a proper quadratic function");
    }
  }
}

