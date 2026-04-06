package op05;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Example how to create a JComboBox.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class JComboBoxExample extends JFrame
    implements ActionListener {
  // a combobox using Double (not double!)
  private JComboBox<Double> comboBoxOfNumbers; 
  private static final Double[] numbers  //ein array name numbers, ein konstantes array, niemals ändern, deshalb private static final
    = { 42.0, 0.0, 1.0, 2.71828, 3.14159, //Double mit D geschrieben sind Objekten
        13.0, 23.0, 4711.0 }; 
  private Container cnt;   //

  /**
   * Creates a window that contains a simple JComboBox.
   */
  public JComboBoxExample() {
    super("JComboBoxExample");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cnt = getContentPane();
    cnt.setLayout(new FlowLayout()); // being lazy

    // creating the combo with given numbers
    comboBoxOfNumbers = new JComboBox<Double>(numbers); //erzeugen vom comboBox
    // we want to be informed if something happens 
    comboBoxOfNumbers.addActionListener(this);
    // initially we set the first element as selected
    comboBoxOfNumbers.setSelectedIndex(0); 
    // now we put the comboBox into the window
    cnt.add(comboBoxOfNumbers);

    setSize(300,200);
    setVisible(true);
  }

  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == comboBoxOfNumbers) { 
      // now we know: action at the comboBox
      // which one is selected now?  
      int sel = comboBoxOfNumbers.getSelectedIndex(); 
      Object selectedObject // notice! Object not Double!
         = comboBoxOfNumbers.getSelectedItem();
      // output the result 
      System.out.println("Auswahl (Index) " 
          + sel + " also " + numbers[sel]);  
      System.out.println("Auswahl (Object)" 
          + selectedObject );  
    } 
  }

  public static void main(String[] args) {
    new JComboBoxExample();
  }
}

