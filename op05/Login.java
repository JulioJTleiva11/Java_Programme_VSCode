package op05;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Login extends JFrame
    implements ActionListener {
  private JTextField login;
  private JLabel msg1;
  private JLabel msg2;
  private JLabel msg3;
  private JPasswordField pw1;
  private JPasswordField pw2;
  private JTextArea comment;
  private JButton ok;

  /**
   * Creates a login window with several checks.
   */
  public Login() {
    super("Pseudo-Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new GridLayout(12,1,0,0)); //ich brauche 12 zeile 1 spalte

    // Login field plus labels
    c.add(new JLabel("Login:"));  // für den Text
    login = new JTextField(30); // width: 30 letters 
    login.setInputVerifier(new InputVerifier() {  // ein obkjekt übergeben der klasse new InputVerifier(), das ist eine anonyme Klasse
      public boolean verify(JComponent input) {
        // just call a dedicated method to check 
        return loginIsLongEnough(input,6,msg1); 
      }
    });
    c.add(login); // add to window
    login.addActionListener(this); // keep me informed
    msg1 = new JLabel("Bitte mindestens 6 Zeichen");
    c.add(msg1); // add message label to window

    // Password field plus labels 
    c.add(new JLabel("Passwort:"));
    pw1 = new JPasswordField(30); // width: 30 letters
    pw1.setInputVerifier(new InputVerifier() {
      public boolean verify(JComponent input) {
        // just call a dedicated method to check 
        return loginIsLongEnough(input,8,msg2);
      }
    });
    c.add(pw1); // add to window
    pw1.addActionListener(this); // keep me informed
    msg2 = new JLabel("Mindestens 8 Zeichen");
    c.add(msg2); // add message label to window

    // Password repetition field plus labels 
    c.add(new JLabel("Passwort (Wiederholung):"));
    pw2 = new JPasswordField(30); // width: 30 letters
    pw2.setInputVerifier(new InputVerifier() {
      public boolean verify(JComponent input) {
        // just call a dedicated method to check 
        return pwdsAreEqual(); 
      }
    });
    c.add(pw2); // add to window
    pw2.addActionListener(this); // keep me informed
    msg3 = new JLabel("Muss übereinstimmen");
    c.add(msg3); // add message label to window

    // comment field plus label
    c.add(new JLabel("Kommentar:"));
    // width: 30 letters & height: 5 lines
    comment = new JTextArea(30,5); 
    comment.setText("Haben Sie einen Kommentar?");
    c.add(comment);

    // adding OK button
    ok = new JButton("Fertig");
    ok.addActionListener(this);
    c.add(ok);

    pack(); // organise contents
    setSize(400,600);
    setVisible(true); // show time
  }

  /**
   * Checks if passwords are equal.
   * @return true if and only if passwords are equal
   */
  private boolean pwdsAreEqual() {
    char[] p1 = pw1.getPassword();
    char[] p2 = pw2.getPassword();
    if (Arrays.equals(p1, p2))  {
      msg3.setText("");
      Arrays.fill(p1, ' '); // erase passwords in memory
      Arrays.fill(p2, ' ');
      return true;
    } else {
      msg3.setText("Passwörter stimmen nicht überein!");
      Arrays.fill(p1,  ' '); // erase passwords in memory
      Arrays.fill(p2,  ' ');
      pw1.setText(""); // clear both password fields
      pw2.setText("");
      pw1.requestFocus(); // cursor to first pw field
      msg2.setText("Mindestens 8 Zeichen");
      return false;
    }
  }

  /**
   * Checks whether the input text is sufficiently long.  
   * @param input the component (a text field) to read from  
   * @param min the minimal length required
   * @param msg the JLabel to output the message 
   * @return true if and only if length of text is at least min letters
   */
  private boolean loginIsLongEnough(JComponent input, 
                                    int min, 
                                    JLabel msg) {
    if (input instanceof JTextComponent) {

      String attempt = ((JTextComponent)input)
                       .getText().trim();//trim() ist damit die Leerzeichen weg sind
      if (attempt.length() < min) {
        msg.setText("Bitte mindestens " 
                    + min + " Zeichen");
        return false;
      } else {
        msg.setText("OK");
        return true;
      }
    }
    return false;
  }

  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {
    // OK Button or "RETURN" was pressed
    if (loginIsLongEnough(login,6,msg1) 
        && loginIsLongEnough(pw1,8,msg2) 
        && pwdsAreEqual()
        ) {
      System.out.println("Login   : " + login.getText());
      // we ignore the issue that one should avoid storing
      // passwords in Strings here:
      System.out.println("PW1     : " 
                         + new String(pw1.getPassword()));
      System.out.println("PW2     : " 
                         + new String(pw2.getPassword()));
      System.out.println("Comment : " 
                         + comment.getText());
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    new Login();
  }
}
