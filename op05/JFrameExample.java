package op05;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;

/**
 * Example how to create a window and open it.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
class JFrameExample {
  /**
   * Opens a simple JFrame and plays a bit with 
   * this window. 
   * @param args not used here
   */
  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    try { // sleep might throw an exception
      Thread.sleep(3000); 

      window.setVisible(true); // now it is visible!
      Thread.sleep(3000);
      // resize it
      window.setSize(new Dimension(600,400));
      Thread.sleep(3000);
      // assign a new position
      window.setLocation(new Point(100,100));
      Thread.sleep(3000);
      // change the title
      window.setTitle("Jetzt habe ich einen Titel");
      Thread.sleep(15000);
      // now we don't allow to resize it by the user
      window.setResizable(false);
      window.setTitle("Resizen geht jetzt nicht mehr!");
      Thread.sleep(5000);
      // now use the whole screen
      window.setSize(window.getToolkit().getScreenSize());
      window.setLocation(new Point(0,0));
      window.setTitle("Ganzer Bildschirm!");
      Thread.sleep(10000);
    } catch (InterruptedException e) { // ignore
    }
    window.setVisible(false); // hide the window
    System.exit(0);
  }
}
