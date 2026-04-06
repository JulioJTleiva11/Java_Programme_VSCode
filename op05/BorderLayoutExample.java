package op05;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * Example how to a window with BorderLayout.
 * 
 * <p>Adaption of class BorderLayoutTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class BorderLayoutExample extends JFrame {
  /**
   * Creates a window with five panels.
   */
  public BorderLayoutExample() {
    super("BorderLayout");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setBackground(Color.white);
    c.setLayout(new BorderLayout(10, 10));

    // now create five panels for all five directions
    c.add(new MyPanel(1,200,200), BorderLayout.NORTH);
    c.add(new MyPanel(2,200,200), BorderLayout.WEST);
    c.add(new MyPanel(3,200,200), BorderLayout.CENTER);
    c.add(new MyPanel(4,200,200), BorderLayout.EAST);
    c.add(new MyPanel(5,200,200), BorderLayout.SOUTH);

    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    new BorderLayoutExample();
  }
}
