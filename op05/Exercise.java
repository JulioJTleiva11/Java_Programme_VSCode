package op05;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class Exercise extends JFrame

{


  private JSplitPane splitPane;
  private JTabbedPane tabbedPaneLeft;
  private JTabbedPane tabbedPaneRight;

  public Exercise() {
    super("Übung");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();

    
    tabbedPaneLeft =new JTabbedPane();
    tabbedPaneRight =new JTabbedPane();
       
    for (int i=0; i<5; i++) {
      tabbedPaneLeft.addTab("L"+i, new MyPanel(i));
      tabbedPaneRight.addTab("R"+i, new MyPanel(i+5));
         }
    
    
    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,
        tabbedPaneLeft,
        tabbedPaneRight
        );
    tabbedPaneLeft.setMinimumSize(new Dimension(200,200));
    tabbedPaneRight.setMinimumSize(new Dimension(200,200));
    
    splitPane.setMinimumSize(new Dimension(800,400));
    setMinimumSize(new Dimension(900,450));
    cnt.add(splitPane);
    
    pack();
    setSize(900,450);
    setVisible(true);
    
    
  }
  
  public static void main(String[] args) {
    new Exercise();
  }

}