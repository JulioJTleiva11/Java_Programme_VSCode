package op05;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * Example how construct to a window with NullLayout.
 * 
 * <p>Adaption of class NullLayoutTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class NullLayoutExample extends JFrame {
  /**
   * Creates a window with two panels.
   */
  public NullLayoutExample() {
    super("NullLayout");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setBackground(Color.white);
    c.setLayout(null); // we do it on our own!

    // creating and placing the contents now
    MyPanel p1 = new MyPanel(1);
    MyPanel p2 = new MyPanel(2);
    p1.setBounds(10, 10, 100, 100);
    p2.setBounds(120, 10, 100, 50);
    c.add(p1);
    c.add(p2);

    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    new NullLayoutExample();
  }
}
