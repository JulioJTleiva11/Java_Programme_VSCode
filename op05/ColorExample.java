package op05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Example that uses many colors.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
class ColorExample extends JPanel {

  private int dz = 0;

  public ColorExample() {
    setBackground(Color.white); // meaning is obvious
    setPreferredSize(new Dimension(512,512));

    Timer timer = new Timer();  // a new timer
    TimerTask task = new TimerTask() { // a new thread
      @Override
      public void run() { // what this thread does
        dz++;
        System.out.println("dz = " + dz);
        repaint(); // refresh because 0.1s are over
        }
    };
    // the thread is just defined, not started yet
   
    // restart this task now (0) and every 100ms
    timer.schedule(task, 0,100); 
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g); // never forget!
    
    Dimension d = getSize(); // get current size
    int dx = d.width / 256;  // compute width (dx) and 
    int dy = d.height / 256; // height (dy) of rectangle
    for (int i = 0; i < 256;i++) {
      for (int j = 0; j < 256;j++) {
    	// set color: R:x-pos, G:y-pos, B:time
    	g.setColor(new Color(i, j, dz % 256)); 
    	// draw rectangle 
    	g.fillRect(i * dx, j * dy, dx, dy); 
      }
    }
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    ColorExample ce = new ColorExample();

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    window.add(ce); // add the panel to the frame
    window.pack();  // organise the container
    window.setVisible(true); // show time!
  }
}
