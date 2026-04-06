package op06;
/**
 * 3rd simple example of threading.
 * 
 * <p>Adaption of class ThreadExample3 from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ThreadExample3 // "extends" XYZ
    implements Runnable {

  private int count;
  private int limit = 10;

  public void setLimit(int limit) {
    this.limit = limit;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {  // what the thread shall do
    // name of thread: we have to use a small trick:
    String name = Thread.currentThread().getName();

    for (int i = 0; i < limit; i++) {
      try {
        // now sleep for 1s
        Thread.sleep(1000);  
      } catch (InterruptedException e) {
        ; // someone interrupts... ok, stop sleeping
      }
      count++; // increase the counter
      System.out.println(name + ": " + count);
    }
    // we finished the task 
    System.out.println(name + ": Ich bin fertig!");
  }

  /**
   * Creates some threads and starts them.
   * @param args not used here
   */
  public static void main(String[] args) {
    // create three OBJECTS
    ThreadExample3 o1 = new ThreadExample3();
    ThreadExample3 o2 = new ThreadExample3();
    ThreadExample3 o3 = new ThreadExample3(); // Daemon
    o3.setLimit(1000);
    // now create three THREADS
    Thread t1 = new Thread(o1);
    Thread t2 = new Thread(o2);
    Thread t3 = new Thread(o3,"Dämon");
    t3.setDaemon(true); // t3 is a daemon now!

    // Threads are created but not running at the 
    // moment. Waiting for "start" 

    // start all threads now and see what happens
    t1.start(); 
    t2.start();
    t3.start();
    System.out.println("Habe drei Threads gestartet.");
  }


}
