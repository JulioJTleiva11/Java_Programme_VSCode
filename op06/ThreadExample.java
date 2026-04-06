package op06;
/**
 * Simple Example of threading.
 * 
 * <p>Adaption of class ThreadExample from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ThreadExample  extends Thread 
    implements GetCounter {

  private int count;
  private int number;
  private static ThreadViewer tv;

  // Constructors
  public ThreadExample(String name, int number) { 
    super(name); // constructor of thread
    this.number = number;
  }
  
  public ThreadExample(int number) { 
    // uses super() implicitly!
    this.number = number;
  }

  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {  // what the thread shall do
    String name = getName(); // name of thread

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
    // create three threads
    // threads without name
    ThreadExample t1 = new ThreadExample(1);
    ThreadExample t2 = new ThreadExample(2);
    // named thread
    ThreadExample t3 = new ThreadExample("Willi",3); 
    
    // Threads are created but not running at the 
    // moment. Waiting for "start" 
    
    // create the viewer
    tv = new ThreadViewer(new Runnable[] {t1,t2,t3});
    // start all threads now and see what happens
    t1.start(); 
    t2.start();
    t3.start();
    System.out.println("Habe drei Threads gestartet.");
  }
}
