package op05;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class GridLayoutExample extends JFrame {
  /**
   * Creates a window with thirteen panels.
   */
  public GridLayoutExample(int rows, int cols) {
    super("GridLayout with (rows,cols)=("
          + rows + "," + cols + ")");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setBackground(Color.white);
    c.setLayout(new GridLayout(rows,cols,10, 10));//

    // now create thirteen panels 
    for (int i=1; i<=13; i++) {
      c.add(new MyPanel(i,i*20,i*20));
    }
		
    setSize(800, 400);
    setVisible(true);
  }

  public static void main(String[] args) {
    new GridLayoutExample(3,5); // fits well
    new GridLayoutExample(2,0); // 2 rows, cols as needed
    new GridLayoutExample(0,2); // 2 cols, rows as needed
    new GridLayoutExample(2,2); // too small
    new GridLayoutExample(5,5); // too large
    new GridLayoutExample(0,0); // what?
  }
} 
