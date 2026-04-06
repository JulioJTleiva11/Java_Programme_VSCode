package op06;
/**
 * 4th simple Example of threading.
 * 
 * <p>Adaption of class ThreadExample4 from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ThreadExample4 extends Thread
    implements GetCounter {

  private int count;
  private static ThreadViewerWithBars tv;
  private static final long limit = 100000000;
  private static final int noOfThreads = 30;

  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {  // what the thread shall do
    // name of thread: we have to use a small trick:
    String name = Thread.currentThread().getName();

    for (int i = 0; i < limit; i++) {
      // this time we don't sleep
      double x = 2; // doing complicated USELESS stuff
      for (int j = 0; j < 1000; j++) { 
        x += Math.sin(x);
      } 
      // now we increase the counter by 1 as before :-)
      count = count + (int)((x * x+0.5) / Math.abs(x * x));
      tv.update(); // and show it in the viewer

    }
    // we finished the task 
    System.out.println(name + ": Ich bin fertig!");
  }

  // Interface getCounter
  @Override
  public int getCounter() {
    return count;
  }

  /**
   * Creates some threads and starts them.
   * @param args not used here
   */
  public static void main(String[] args) {
    ThreadExample4[] 
      threads = new ThreadExample4[noOfThreads];

    final int min = Thread.MIN_PRIORITY;
    final int range = Thread.MAX_PRIORITY - min + 1; 
    
    for (int i = 0; i < threads.length; i++) {
      // small index -> high priority
      int prio = min + i * range / noOfThreads; 
      threads[i] = new ThreadExample4();
      threads[i].setPriority(prio);
    }

    // Threads are created but not running at the 
    // moment. Waiting for "start" 

    // create the viewer
    tv = new ThreadViewerWithBars(threads,limit);
    // start all threads now and see what happens

    for (int i=threads.length-1; i>=0; i--)
      threads[i].start();

    System.out.println("Habe " + threads.length 
        + " Threads gestartet.");
  }
}
