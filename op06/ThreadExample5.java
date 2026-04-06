package op06;

import java.util.Random;

/**
 * 5th simple Example of threading.
 * 
 * <p>Adaption of class ThreadExample5 from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ThreadExample5 extends Thread 
    implements GetCounter {

  private int count;
  private static Random rnd = new Random();
  private static ThreadViewerWithBars tv;
  private static final long limit = (long) 1E8;
  private static final int noOfThreads = 31;
  private Thread toWaitFor; // I am waiting for this one
 
  public void setToWaitFor(Thread toWaitFor) {
    this.toWaitFor = toWaitFor;
  }

  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {  // what the thread shall do
    // name of thread: we have to use a small trick:
    String name = Thread.currentThread().getName();

    if (toWaitFor != null) {
      try {
        tv.update();
        toWaitFor.join(); // now I'm waiting for this 
      } catch (InterruptedException ie) {
        // someone interrupted me... ok ... let's go
      }
    }
    System.out.println(name + " legt jetzt los!");
    for (int i = 0; i < limit; i++) {
      // this time we don't sleep
      // instead we execute useless computations	
      double d = rnd.nextDouble(); 
      if (Math.sin(d)*Math.sin(d)
    	 +Math.cos(d)*Math.cos(d)>0.9) {
        count++; // increase the counter
      }
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
    ThreadExample5[] 
      threads = new ThreadExample5[noOfThreads];

    for (int i = 0; i < threads.length; i++) {
      threads[i] = new ThreadExample5();
      if (i > 0) {
        threads[i].setToWaitFor(threads[(i - 1) / 2]);
      }
       threads[i].setName("Thread "+i);
    }

    // Threads are created but not running at the 
    // moment. Waiting for "start" 

    // create the viewer
    tv = new ThreadViewerWithBars(threads,limit);
    // start all threads now and see what happens
    for (Thread thr : threads) {
      thr.start();
    }
    System.out.println("Habe " 
                       + threads.length 
                       + " Threads gestartet.");
  }

}
