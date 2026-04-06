package op05;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * Example how to a window with FlowLayout.
 * 
 * <p>Adaption of class FlowLayoutTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class FlowLayoutExample extends JFrame {
  /**
   * Creates a window with five panels.
   */
  public FlowLayoutExample() {
    super("FlowLayout");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setBackground(Color.white);
    // left aligned with gaps (vert. and horiz.)
    c.setLayout(new FlowLayout(FlowLayout.RIGHT, 
                               10, 10));
    
    for (int i = 1; i <= 5; i++) {
      c.add(new MyPanel(i, 80+30*i, 75+25*i));
    }

    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    new FlowLayoutExample();
  }
}
