package op06;
/**
 * Computing the Gaussian Sum without his famous formula.
 * 
 * <p>Adaption of class ConcurrentSum from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ConcurrentSum {
  private static final int T = 4; // je mehr trheads, sollte es schneller werden
  private static final long N = (long) 4E9; // den Wert zu rechnen 4 000 000 000 
  private long sum;
  private Thread[] threads = new Thread[T];

  public static void main(String[] args) {
    new ConcurrentSum().sum();
  }

  /**
   * Computes the sum 1+...+ N.
   */
  public void sum() {
    // Let's go 
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < T; i++) {
      // split the sum into T many parts
      final long start =    (i  * N) / T+1;
      final long end   = ((i+1) * N) / T;

      threads[i] = new Thread() {
        public void run() {
          long threadsum = 0; // local sum of thread 
          for (long n = start; n <= end; n++) {
            // now do this with synchronisation
            threadsum += n;
          }
          // we summed up N/T numbers locally
          // now add to global sum SYNC'ED
          synchronized (ConcurrentSum.class) {
            sum += threadsum; 
          }
        }
      };
      threads[i].start();
    }

    // Waiting for all threads to finish
    for (int i = 0; i < T; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        ; // nobody should interrupt us: Do nothing
      }
    }
    // Now all threads finished their jobs

    long time = System.currentTimeMillis() - startTime;

    // outputting the result
    System.out.println("N   : " + N);
    System.out.println("Sum : " + sum);
    System.out.println("Time: " + time);
  }
}


