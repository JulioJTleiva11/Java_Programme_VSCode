package op05;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConfirmDialogExample extends JFrame  
    implements ActionListener {
  private JButton startDialog;
  private int counter = 0;

  /**
   * Create a series of confirming dialogs.
   */
  public ConfirmDialogExample() {
    super("ConfirmDialog Beispiel");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new FlowLayout());

    startDialog = new JButton("Starte Dialog");
    startDialog.addActionListener(this);
    cnt.add(startDialog);

    setSize(400,300);
    setVisible(true);
  }


  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed (ActionEvent ev) {
    int result = -1;
    if (ev.getSource() == startDialog) {
      switch (counter) {
        case 0: 
          result = JOptionPane.showConfirmDialog(this, 
            "Test",
            "YES_NO_OPTION",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
          counter++;
          break;
        case 1: 
          result = JOptionPane.showConfirmDialog(this, 
            "Test",
            "YES_NO_CANCEL_OPTION",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.ERROR_MESSAGE);
          counter++;
          break;
        case 2: 
          result = JOptionPane.showConfirmDialog(this, 
            "Test",
            "OK_CANCEL_OPTION",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.ERROR_MESSAGE);
          counter++;
          break;
        default:
          System.exit(0);
      }
      System.out.println("Ausgabe : ");
      switch (result) {
        case JOptionPane.YES_OPTION: 
          // ODER: case JOptionPane.OK_OPTION: 
          System.out.println("OK bzw. YES"); 
          break;
        case JOptionPane.NO_OPTION: 
          System.out.println("NO"); 
          break;
        case JOptionPane.CANCEL_OPTION: 
          System.out.println("CANCEL"); 
          break;
        default:
          break;
      }
    }
  }

  public static void main(String[] args) {
    new ConfirmDialogExample();
  }
}
