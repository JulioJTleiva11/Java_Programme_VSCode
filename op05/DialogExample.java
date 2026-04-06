package op05;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Example how to use dialogs.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class DialogExample extends JFrame 
    implements ActionListener {
  private JButton startDialog;
  private StringRequestDialog stringDialog;
  private JTextArea textArea;
  private String enteredText;

  /**
   * Queries the user to enter text repeatedly.
   */
  public DialogExample() {
    super("Dialog Example");
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
      stringDialog = new StringRequestDialog(this);

      enteredText = stringDialog.getEnteredText(); 
      System.out.println("Eingabe : "  + enteredText);
      textArea.setText(textArea.getText() 
          + enteredText + "\n");
    }
  }

  public static void main(String[] args) {
    new DialogExample();
  }
}
