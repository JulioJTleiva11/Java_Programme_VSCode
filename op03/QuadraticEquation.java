package op03;

/**
 * QuadraticEquation models a quadratic function f(x)=ax^2+bx+c.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

import static java.lang.Math.sqrt;

public class QuadraticEquation {
  private double a;
  private double b;
  private double c;
  
  /**
   * Constructs a quadratic function with the usual 
   * three coefficients.
   * @param a first coefficient (ax^2)
   * @param b second coefficient (bx)
   * @param c third coefficient (c)
   */
  public QuadraticEquation(double a, double b, double c) {
    // f(x) = ax^2 + bx + c
    this.a=a;
    this.b=b;
    this.c=c;
  }

  /**
   * Computes the smaller zero of the function if existent.
   * @return smaller zero
   * @throws ArithmeticException thrown if it is no real 
   *                             quadratic function
   * @throws QuadraticEquationException thrown if no real 
   *                             valued solution exists
   */
  public double firstZero() throws ArithmeticException, QuadraticEquationException {
    if (a == 0) { 
      // this would divide by zero! -> exception
      throw new ArithmeticException("Division by zero is not possible");
    } 
    
    else if (b * b / (4 * a * a) - c / a < 0) { 
      // that means sqrt<0 -> throw exception
      throw new QuadraticEquationException("No real valued solution => complex Solution"); 
    } 
    
    else {
      return -b / (2 * a) - sqrt(b * b / (4 * a * a) - c / a);
    }
  }
}
