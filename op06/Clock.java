package op06;
import java.io.IOException;

/**
 * Very simple clock: prints time every second to console.
 * 
 * <p>Adaption of class Zeitanzeige from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class Clock implements Runnable {
  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  public void run() {
    boolean stop = false;
    while (!stop) { // loop until "ring-ring"
      System.out.println(new java.util.Date());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        stop = true; // ring-ring!
      }
    }
  }

  /**
   * Starts a clock and waits for RETURN to interrupt 
   * the clock thread.
   * 
   * @param args not used here
   */
  public static void main(String[] args) {
    Clock time = new Clock();
    Thread timethread = new Thread(time);
    timethread.start();

    try {
      System.in.read(); // waits for key <RETURN>
    } catch (IOException e) {
      e.printStackTrace();
    } 

    timethread.interrupt(); // interrupt the thread 
  }
}
