package op05;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Example how to add radio buttons and check boxes to a window and how to react to it.
 * 
 * <p>Adaption of class ButtonTest2 (!) from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */
public class ButtonExample3 extends JFrame //ich baue mir ein fenster
    implements ActionListener {
  // Attributes: Buttons only
  private JCheckBox oval;
  private JRadioButton red;  //atribtute
  private JRadioButton green;  //attribute
  private JRadioButton blue; //atribtute

  /**
   * Creates 4 buttons and draws something according to the buttons. 
   */
  public ButtonExample3() {
    super("Radiobuttons und eine Checkbox");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new BorderLayout(10, 10));

    // Three colors as JRadioButtons  ich setze zuerst den rot auf True == der erste der erscheint
    red   = new JRadioButton("rot",true); // set initially
    blue  = new JRadioButton("blau");
    green = new JRadioButton("grün");

    // Subscribe to information of the radio buttons
    red.addActionListener(this);
    blue.addActionListener(this);
    green.addActionListener(this);

    // Constructing a ButtonGroup: now they know that they belong together
    ButtonGroup bg = new ButtonGroup();  //ich drucke rot, aber grün und blau sind noch als alternative zu drücken
    bg.add(red);  // As a consequence a button  
    bg.add(green);// becomes deselected if another
    bg.add(blue); // button is selected
   
    // Now build a JCheckBox: Oval or rectangle?
    oval = new JCheckBox("oval", true); // set initially
    oval.addActionListener(this); // subscribe

    // Put everything in a panel 
    JPanel panel = new JPanel();
    panel.add(red);
    panel.add(green);
    panel.add(blue);
    panel.add(oval);
    add(panel, BorderLayout.NORTH); // all buttons NORTH

    // we put a panel to draw on in the center
    add(new MyPanel(), BorderLayout.CENTER); 
    pack(); // organise all the elements
    setVisible(true); // show time!
  }

  private class MyPanel extends JPanel {
    public MyPanel() {
      setBackground(Color.white);
      setPreferredSize(new Dimension(400, 120));
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      // Before we draw something we ask the
      // buttons what the user wants
      if (red.isSelected()) {
        g.setColor(Color.red);
      } else if (green.isSelected()) {
        g.setColor(Color.green);
      } else if (blue.isSelected()) {
        g.setColor(Color.blue);
      } else { // should never occur!
        g.setColor(Color.white);
      }

      int w = getSize().width;
      int h = getSize().height;

      if (oval.isSelected()) { // if oval
        g.fillOval(10, 10, w - 20, h - 20);
      } else { // if not oval then rectangle
        g.fillRect(10, 10, w - 20, h - 20);
      }
    }
  }


  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {
    // one of the buttons was pressed.
    // we don't care about which one, we just do
    repaint(); // everything
  }

  public static void main(String[] args) {
    new ButtonExample3();
  }
}
