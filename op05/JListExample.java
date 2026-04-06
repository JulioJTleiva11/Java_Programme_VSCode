package op05;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Another example how to create a JList and how to use it.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class JListExample extends JFrame
    implements ActionListener,
        ListSelectionListener { // special Listener class!
  private JButton ok;
  private JList<String> elf;
  private String[] team = {
      "Frohms", "Schult", "Berger", "Kleinherne",
      "Hendrich", "Hegering", "Gwinn", "Rauch",
      "Doorsoun", "Lattwein", "Oberdorf", "Lohmann",
      "Huth", "Popp", "Däbritz", "Dallmann", "Bühl",
      "Magull", "Brand", "Schüller", "Freigang",
      "Anyomi", "Wassmuth"
  };

  /**
   * Creates a JList with players and expects 11 player to be chosen.
   */
  public JListExample() {
    super("JListExample");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new FlowLayout()); // being lazy

    // creating a JList of the soccer team
    elf = new JList<String>(team);  //constructor von jlist aufrufen 
    elf.setVisibleRowCount(10); // 10 elements visible in the comboBox
    elf.setSelectionBackground(Color.red);  // colors
    elf.setSelectionForeground(Color.white);
    // we want to be informed if something happens here
    elf.addListSelectionListener(this);
    // add the list to the JFrame WITH A SCROLLBAR
    cnt.add(new JScrollPane(elf)); // now "10" makes sense 

    // adding a button to finish the selection
    ok = new JButton("Aufstellen");
    ok.addActionListener(this);
    // shall be enabled only if 11 players are selected
    ok.setEnabled(false); // not enabled initially 
    cnt.add(ok);

    setSize(400,400);
    setVisible(true);
  }

  /* (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == ok) {
      // OK button was pressed or released
      if (!elf.isSelectionEmpty()) {
        // give me ALL selected indices 
        int[] idx = elf.getSelectedIndices();
        // now print the starting players 
        System.out.println("Aufstellung:");
        for (int index : idx) {
          System.out.println(team[index]);
        }
        System.out.println("Also " + idx.length + " Spieler");
      }
    }
  }

  /* (non-Javadoc)
   * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
   */
  public void valueChanged(ListSelectionEvent e) {
    if (e.getSource() == elf) {  
      // selection might have changed
      if (!elf.isSelectionEmpty()) {
        // give me ALL selected indices 
        int[] idx = elf.getSelectedIndices(); 
        int numberOfSelected = idx.length;
        System.out.println("Jetzt " 
            + numberOfSelected + " Spieler");
        // OK if and only if 11 players are selected
        ok.setEnabled(numberOfSelected == 11);
      }
    }
  }

  public static void main (String[] args) {
    new JListExample();
  }
}
