package op05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class JPanelExampleOpaque 
             extends JPanelExampleAnim {
	
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); // never forget!
    Dimension d = getSize(); // get current size
    // use opacity here
    g.setColor(new Color(0, 0, 255, getPosition()%256));
    // we want 10px border: 
    g.setFont(new Font("Monospaced", Font.BOLD, 48));
    // write a text
    g.drawString("Bedenken Sie die Keks-Regel! "
                 +getPosition(), getPosition(), 
                 d.height / 4);
  }	
	
  public static void main(String[] args) {
	    JFrame window = new JFrame();
	    JPanelExampleOpaque jpe = new JPanelExampleOpaque();

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
