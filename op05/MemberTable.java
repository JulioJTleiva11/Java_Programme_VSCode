package op05;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Constructs a table with the members of the club.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class MemberTable extends JFrame {
  private JTable table;

  /**
   * Creates a simple window that contains a 
   * table of club members.
   */
  public MemberTable() {
    super("Vereinsmitglieder");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    table = new JTable(new MemberTableModel());
    add(new JScrollPane(table)); // we want scrolling

    setSize(500,300);
    setVisible(true); // show time!
  }

  public static void main(String[] args) {
    new MemberTable();
  }
}
