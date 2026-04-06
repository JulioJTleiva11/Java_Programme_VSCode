package op05;

import java.time.LocalDate;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * Model required for the member table.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class MemberTableModel extends AbstractTableModel {
  private Vector<Member> members;
  
  public MemberTableModel() {
    members = new Vector<Member>(); // empty now
    setup(); // add some members
  }

  /**
   * Auxiliary method to add some dummy members. 
   */
  private void setup() {
    members.add(new Member("Ernie",
        LocalDate.of(2017, 11, 11)));
    members.add(new Member("Bert",
        LocalDate.of(2017, 11, 11)));
    members.add(new Member("Krümelmonster",
        LocalDate.of(2017, 11, 12)));
    members.add(new Member("Kermit",
        LocalDate.of(2018,  1, 1)));
    members.add(new Member("Oskar",
        LocalDate.of(2010,  1, 2)));
  }

  // Methods of AbstractTableModel to override
  @Override
  public int getColumnCount() {
    return 3; // we have a fixed number here
  }

  @Override
  public int getRowCount() {
    return members.size(); // a row for each member 
  }

  @Override
  public Object getValueAt(int row, int col) {
    Member member = members.elementAt(row);
    switch (col) {
      case 0 : return member.getNumber(); // Autoboxing! 
      case 1 : return member.getName();
      case 2 :
        return member.getMemberSince(); 
       
      default: return null; // should not happen...
    }
  }
  
  // Improvements
  @Override
  public String getColumnName(int col) {
    switch (col) { // header of the column
      case 0 : return "Nr.";
      case 1 : return "Name";
      case 2 : return "Eingetreten am";
      default: return "???";
    }
  }

  @Override
  public Class<?> getColumnClass(int col) {
    System.out.println("Called with " + col);
    switch (col) { // improves the presentation
      case 0 : return Integer.class;
      case 1 : return String.class;
      case 2 : return LocalDate.class; 
      default: return Object.class;
    }
  }
  
  /**
   * Adds a new member to the club.
   * @param newMember the new member
   */
  public void add(Member newMember) {
    members.add(newMember);
    System.out.println("Neu : " + newMember.getName());
    fireTableDataChanged(); // VERY IMPORTANT! //die Tabelle wird aktualisiert automatisch!!!
    // this informs all listeners of the model
    // including the JTable 
  }
    /*
     * zusammenfassung: 
     * enter dann actionperfomance aufgerufen
     * erzeugt neues obj
     * obj wird zu Model gebracht und wird add()
     * dann firetabledatachanged für die aktualisierung, sehr wichtig
     */
}
