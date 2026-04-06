package op05;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessageDialogExample extends JFrame 
implements ActionListener {
  private JButton startDialog;
  private int counter = 0;

  /**
   * Show all kinds of message dialogs.
   */
  public MessageDialogExample() {
    super("MessageDialog Example");
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
    if (ev.getSource() == startDialog) {
      switch (counter) {
        case 0: 
          JOptionPane.showMessageDialog(this, "Test",
              "ERROR_MESSAGE", 
              JOptionPane.ERROR_MESSAGE);
          counter++;
          break;
        case 1: 
          JOptionPane.showMessageDialog(this, "Test",
              "INFORMATION_MESSAGE", 
              JOptionPane.INFORMATION_MESSAGE);
          counter++;
          break;
        case 2: 
          JOptionPane.showMessageDialog(this, "Test",
              "WARNING_MESSAGE", 
              JOptionPane.WARNING_MESSAGE);
          counter++;
          break;
        case 3: 
          JOptionPane.showMessageDialog(this, "Test",
              "QUESTION_MESSAGE", 
              JOptionPane.QUESTION_MESSAGE);
          counter++;
          break;
        case 4: 
          JOptionPane.showMessageDialog(this, "Test",
              "PLAIN_MESSAGE", 
              JOptionPane.PLAIN_MESSAGE);
          counter++;
          break;
        default:
          System.exit(0);
      }
    }
  }

  public static void main(String[] args) {
    new MessageDialogExample();
  }
}