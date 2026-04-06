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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Another example how to create JLists and how to use them.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class JListExample2 extends JFrame
    implements ActionListener,
        ListSelectionListener { // uses own Listener class!!!
  private JButton ok;
  private JList<String> keeper;
  private String[] goalkeeper = {
		  "Frohms", "Schult", "Berger"};
  private JList<String> elfMinusOne;
  private String[] team = {"Kleinherne", "Hendrich", 
		  "Hegering", "Gwinn", "Rauch", "Doorsoun", 
		  "Lattwein", "Oberdorf", "Lohmann", "Huth", 
		  "Popp", "Däbritz", "Dallmann", "Bühl", 
		  "Magull", "Brand", "Schüller", "Freigang",
		  "Anyomi", "Wassmuth"
  };

  /**
   * Creates a JList with players and expects 11 player to be chosen.
   */
  public JListExample2() {
    super("JListExample");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new FlowLayout()); // being lazy

    // creating a JList of goal keepers
    keeper = new JList<String>(goalkeeper);
    keeper.setSelectionMode( // only one keeper!
        ListSelectionModel.SINGLE_SELECTION);
    keeper.setSelectedIndex(0); // start with Frohms :-)
    keeper.setSelectionBackground(Color.blue);  // colors
    keeper.setSelectionForeground(Color.white);
    // we want to be informed if something happens here
    keeper.addListSelectionListener(this);
    // add the list to the JFrame WITHOUT A SCROLLBAR
    cnt.add(keeper); // no need to scroll

    // creating a JList of the soccer team
    elfMinusOne = new JList<String>(team);
    elfMinusOne.setVisibleRowCount(10); // 10 elements visible
    elfMinusOne.setSelectionBackground(Color.blue);  // colors
    elfMinusOne.setSelectionForeground(Color.white);
    // we want to be informed if something happens here
    elfMinusOne.addListSelectionListener(this);
    // add the list to the JFrame WITH A SCROLLBAR
    cnt.add(new JScrollPane(elfMinusOne)); // now "10" make sense 

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
      if (!elfMinusOne.isSelectionEmpty()) {
        // give me ALL selected indices 
        int idxKeeper = keeper.getSelectedIndex();
        // now print the starting players 
        System.out.println("Aufstellung:");
        System.out.println("Im Tor: " + goalkeeper[idxKeeper]);
        System.out.println("Im Feld: ");
        int[] idx = elfMinusOne.getSelectedIndices();
        for (int index : idx) {
          System.out.println(team[index]);
        }
        System.out.println("Also " + (idx.length + 1) + " Spieler");
      }
    }
  }

  /* (non-Javadoc)
   * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
   */
  public void valueChanged(ListSelectionEvent e) {
    if (e.getSource() == elfMinusOne) {  
      // list might have changed
      if (!elfMinusOne.isSelectionEmpty()) {
        // give me ALL selected indices 
        int[] idx = elfMinusOne.getSelectedIndices(); 
        int numberOfSelected = idx.length + 1; // +1 for keeper
        System.out.println("Jetzt " 
            + numberOfSelected + " Spieler");
        // OK if and only if 11 players are selected
        ok.setEnabled(numberOfSelected == 11);
      }
    }
  }

  public static void main (String[] args) {
    new JListExample2();
  }
}
