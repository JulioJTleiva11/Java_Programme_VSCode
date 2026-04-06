package op05;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Yet another example how to use JComboBoxes.//
 * Beachte:array nehmen, combobox erzeugen contructor und addActionListener(sonst funkt. der knopf nicht) ...
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class JComboBoxExample2 extends JFrame
    implements ActionListener {
  private JComboBox<Color> comboBoxOfColors; //ich möchte eine farbe auswählen dürfen
  private JComboBox<String> comboBoxOfStrings;
  private Color[] colors = { Color.red,   //ein Array mit 3 colors
                             Color.blue, 
                             Color.green };
  private String[] names = { "Rot", "Blau", "Grün"};
  private Container cnt;

  /**
   * Creates a window that contains two JComboBoxes.
   */
  public JComboBoxExample2() {
    super("JComboBoxExample2");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cnt = getContentPane();
    cnt.setLayout(new FlowLayout()); // being lazy

    // creating a box with class Color
    comboBoxOfColors = new JComboBox<Color>(colors); // ich übergebe die 3 colors
    comboBoxOfColors.addActionListener(this);
    comboBoxOfColors.setSelectedIndex(0); // red initially
    cnt.add(comboBoxOfColors);

    // creating box with class String (related to colors)  //für jedes object gibt es die Stringfkt.
    comboBoxOfStrings = new JComboBox<String>(names); 
    comboBoxOfStrings.addActionListener(this);
    comboBoxOfStrings.setSelectedIndex(1); // blue init.
    cnt.add(comboBoxOfStrings);

    setSize(300,200);
    setVisible(true);
  }

  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {  //"wenn man Post bekommt"
    System.out.println("ActionPerformed von " 
                       + e.getSource());
    if (e.getSource() == comboBoxOfColors) { 
      // action at the comboBox using class Color
      int sel1 = comboBoxOfColors.getSelectedIndex();
      System.out.println("Auswahl " + sel1 
          + " also " + colors[sel1]);
      cnt.setBackground(colors[sel1]);
      if (comboBoxOfStrings != null) {  // sync other box
        comboBoxOfStrings.setSelectedIndex(sel1);
      }
    }
    if (e.getSource() == comboBoxOfStrings) {
      // action at the comboBox using class String
      int sel2 = comboBoxOfStrings.getSelectedIndex();
      System.out.println("Auswahl " + sel2 
          + " also " + colors[sel2] 
          + " bzw. " + names[sel2]);
      cnt.setBackground(colors[sel2]);
      if (comboBoxOfColors != null) {  // sync other box
        comboBoxOfColors.setSelectedIndex(sel2);
      }
    }
  }

  public static void main(String[] args) {
    new JComboBoxExample2();
  }

}

