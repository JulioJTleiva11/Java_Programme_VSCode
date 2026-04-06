package op05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Example how to create a panel and how to repaint.
 * 
 * @author Henning Dierks
 * @version 1.0
 */

class JPanelExampleAnim extends JPanel {
  // Attributes
  private int position = 0; 

  public int getPosition() {
	return position;
}

public JPanelExampleAnim() {
    // meaning of the following should be obvious
    setPreferredSize(new Dimension(300,250));
    setBackground(new Color(50,200,100)); 
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); // never forget!
    Dimension d = getSize(); // get current size
    g.setColor(Color.red);   // we use red now
    // we want 10px border: 
    g.fillRect(10, 10, d.width - 20, d.height - 20); 
    g.setColor(Color.white); // we use white now
    g.setFont(new Font("Monospaced", Font.BOLD, 48));
    // write a text
    g.drawString("Bedenken Sie die Keks-Regel! "
    		     +position, position, d.height / 2);
  }

  public void step() { 
    position++; 
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    JPanelExampleAnim jpe = new JPanelExampleAnim();

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    window.add(jpe); // add the panel to the frame
    window.pack();   // organise the container
    window.setVisible(true); // show time!

    while (true) { // forever
      try { // sleep for 0.1 seconds
        Thread.sleep(300); 
      } catch (InterruptedException e) {
        // ignore, nobody will interrupt us
      }
      jpe.step(); // increase position
      jpe.repaint(); // redraw the panel
    }
  }
}
