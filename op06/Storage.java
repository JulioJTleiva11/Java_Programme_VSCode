package op06;
/**
 * A FIFO queue implementation with finitely many places.
 * 
 * <p>Implementation uses a cyclic buffer.
 * @author Henning Dierks
 * @version 1.0
 */
public class Storage extends Thread {
  private Object[] queue; // an ordinary array
  private int current;    // number of elements stored
  private int firstOccpd; // 1st occupied place
  private int firstEmpty; // 1st empty place
  public Object lock = new Object(); // something unique
  private ProdConViewer viewer;

  /**
   * Creates a cyclic buffer with n places.
   * @param n is the number of places in the buffer
   */
  public Storage(int n) {
    queue = new Object[n]; // only n places 
    current = 0;    // 0 elements initially
    firstEmpty  = 0;         // where to put the 1st
    firstOccpd = firstEmpty; // where to get the 1st 
    this.viewer = null;
  }

  public boolean isFull() { 
    return current == queue.length; 
  }

  public boolean isEmpty() { 
    return current == 0; 
  }

  /**
   * Gets the next element of the FIFO queue. 
   * @return next object
   */
  public Object get() { 
    Object o =  queue[firstOccpd]; // this is to return
    queue[firstOccpd] = null; // nullify place in queue
    // increase firstOccpd by 1
    firstOccpd = (firstOccpd + 1) % queue.length; 
    current--;         // we lost an element 
    printStorage();    // output 
    if (viewer!=null) viewer.repaint();
    return o; 
  }
  
  /**
   * Add a new element to the FIFO queue.
   * @param o the element to add
   */
  public void put(Object o) {
    queue[firstEmpty] = o;     // place to put 
    // increase firstEmpty by 1
    firstEmpty = (firstEmpty + 1) % queue.length; 
    current++;           // we got a new element
    if (viewer!=null) viewer.repaint();
    printStorage();      // output 
  }

  /**
   * Outputs the content of the FIFO queue.
   */
  public void printStorage() {
    System.out.print("                    [");
    for (int i = 0; i < queue.length; i++) {
      System.out.print(" " + i + ": " + queue[i]);
    }
    System.out.println(" ] first:" + firstOccpd
        + " last:" + firstEmpty
        + " current:" + current);
  }

  public Object at(int index) {
    return queue[index];
  }
  public int getSize() {
    return queue.length;
  }

  public void setViewer(ProdConViewer viewer) {
    this.viewer = viewer;
  }
  
  public int getFirstOccpd() {
    return firstOccpd;
  }

  public int getFirstEmpty() {
    return firstEmpty;
  }

}
