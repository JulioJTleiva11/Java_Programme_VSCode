package op05;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class NestedLayoutExample extends JFrame {
  /**
   * Creates a window with nested layouts.
   */
  public NestedLayoutExample() {
    super("Nested Layout");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setBackground(Color.white);
    c.setLayout(new BorderLayout(10, 10));

    // Five panels for all five directions of a BorderLayout
    MyPanel[] myPanels = new MyPanel[5];
    for (int i=0; i<myPanels.length; i++) {
      myPanels[i] = new MyPanel(i);
    }

    // Put panels in the North using a FlowLayout
    myPanels[0].setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
    MyPanel[] northPanels = new MyPanel[3];
    for (int i=0; i<northPanels.length; i++) {
      northPanels[i] = new MyPanel(10+i);   
      northPanels[i].setBackground(Color.yellow);
      myPanels[0].add(northPanels[i]);
    }

    // Put panels in the West using a GridLayout (Exactly 1 column, rows as needed)
    myPanels[1].setLayout(new GridLayout(0,1,5,5)); // 0,1 means X rows and 1 column
    MyPanel[] westPanels = new MyPanel[4];
    for (int i=0; i<westPanels.length; i++) {
      westPanels[i] = new MyPanel(20+i);   
      westPanels[i].setBackground(Color.green);
      myPanels[1].add(westPanels[i]);
    }

    // Put panels in the Center using a GridLayout (Exactly 3 rows, columns as needed)
    myPanels[2].setLayout(new GridLayout(3,0,5,5)); // 3,0 means 3 rows and X columns
    MyPanel[] centerPanels = new MyPanel[20];
    for (int i=0; i<centerPanels.length; i++) {
      centerPanels[i] = new MyPanel(30+i);   
      centerPanels[i].setBackground(Color.blue);
      myPanels[2].add(centerPanels[i]);
    }

    // Put panels in the Center using a GridLayout (Exactly 3 rows and exactly 2 columns)
    myPanels[3].setLayout(new GridLayout(3,2,5,5)); // 3,2 means 3 rows and 2 columns
    MyPanel[] eastPanels = new MyPanel[3*2];
    for (int i=0; i<eastPanels.length; i++) {
      eastPanels[i] = new MyPanel(50+i);   
      eastPanels[i].setBackground(Color.white);
      myPanels[3].add(eastPanels[i]);
    }


    // Put panels in the South using a FlowLayout (aligned to the left)
    myPanels[4].setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
    MyPanel[] southPanels = new MyPanel[8];
    for (int i=0; i<southPanels.length; i++) {
      southPanels[i] = new MyPanel(30+i);   
      southPanels[i].setBackground(Color.red);
      myPanels[4].add(southPanels[i]);
    }



    // now create five panels for all five directions
    c.add(myPanels[0], BorderLayout.NORTH);
    c.add(myPanels[1], BorderLayout.WEST);
    c.add(myPanels[2], BorderLayout.CENTER);
    c.add(myPanels[3], BorderLayout.EAST);
    c.add(myPanels[4], BorderLayout.SOUTH);

    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    new NestedLayoutExample();
  }
}
