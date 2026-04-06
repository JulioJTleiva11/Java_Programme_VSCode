package op05;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Picture viewing tool.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class JTabbedPaneExample extends JFrame
    implements ChangeListener, // when tab changes 
               ActionListener { // react to button       
  private JTabbedPane pane; 
  private JTextArea logArea;
  private JButton load;

  /**
   * Creates a window with tabbed panes showing pictures.
   */
  public JTabbedPaneExample() {
    super("Bildbetrachter");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // creating the tabbed pane
    pane = new JTabbedPane(JTabbedPane.TOP);
    pane.addChangeListener(this); // keep me posted!

    // elements for first tab
    logArea = new JTextArea("",10,20);
    logArea.setEditable(false);
    load = new JButton("Neues Bild laden");
    load.addActionListener(this);

    JSplitPane sp 
    = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,
        new JScrollPane(logArea),
        load);
    sp.setDividerLocation(0.95);

    pane.addTab("Übersicht", sp); // first tab

    add(pane);
    setSize(500,500);
    setVisible(true);
  }

  private void addLog(String msg) {
    logArea.setText(logArea.getText() + "\n" + msg);
  }

  // ActionListener
  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == load) { // button pressed 
      // select a file
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(".")); 
      fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      fc.setMultiSelectionEnabled(true);

      if (fc.showOpenDialog(this) 
          == JFileChooser.APPROVE_OPTION) {
    	// files were selected & approved
        File[] imageFiles = fc.getSelectedFiles();
        for (File anImage : imageFiles) {
          addLog("Gewählt: " + anImage.getAbsolutePath());
          try {
            BufferedImage image = ImageIO.read(anImage);
            ImageIcon icon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(icon);
            pane.addTab(anImage.getName(), // NEW TAB 
                new JScrollPane(imageLabel));
          } catch (IOException ioe) { 
            addLog(" Konnte nicht geladen werden.");
          } catch (NullPointerException npe) { 
            addLog(" Das ist kein Bild.");
          }
        }
      }
    }
  }

  // ChangeListener
  /* (non-Javadoc)
   * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
   */
  public void stateChanged(ChangeEvent ce) { // tab event
    // this does nothing meaningful except reporting 
    int index = pane.getSelectedIndex();
    System.out.println(" Tab " + index);
    addLog(" Tab " + pane.getTitleAt(index) + " gewählt");
  }

  public static void main(String[] args) {
    new JTabbedPaneExample();
  }
}
