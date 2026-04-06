package op05;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JMenuExample extends JFrame
    implements ChangeListener, ActionListener {

  private JSlider periodSlider;
  private JSlider amplitudeSlider;
  private JPanel panel;
  private int amplitude; 
  private int period;

  /**
   *  Creates two sliders for amplitude and period 
   *  of the function to plot. Adds a menu now
   */
  public JMenuExample()  {
    super("Slider Test mit Menü");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    buildMenu(); // create menu in dedicated method

    Container cnt = getContentPane();
    cnt.setLayout(new BorderLayout());

    // a JSlider for the period (initially 1)
    period = 1;
    periodSlider = new JSlider(JSlider.HORIZONTAL,0,20,period);
    periodSlider.setMajorTickSpacing(10);
    periodSlider.setMinorTickSpacing(2);
    periodSlider.setPaintTicks(true);
    periodSlider.setPaintLabels(true);
    periodSlider.addChangeListener(this);
    cnt.add(periodSlider,BorderLayout.NORTH);

    // a JSlider for the amplitude (initially 1)
    amplitude = 1;
    amplitudeSlider = new JSlider(JSlider.VERTICAL,0,10,amplitude);
    amplitudeSlider.setMajorTickSpacing(2);
    amplitudeSlider.setPaintTicks(true);
    amplitudeSlider.setPaintLabels(false);
    amplitudeSlider.addChangeListener(this);
    cnt.add(amplitudeSlider,BorderLayout.WEST);

    panel = new JPanel() {
      public void paintComponent(Graphics g) {
        super.paintComponent(g); // never forget

        Dimension d = getSize();
        // draw the axis
        g.setColor(Color.black);
        int min = Math.min(d.width,d.height);
        g.drawLine(0, min / 2, min, min / 2);
        g.drawLine(min / 2, 0, min / 2, min);

        // select the color according to user's choice
        if (redMenuItem.isSelected()) {
          g.setColor(Color.red);
        } else if (blueMenuItem.isSelected()) {
          g.setColor(Color.blue);
        } else {
          g.setColor(Color.green);
        }

        int x; // the x position in the panel!
        int y; // the y position in the panel!
        int oldx = 0; // previous x in the panel
        int oldy = 0; // previous y in the panel
        // now draw the function
        for (x = 0; x < min; x++) {
          // compute current *Carthesian* value
          // we plot from -10 to 10 
          double curX = -10.0 + (20.0 * x) / min;
          double curY;
          if (sinus) {
            curY = Math.sin(curX * period) * amplitude;
          } else {
            curY = Math.cos(curX * period) * amplitude;
          }
          // now transform this into a panel position
          y = min / 2 - (int)(curY * (min / 2) / 10.0);
          if (x > 0) {
            g.drawLine(oldx,oldy,x,y);
          }
          // remember last point
          oldx = x; 
          oldy = y;
        } 
        // if requested then we write the function term
        if (legendMenuItem.isSelected()) {
          String text = "f(x)=" + amplitude + "*";
          if (sinus) {
            text += "sin(";
          } else {
            text += "cos(";
          }
          text += period + "*x)";
          g.drawString(text,min / 10,min / 10);
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
    new JMenuExample();
  }

  private JMenuBar             bar;
  private JMenu                  fileMenu;  
  private JMenuItem                quitMenuItem;
  private JMenu                  functionMenu;  
  private JMenuItem                sinMenuItem;
  private JMenuItem                cosMenuItem;
  private JCheckBoxMenuItem        legendMenuItem;
  private JRadioButtonMenuItem     redMenuItem;
  private JRadioButtonMenuItem     blueMenuItem;
  private JRadioButtonMenuItem     greenMenuItem;
  private JMenu                  helpMenu;  
  private JMenuItem                helpMenuItem;

  private void buildMenu() {
    bar = new JMenuBar();
    setJMenuBar(bar);

    // Creating the menu objects
    fileMenu       = new JMenu("Datei");
    quitMenuItem     = new JMenuItem("Beenden");
    functionMenu   = new JMenu("Funktion");
    sinMenuItem      = new JMenuItem("Sinus");
    cosMenuItem      = new JMenuItem("Cosinus");
    legendMenuItem   = new JCheckBoxMenuItem("Legende",
    		                                 false);
    redMenuItem      = new JRadioButtonMenuItem("Rot",
    		                                    true);
    blueMenuItem     = new JRadioButtonMenuItem("Blau");
    greenMenuItem    = new JRadioButtonMenuItem("Grün");
    helpMenu       = new JMenu("Hilfe");
    helpMenuItem     = new JMenuItem("Hilfe");

    // grouping the buttons
    ButtonGroup bgColor = new ButtonGroup();
    bgColor.add(redMenuItem);
    bgColor.add(blueMenuItem);
    bgColor.add(greenMenuItem);

    // building the menu
    bar.add(fileMenu); 
    fileMenu.add(quitMenuItem);
    bar.add(functionMenu);
    functionMenu.add(sinMenuItem);
    functionMenu.add(cosMenuItem);
    functionMenu.addSeparator(); // put a line here
    functionMenu.add(legendMenuItem);
    functionMenu.addSeparator(); // put a line here
    functionMenu.add(redMenuItem);
    functionMenu.add(blueMenuItem);
    functionMenu.add(greenMenuItem);
    bar.add(helpMenu); 
    helpMenu.add(helpMenuItem);

    
    // Keyboard shortcuts

    // CTRL-Q for quit
    quitMenuItem.setAccelerator(
        KeyStroke.getKeyStroke("ctrl Q"));
    // CTRL-S for sine
    sinMenuItem.setAccelerator(
        KeyStroke.getKeyStroke("ctrl S"));
    // CTRL-C for cosine
    cosMenuItem.setAccelerator(
        KeyStroke.getKeyStroke("ctrl C"));
    // L for legend
    legendMenuItem.setAccelerator(
        KeyStroke.getKeyStroke("L"));

    // D for menu File ("Datei")
    fileMenu.setMnemonic(KeyEvent.VK_D);
    // F for menu Function
    functionMenu.setMnemonic(KeyEvent.VK_F);
    // H for menu Help
    helpMenu.setMnemonic(KeyEvent.VK_H);
    // B for blue
    blueMenuItem.setMnemonic(KeyEvent.VK_B);
    // G for green
    greenMenuItem.setMnemonic(KeyEvent.VK_G);
    // R for red
    redMenuItem.setMnemonic(KeyEvent.VK_R);

    // subscribe as listener to many menu objects
    quitMenuItem.addActionListener(this);
    sinMenuItem.addActionListener(this);
    cosMenuItem.addActionListener(this);
    legendMenuItem.addActionListener(this);
    redMenuItem.addActionListener(this);
    blueMenuItem.addActionListener(this);
    greenMenuItem.addActionListener(this);
    helpMenuItem.addActionListener(this);

  }  // end of buildMenu()

  // shall we draw sine or cosine?
  private boolean sinus = true;

  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == quitMenuItem) {
      System.out.println("Beenden");
      System.exit(0);
    } else if (ev.getSource() == sinMenuItem) {
      System.out.println("Sinus");
      sinus = true;
    } else if (ev.getSource() == cosMenuItem) {
      System.out.println("Cosinus");
      sinus = false; // means cosine to draw
    } else if (ev.getSource() == legendMenuItem) {
      System.out.println("Legende");
    } else if (ev.getSource() == helpMenuItem) {
      System.out.println("Hilfe gibt es noch nicht");
    } 
    // Notice: We don't query the RadioButtons here.
    // Happens while repainting which we do after
    // each action and we do this now:
    panel.repaint();
  }
}
