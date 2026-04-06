package op05;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Example how to use JLabels.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
class JLabelExample extends JFrame {
  public JLabelExample() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    c.setBackground(Color.yellow);

    // Constructing icons from JPGs
    Icon king  = new ImageIcon(getClass()
                     .getResource("King_Chess.jpg"));
    Icon queen = new ImageIcon(getClass()
                     .getResource("Queen_Chess.jpg"));

    // Constructing labels 
    JLabel kingLabel 
             = new JLabel("König", king, JLabel.LEFT);
    JLabel queenLabel 
             = new JLabel("Dame", queen, JLabel.CENTER);

    kingLabel.setForeground(Color.black);
    kingLabel.setBackground(Color.white);
    kingLabel.setOpaque(true);
    
    queenLabel.setForeground(Color.white);
    queenLabel.setBackground(Color.black);
    queenLabel.setOpaque(true);

    // adding them to the pane
    c.add(kingLabel,BorderLayout.NORTH);
    c.add(queenLabel,BorderLayout.SOUTH);

    setSize(400,300);
    setVisible(true);  // show time!
  }  

  public static void main(String[] args) {
    new JLabelExample();
  }
}
