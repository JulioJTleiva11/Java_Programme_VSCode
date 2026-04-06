package op05;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

/**
 * Main class of a small drawing tool with split panes.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class SimpleDrawSplit extends SimpleDraw {
  /**
   * Constructs a window with a drawing area. 
   */
  public SimpleDrawSplit() {
    super("Simple Draw with Split Panes");
    Container cnt = getContentPane(); 
    cnt.setLayout(new FlowLayout());
    // main drawing area 
    DrawingArea drawArea = new DrawingArea(this);
    drawArea.setMinimumSize(new Dimension(200,200));

    // a logging textfield
    logArea = new JTextArea("",10,20);
    logArea.setEditable(false);

    // combobox to select the thickness
    thickness = new JComboBox<String>(
                       new String[] { "1", "2", "3"});
    thickness.setPreferredSize(new Dimension(50,20));

    JSplitPane splitVert 
      = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                       false, drawArea, thickness);
    splitVert.setMinimumSize(new Dimension(200,200));

    JScrollPane scrolledLog = new JScrollPane(logArea);
    scrolledLog.setMinimumSize(new Dimension(200,300));

    JSplitPane splitHoriz 
      = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                       false, splitVert, scrolledLog);
    
    cnt.add(splitHoriz);
 
    pack();

    splitVert.setDividerLocation(0.95); // 95% for draw
    splitHoriz.setDividerLocation(0.8); // 20% for log
    
    setSize(1200,600);
    setVisible(true); // show time!
  }

  public static void main(String[] args) {
    new SimpleDrawSplit();
  }
}

