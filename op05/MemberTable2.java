package op05;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Constructs a slightly improved table with the members of the club.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class MemberTable2 extends JFrame 
    implements ActionListener {
  private JTable table;
  private JTextField textfield; // added
  private MemberTableModel memberModel; // added


  /**
   * Creates a simple window that contains an 
   * improved table of club members.
   */
  public MemberTable2() {
    super("Vereinsmitglieder++");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new GridLayout(3,1));

    memberModel = new MemberTableModel();

    table = new JTable(memberModel);
    // adding sorting buttons for all columns:
    table.setAutoCreateRowSorter(true); //Zeile sortieren automatisch
    
    table.setDefaultRenderer(Object.class,  //siehe class MemberRenderer.java
      new MemberRenderer());  
    table.setDefaultRenderer(Integer.class, 
      new MemberRenderer());
    
    add(new JScrollPane(table)); // we want scrolling
    add(new JLabel(" Neues Mitglied : "));
    textfield = new JTextField(20);
    add(textfield);
    textfield.addActionListener(this);

    setSize(500,300);
    setVisible(true); // show time!
  }

  @Override
  public void actionPerformed(ActionEvent ev) {  //actionperformance ist wenn ein Enter gedrückt wird
    if (ev.getSource() == textfield) { //falls was eingegeben wurde
      memberModel.add(                  //füge zu den anderen Membern hinzu
          new Member(textfield.getText(), //gib mmir was eingegeben wurde
              LocalDate.now()));  //datum aktuell
    }
  }
  
  public static void main(String[] args) {
    new MemberTable2();
  }
}
