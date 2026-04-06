package op06;

import java.util.Random;

/**
 * A class that produces numbers and stick them into the storage queue.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class Consumer extends Thread {

  private Storage storage; // the storage to fetch from
  private Object obj;

  public Consumer(Storage storage) {
    this.storage = storage;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Thread#run()
   */
  public void run() {
    Random random = new Random();

    try {
      while (true) {
        sleep(1000 + random.nextInt(2000));
        obj = null;
        synchronized (storage.lock) { // danger zone
          // wait as long as storage is empty
          while (storage.isEmpty()) {
            storage.lock.wait();
          }
          // now it is not empty anymore
          obj = storage.get(); // "consume" a "product"
          storage.lock.notify(); // giving back the lock
        }
        System.out.println("   Cons : "
            + obj + " received");
      }
    } catch (InterruptedException ie) {
      ; // nobody should interrupt our sleep
    }
  }

  public Object getObject() {
    return obj;
  }
}
