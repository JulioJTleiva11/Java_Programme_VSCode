package op06;
/**
 * Creates a system of producers, consumer and a storage. 
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class ProdCons  {
  private static final int N = 1;      // no of actors
  private static final int SPACE = 10; // size storage
  private static ProdConViewer viewer;

  /**
   * Create N producers and consumer using a 
   * common storage of size SPACE.
   * @param args not used here
   */
  public static void main(String[] args) {
    Producer[] prods = new Producer[N];
    Consumer[] cons  = new Consumer[N*3];
    Storage s = new Storage(SPACE); // one storage only
    viewer = new ProdConViewer(s,prods,cons);
    s.setViewer(viewer);

    // creating actors
    for (int i = 0; i < prods.length; i++) {
      prods[i] = new Producer(s);
    }
    for (int i = 0; i < cons.length; i++) {
      cons[i]  = new Consumer(s);
    }

    // starting all actors
    for (Producer p : prods) { 
      p.start();
    }
    for (Consumer c : cons) {
      c.start();
    }
  }

  public void update() {
    if (viewer!=null) {
      viewer.repaint();
    }
  }
}
