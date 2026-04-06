package op05;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Example how to add a button to a window and how to react to it.
 * 
 * <p>Adaption of class ButtonTest2 from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ButtonExample2 extends JFrame 
    implements ActionListener { // to get information 
  private Container contPane;
  private JButton button;
  private int counter; 
  private Random random = new Random(); 

  /**
   * Creates a window with a single button. 
   */
  public ButtonExample2() {
    super("Button2");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contPane = getContentPane();
    contPane.setLayout(new FlowLayout());  // being lazy

    Icon icon = // we want a button with an icon!
        new ImageIcon(getClass().getResource("Java_Coffee.png"));
    button = new JButton("Bitte klicken (" + counter + ")", icon);
    button.setToolTipText("Test");  // it is so simple!
    button.addActionListener(this); // subscribe to information
    contPane.add(button);
    contPane.add(new JLabel("Kihara wa kigo, CC BY-SA 4.0" +
                 "<https://creativecommons.org/licenses/by-sa/4.0>,"
                 + " via Wikimedia Commons"));
    setSize(800, 600);
    setVisible(true);
  }


  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {  // button pressed?
   // change background color randomly
      contPane.setBackground(       
          new Color(random.nextInt(256), 
              random.nextInt(256),
              random.nextInt(256)));
      counter++;
      button.setText("Bitte klicken (" + counter + ")");
      if (counter % 5 == 4) {  // sleep when 4,9,14,19,...
        button.setEnabled(false); // disable button
        try {
          Thread.sleep(10000); // sleep 10s
        } catch (Exception ex) { 
          ; // don't do anything...
        } 
        button.setEnabled(true); // enable button
      }
    }
  }


  public static void main(String[] args) {
    new ButtonExample2();
  }
}
