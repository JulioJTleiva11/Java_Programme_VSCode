package op05;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

/**
 * Example how to a window with GridBagLayout.
 * 
 * <p>Adaption of class GridBagLayoutTest from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class GridBagLayoutExample extends JFrame {
  /**
   * Creates a window with quite a complicated layout.
   */
  public GridBagLayoutExample() {
    super("GridBagLayout");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setBackground(Color.white);

    // now create 10 panels 
    MyPanel[] p = new MyPanel[10];
    for (int i = 0; i < p.length; i++) {
      p[i] = new MyPanel(i + 1,0,0);  // no dimensions
    }

    GridBagLayout gridbag = new GridBagLayout();
    gridbag.columnWidths // 3 columns
      = new int[] { 300, 200, 150 };
    gridbag.rowHeights   // 6 rows
      = new int[] { 100, 100, 200, 200, 100, 100 };
    c.setLayout(gridbag);

    // now placing the panels using my "addPanel"
    //                      c  r  w  h
    addPanel(gridbag, p[0], 2, 0, 1, 1);
    addPanel(gridbag, p[1], 0, 1, 1, 1);
    addPanel(gridbag, p[2], 1, 1, 1, 1);
    addPanel(gridbag, p[3], 2, 1, 1, 1);
    addPanel(gridbag, p[4], 0, 2, 1, 2);
    addPanel(gridbag, p[5], 1, 2, 2, 1);
    addPanel(gridbag, p[6], 1, 3, 2, 1);
    addPanel(gridbag, p[7], 1, 4, 1, 1);
    addPanel(gridbag, p[8], 2, 4, 1, 1);
    addPanel(gridbag, p[9], 0, 5, 3, 1);
    
    pack(); // organise placement
    setVisible(true); // show time!
  }

  /**
   * Method that add a panel to a GridBagLayout.
   * @param gridbag the gridbag to add to
   * @param p the panel to add
   * @param x the column
   * @param y the row
   * @param w how many columns the panel spans
   * @param h how many rows the panel spans
   */
  private void addPanel(GridBagLayout gridbag, 
      MyPanel p, 
      int x, int y,
      int w, int h) {
    GridBagConstraints constr = new GridBagConstraints();
    constr.insets = new Insets(2, 2, 2, 2); // gaps
    constr.gridx = x;
    constr.gridy = y;
    constr.gridwidth = w;
    constr.gridheight = h;
    // grow in both directions (horiz. and vert.)
    constr.fill = GridBagConstraints.BOTH;
    if (x == 1) { // column 1 only column to grow
      constr.weightx = 1;
    } else {
      constr.weightx = 0;
    }
    constr.weighty = 1; // all rows want to grow
    // now set these constraint for the panel p
    gridbag.setConstraints(p, constr); 
    // and add it to the JFrame.
    add(p);
  }

  public static void main(String[] args) {
    new GridBagLayoutExample();
  }
}
