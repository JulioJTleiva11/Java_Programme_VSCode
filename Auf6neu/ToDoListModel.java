package Auf6neu;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

//ToDoListModel: Liste vom Objekte der Sorte ToDoItem
// das kann man mit Vector<>
public class ToDoListModel extends AbstractTableModel{

    private Vector<ToDoItem> items; // ein vector von ToDoItem

    //Konstru
    public ToDoListModel() {
        items = new Vector<ToDoItem>();//erzeugen ein neues itemsVector
    }

    //methode Add um items zum hinzufügen
    public void add(ToDoItem job) {
        items.add(job);
        fireTableDataChanged();//GUI aktualisieren
    }

    @Override  //wie viele Zeilen?
    public int getRowCount() {
        return items.size();        
    }

    @Override  //wie viele Spalten?
    public int getColumnCount() {
        return 4;
    }

    @Override // was in den einzelnen Felder anzeigen?
    public Object getValueAt(int rowIndex, int columnIndex) {
        ToDoItem job = items.get(rowIndex);
        switch (columnIndex) {
            case 0: return job.getWhatToDo();
            case 1: return job.getContext();
            case 2: //Object der GregorianCalender es wird deprecated
                    GregorianCalendar day = job.getDeadline();
                    return day.getTime();// zur Ausgabe
            case 3: return job.getPriority();            
            default: return null;
        }
    }
    
    //Methode für die Name oberster ZeilenListe, siehe Class MemberTableModel.java
    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: return "Was?";
            case 1: return "Wo?";
            case 3: return "Bis Wann?";
            case 4: return "Wie Wichtig?";        
            default: return "???";
        }
    }

    //Methode vom Class MemberTableModel
    @Override
    public Class<?> getColumnClass(int col){
        switch (col) {
            case 0: return String.class;
            case 1: return String.class;
            case 3: return Date.class;//nicht GregorisanCalender!7hnjm,
        
            default: return Object.class;
        }
    }

}
