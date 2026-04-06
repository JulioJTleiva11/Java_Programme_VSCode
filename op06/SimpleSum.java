package op06;
/**
 * Computing the Gaussian Sum without his famous formula.
 * 
 * <p>Adaption of class SimpleSum from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class SimpleSum {
  private long sum;
  private static final long N = (long) 1E9;
  
  public static void main(String[] args) {
    new SimpleSum().sum();
  }

  /**
   * Computes the sum 1+...+ N.
   */
  public void sum() {
    // Let's go 
    long startTime = System.currentTimeMillis();
    for (long n = 1; n <= N; n++) {
      sum += n;
    }
    long time = System.currentTimeMillis() - startTime;
   
    // outputting the result
    System.out.println("N   : " + N);
    System.out.println("Sum : " + sum);
    System.out.println("Time: " + time);
  }
}


