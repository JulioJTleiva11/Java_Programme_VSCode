package op05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Example how to create a panel and how to draw something.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

class JPanelExample extends JPanel {
  public JPanelExample() {
    setBackground(Color.yellow); // meaning is obvious
    setPreferredSize(new Dimension(300,200));
  }

  // for each panel this must be overridden!
  // parameter g is a graphic context and 
  // we are allowed to draw on it. 
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); // never forget!
    g.setColor(Color.red);   // we use red now
    g.fillRect(10,30,230,80);// draw a rectangle
    g.setColor(Color.white); // we use white now
    g.setFont(new Font("Monospaced", Font.BOLD, 48));
    g.drawString("Jippie!",20,80); // a write a text
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    JPanelExample jpe = new JPanelExample();

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    window.add(jpe); // add the panel to the frame
    window.pack();   // organise the container
    window.setVisible(true); // show time!
  }
}
