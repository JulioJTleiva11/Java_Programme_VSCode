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

/**
 * Example how to add a button to a window and how to react to it.
 * 
 * <p>Adaption of class ButtonTest1 from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ButtonExample1 extends JFrame 
    implements ActionListener { // to get information   ich kann so die nachricht empfangen mit dem implements
  private Container contPane;
  private JButton button;
  private JButton button2;
  private Random random = new Random(); // change background
    
    
    /**
     * Creates a window with a single button. 
     */
    public ButtonExample1() {
      super("Button");   // constructor der Superklasse
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      contPane = getContentPane(); // bauch vom fenster
      contPane.setLayout(new FlowLayout());  // being lazy
  
      Icon icon = // we want a button with an icon! 
          new ImageIcon(getClass().getResource("cat.gif"));
      button = new JButton("Bitte klicken", icon);  // ich baue mir einen neuen knopf, und merke ich mir in button
      button2 = new JButton("Bitte hier nicht klicken", icon); //1 // ich baue mir einen neuen knopf, und merke ich mir in button
    
    button.setToolTipText("Test");  // wenn man näher kommt mit der MAus über den Knopf, erscheint "test"
    button.addActionListener(this); // Frame subscribe to button// damit man weiß, was alles mit dem knopf passiert auf dem Frame
    button2.addActionListener(this); //3
    
    //siehe oben inerface "implements ActionListener" --> füge eine actionlistener zu (this==mich) "ich bin ein fan von diesem Button"
    contPane.add(button);  //contPane ist bauch von fenster zentriert
    contPane.add(button2); //2 //contPane ist bauch von fenster zentriert


    setSize(300, 200);
    setVisible(true);
  }


  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {   //eine Aktion ist passiert 
    if (e.getSource() == button) {  // button pressed?   getsource = was ist deine Quelle
      System.out.println("ich wurde gedrückt");  //als test hinzugefügt
      contPane.setBackground(       // color randomly
          new Color(random.nextInt(256), 
              random.nextInt(256),
              random.nextInt(256)));
    } 

    //implementierung für mehrere Knopfe
    else if (e.getSource() == button2) {  // button pressed?   getsource = was ist deine Quelle
      System.out.println("ich wurde frecherweise gedrückt");  //als test hinzugefügt
      contPane.setBackground(Color.CYAN);  // color randomly
         // new Color(random.nextInt(256), 
             // random.nextInt(256),
             // random.nextInt(256)));
    } 



  }

  public static void main(String[] args) {
    new ButtonExample1();
  }
}
