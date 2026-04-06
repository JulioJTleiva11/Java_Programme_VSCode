package op06;
import java.util.Random;

/**
 * A class that produces numbers and stick them into the storage queue.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class Producer extends Thread {

  private Storage storage; // Vitrine, the storage to put into
  private Integer secret;  //baget

  public Producer(Storage storage) {
    this.storage = storage;
  }

  /* (non-Javadoc)
   * @see java.lang.Thread#run()
   */
  public void run() {
    Random random = new Random();
    try {
      while (true) {  // do forever
        // choose a number: an artificial product
        secret = (Integer) random.nextInt(1000);
        System.out.println("Prod : " 
                           + secret + " generated");
        sleep(300 + random.nextInt(1000)); // wait >1sec
        synchronized (storage.lock) {  // danger zone
          while (storage.isFull()) { // if full then wait
            storage.lock.wait();      // warten wenn es voll ist.
          }
          // now there is at least one empty place
          storage.put(secret);   // send "product"
          secret = null;
          storage.lock.notify(); // giving back the lock 
        }
      }
    } catch (InterruptedException ie) { 
      ; // nobody should interrupt our sleep...
    }
  }

  public Object getSecret() {
    return secret;
  }
} 
