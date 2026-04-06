package op05;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Dialog that asks the user to enter a text.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class StringRequestDialog extends JDialog
    implements ActionListener {
  private String enteredText = "";
  private JTextField textField = null;

  public String getEnteredText() { 
    return enteredText; 
  }

  /**
   * Creates a simple dialog requesting a string.
   * @param owner the JFrame that starts this dialog.
   */
  public StringRequestDialog(JFrame owner) {
    super(owner,"Texteingabe",true); // modal!

    setLocationRelativeTo(owner);
    
    // watch the following line!
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
    Container cnt = getContentPane();
    cnt.setLayout(new FlowLayout());

    textField = new JTextField(20);
    textField.addActionListener(this);
    cnt.add(textField);

    setSize(300,50);
    setVisible(true);
  }

  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == textField) {
      enteredText = textField.getText();
      dispose(); // closes dialog!
    }
  }
}

