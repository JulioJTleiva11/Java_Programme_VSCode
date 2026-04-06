package op05;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * An Example how to use JSliders.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class JSliderExample extends JFrame
    implements ChangeListener { // JSlider uses this

  private JSlider periodSlider;
  private JSlider amplitudeSlider;
  private JPanel panel;
  private int amplitude;
  private int period;

  /**
   * Creates two sliders for amplitude and period 
   * of the sine function to plot.
   */
  public JSliderExample() {
    super("JSliderExample");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new BorderLayout());

    // a JSlider for the period (initially 1)
    period = 1;
    periodSlider = new JSlider(JSlider.HORIZONTAL,
                               0,20,period);
    periodSlider.setMajorTickSpacing(10);
    periodSlider.setMinorTickSpacing(2);
    periodSlider.setPaintTicks(true);
    periodSlider.setPaintLabels(true);
    periodSlider.addChangeListener(this);
    cnt.add(periodSlider,BorderLayout.NORTH);

    // a JSlider for the amplitude (initially 1)
    amplitude = 1;
    amplitudeSlider = new JSlider(JSlider.VERTICAL,
                                  0,10,amplitude);
    amplitudeSlider.setMajorTickSpacing(2);
    amplitudeSlider.setPaintTicks(true);
    amplitudeSlider.setPaintLabels(false);
    amplitudeSlider.addChangeListener(this);
    cnt.add(amplitudeSlider,BorderLayout.WEST);

    panel = new JPanel() {
      public void paintComponent(Graphics g) {
        super.paintComponent(g); // never forget

        Dimension d = getSize();
        int min = Math.min(d.width,d.height);
        // draw the axis
        g.drawLine(0,min / 2, min, min / 2);
        g.drawLine(min / 2, 0, min / 2, min);
        int x; // the x position in the panel!
        int y; // the y position in the panel!
        int oldx = 0; // previous x in the panel
        int oldy = 0; // previous y in the panel
        // now draw the function
        for (x = 0; x < min; x++) {
          // compute current *Carthesian* value
          // we plot from -10 to 10 
          double curX = -10.0 + (20.0 * x) / min;
          // compute the sine(curX) 
          double curY = Math.sin(curX * period) * amplitude;
          // now transform this into a panel position
          y = min / 2 - (int)(curY * (min / 2) / 10.0);
          if (x > 0) {
            g.drawLine(oldx,oldy,x,y);
          }
          // remember last point
          oldx = x; 
          oldy = y;
        }

      }
    };
    cnt.add(panel,BorderLayout.CENTER);

    setSize(500,500);
    setVisible(true);
  }

  /* (non-Javadoc)
   * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
   */
  public void stateChanged(ChangeEvent e) {
    if (e.getSource() == periodSlider) {
      // new period chosen. Adjust "period"
      period = periodSlider.getValue();
      System.out.println("Periode " + period);
    } else if (e.getSource() == amplitudeSlider
        // we DON'T want to react while user is
        // still moving the slider:
        && ! amplitudeSlider.getValueIsAdjusting()) {
      // new amplitude chosen. Adjust "amplitude"
      amplitude = amplitudeSlider.getValue();
      System.out.println("Amplitude " + amplitude);
    }
    panel.repaint();
  }

  public static void main(String[] args) {
    new JSliderExample();
  }



}
