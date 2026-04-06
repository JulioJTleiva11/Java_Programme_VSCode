package op01;

/**
 * Second JAVA program: Simple Window. 
 * @author Henning Dierks
 * @version 1.1
 */

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Demo2 extends JFrame {
  /**
   * Generates a simple window.
   */
  public Demo2(int index) {                 // Constructor 
    super("Geänderter Titel");  
    
    Icon icon = new ImageIcon(getClass().getResource("duke.gif"));// we want an icon
    JLabel label =                 // we want a text
        new JLabel("Viel Erfolg bei der Java-Vorlesung", 
            icon, JLabel.CENTER);  // put text in center
    add(label);                    // add it to window

    // define a font now
    Font font = new Font("Times New Roman", Font.BOLD, 30);
    label.setFont(font);           // use this font now
    label.setForeground(Color.BLUE);// set some colors
    label.setBackground(Color.WHITE); 
    label.setOpaque(true);
    

    // meaning of X button  
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
    //setSize(1000, 800);    // initial size of window
    setSize(100+index*100, 800-index*100);    // mit index initial size of window modifiziert

    //setLocation(10,20);    // initial position
    setLocation(10+index*50,20+index*20);    // mit index position modifiziert
    setVisible(true);      // show-time!
  }

  /**
   * Starts a single window.
   * @param args not used
   */
  public static void main(String[] args) {
    //@SuppressWarnings("unused")
    //Demo2 mydemo2 = new Demo2();  // create a window-object
    
    //new Demo2();  // create a window-object

    //beispiel für 5 Fenster gleichzeitig
    for(int i = 0; i < 5; i++){
      new Demo2(i); // index i muss auch im Konstruktor hinzugefügt werden
    }
    
  }
} // end of class definition


