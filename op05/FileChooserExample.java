package op05;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * An Example how to use JFileChoosers.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class FileChooserExample extends JFrame
    implements ActionListener {
  private JButton startDialog;
  private JTextArea textArea;


  /**
   * Opens a FileChooser dialog.
   */
  public FileChooserExample() {
    super("FileChooser Beispiel");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new FlowLayout());

    startDialog = new JButton("Starte Dialog");
    startDialog.addActionListener(this);
    cnt.add(startDialog);

    textArea = new JTextArea(5,20);
    textArea.setEditable(false);
    cnt.add(new JScrollPane(textArea));

    setSize(400,300);
    setVisible(true);
  }


  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == startDialog) {

      //hier wird die Logik vom Button erstellt
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(".")); //"." -> arbeite da, wo du grad bist
      //  "." is the current working directory.

      fc.setFileSelectionMode(
      JFileChooser.FILES_AND_DIRECTORIES);
      // alternatively: FILES_ONLY, DIRECTORIES_ONLY

      // allow only a single file to be selected
      fc.setMultiSelectionEnabled(false);

      if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
    	  // user pressed OK, ie. a selection is approved
        String fname = fc.getSelectedFile().getAbsolutePath();
        textArea.setText(textArea.getText() + fname + "\n");
      }
    }
  }

  public static void main(String[] args) {
    new FileChooserExample();
  }
}
