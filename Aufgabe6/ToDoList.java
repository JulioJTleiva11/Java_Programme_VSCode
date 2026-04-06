package Aufgabe6;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/* GUI Erstellung und Einlesen der Datei
    bauen des Fenser mit List
 */
public class ToDoList extends JFrame{

    private JTable table;
    private ToDoListModel model;
    private JButton btnLoad;
    

    public ToDoList(){  //2
        super("To-Do-List"); // 3 Titel der JFrame 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Fensterschließen können
        this.setLayout(new BorderLayout(10,10)); //4

        // b) Modell erzeugen & der JTable zuweisen
        model = new ToDoListModel(); //5
        table = new JTable(model);  //6

        //tabelle in ein Scrollpane legen(Spaltenübersicht)
        this.add(new JScrollPane(table), BorderLayout.CENTER); //7

        //c) Button für den Datei-Dialog
        btnLoad = new JButton("Laden");
        btnLoad.addActionListener(e -> loadData());
        this.add(btnLoad, BorderLayout.SOUTH);
        

        this.setSize(500, 500); //this.pack(); //8
        this.setVisible(true);  //9 Frame visible
    }

    //Logik von JButton
    private void loadData() {  //hier von "Object" zu "void", also ohne Rückgabewert
        //JFileChooser starten
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();

            //Datei einlesen gemaeß Aufgabestellung d)
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
            {
                // 1. Zuerst den Integer für die Anzahl lesen
                int count = ois.readInt();
                List<ToDoItem> loadedItems = new ArrayList<>();

                // 2. genau 'Count' ToDoItem-Objekte einlesen
                for(int i = 0; i < count; i++){
                    ToDoItem item = (ToDoItem) ois.readObject(); //Cast von eingelesen Items und speichern in 'item'
                    loadedItems.add(item); // 'item' zu List<ToDoItem> loadedItems
                }

                // Model aktualisieren
                model.setItems(loadedItems);                
            } 
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Fehler beim Laden: " + ex.getMessage());
            }

        }
    }

    public static void main(String[] args) {  // 1
        new ToDoList();
    }

}
