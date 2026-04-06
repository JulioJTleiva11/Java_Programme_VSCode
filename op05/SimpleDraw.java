package op05;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Main class of a small drawing tool.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class SimpleDraw extends JFrame {
  protected JComboBox<String> thickness; 
  protected JTextArea logArea; 

  /**
   * Constructs a window with a drawing area. 
   */
  public SimpleDraw() {
    super("Simple Draw");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new BorderLayout());
    // put the main drawing area in the center
    cnt.add(new DrawingArea(this),BorderLayout.CENTER);

    // add a combobox to select the thickness
    thickness = new JComboBox<String>(
                       new String[] { "1", "2", "3"});
    thickness.setPreferredSize(new Dimension(50,20));
    thickness.setMaximumSize(new Dimension(50,20));
    cnt.add(thickness,BorderLayout.SOUTH);
    
    // add a logging textfield
    logArea = new JTextArea("",10,20);
    logArea.setEditable(false);
    cnt.add(new JScrollPane(logArea),BorderLayout.EAST);

    pack();
    setSize(1200,600);
    setVisible(true); // show time!
  }
  
  // for subclasses only: put nothing into the frame
  public SimpleDraw(String title) {
    super(title);
  }

  public void addLog(String msg) {
    logArea.setText(logArea.getText() + "\n" + msg);
  }

  /**
   * Returns the thickness the user selected.
   * @return current thickness
   */
  public int getThickness() {
    if (thickness != null) {
      return thickness.getSelectedIndex() + 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    new SimpleDraw();
  }
}

