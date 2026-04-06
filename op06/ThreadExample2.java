package op06;
/**
 * 2nd simple Example of threading.
 * 
 * <p>Adaption of class ThreadExample2 from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ThreadExample2 // "extends" XYZ
    implements Runnable, GetCounter {

  private int count;
  private int number;
  private static ThreadViewer tv;

  // Constructor
  public ThreadExample2(int number) { 
    this.number = number;
  }

  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {  // what the thread shall do
    // name of thread: we have to use a small trick:
    String name = Thread.currentThread().getName();

    for (int i = 0; i < 10; i++) {
      try {
        // now sleep for 1s plus 0.2s*number
        Thread.sleep(200 * number + 1000);  
      } catch (InterruptedException e) {
        ; // someone interrupts... ok, stop sleeping
      }
      count++; // increase the counter
      tv.update(); // and show it in the viewer
      System.out.println(name + ": " + count);
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
    // create three OBJECTS
    ThreadExample2 o1 = new ThreadExample2(1);
    ThreadExample2 o2 = new ThreadExample2(2);
    ThreadExample2 o3 = new ThreadExample2(3); 
    // now create three THREADS
    Thread t1 = new Thread(o1);
    Thread t2 = new Thread(o2);
    Thread t3 = new Thread(o3,"Willi");

    // Threads are created but not running at the 
    // moment. Waiting for "start" 

    // create the viewer
    tv = new ThreadViewer(new Runnable[] {o1,o2,o3});
    // start all threads now and see what happens
    t1.start(); 
    t2.start();
    t3.start();
    System.out.println("Habe drei Threads gestartet.");
  }


}
