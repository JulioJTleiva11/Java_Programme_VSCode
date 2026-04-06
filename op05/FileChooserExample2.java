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
import javax.swing.filechooser.FileFilter;

/**
 * Another example how to use JFileChoosers.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class FileChooserExample2 extends JFrame
    implements ActionListener {
  private JButton startDialog;
  private JTextArea textArea;

  private class MyFileFilter extends FileFilter {
    // Which files are accepted?
    public boolean accept(File file) {
      // Here we allow all dirs, *.java, *.txt, *tex
      if (file.isDirectory()) {
        return true;
      }
      String fname = file.getName();
      if (fname.endsWith(".java")    //hier wird progrm. dass es nur diese Dateitypen angenommen werden.
          || fname.endsWith(".txt") 
          || fname.endsWith(".tex")) {
        return true;
      }
      return false;
    }
    
    // Gives an Description of the filter for the user 
    public String getDescription() {    //hier wird nur asl Text erscheinen, welche Dateitypen
      return "*.java, *.txt, *.tex"; // explanation
    }
  }

  /**
   * Forces the user to select files repeatedly.
   */
  public FileChooserExample2() {
    super("FileChooser Beispiel 2");
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
  public void actionPerformed (ActionEvent ev) {
    if (ev.getSource() == startDialog) {

      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(".")); 
      //  "." is the current working directory.
  

      fc.setFileSelectionMode(
          JFileChooser.FILES_AND_DIRECTORIES); //gemischt wählen
      // alternatively: FILES_ONLY, DIRECTORIES_ONLY

      // this time we allow multiple selections
      fc.setMultiSelectionEnabled(true);

      // but we set a FileFilter now
      fc.setFileFilter(new MyFileFilter());   //dateityp: *java, *txt

      if (fc.showOpenDialog(this) 
          == JFileChooser.APPROVE_OPTION) { 
    	  // user pressed OK, ie. a selection is approved
        File[] files = fc.getSelectedFiles();    //
        for (File f : files) { // multiple selection!
          String fname = f.getAbsolutePath();
          textArea.setText(textArea.getText() 
        		           + fname + "\n");
        }
      }
    }
  }

  public static void main(String[] args) {
    new FileChooserExample2();
  }
}
