package Aufgabe6;

import java.util.List; //dami List<> funktioniert, dann löschen: import java.awt.List;
//import java.awt.List; //nich mehr nötig, siehe oben
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ToDoListModel extends AbstractTableModel{
    
    //Hier wird gespeichert die geladenen ToDo-Einträge 
    private List<ToDoItem> items = new ArrayList<>(); 

    //Namen der Spalten für die Tabelle
    private String[] columnNames = { "Was?", "wo?", "Bis Wann?", "Wie wichtig?"}; //final?

    //Methode zum Aktualisieren der Liste/hinzufügen eingelsenen items
    public void setItems(List<ToDoItem> newItems) {
        //this.items = newItems;  //items.add(newItems); //hier muss man casting
        fireTableDataChanged();//benachrichtigt die JTable über neue Daten
    }

    @Override
    public int getRowCount() { //brauch Anzahl der Items für Zeilen
        return items.size();
    }

    @Override
    public int getColumnCount() { //braucht die Länge der Spalten
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    //je nach Spalte einen passenden Wert zurückgeben
    public Object getValueAt(int rowIndex, int columnIndex) {
        ToDoItem item = items.get(rowIndex);
        switch (columnIndex){
            case 0: return item.getWhatToDo();
            case 1: return item.getContext();
            case 2: return item.getDeadline();
            case 3: return item.getPriority();
            default: return null;
        }
    } 






}
