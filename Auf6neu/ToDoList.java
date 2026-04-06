package Auf6neu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout; //Für BorderLayout sonst geht nicht


//Fenster mit der Liste bauen (JFrame abgeleitet)
public class ToDoList extends JFrame {
    
    
    private ToDoListModel model;
    private JTable table;


    public ToDoList() {
        super("To-Do-Liste");
        setLayout(new BorderLayout(10, 10)); //Für die Abstaende
        
        //was passiert nun im Zentrum -> eine tabelle haben will
        // also neues Model 
        model = new ToDoListModel(); //dann in die JTable einstecken
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        load = new JButton("Laden");
        add(load, BorderLayout.SOUTH);
        load.addActionListener(this);
            

        setSize(500, 500);
        setVisible(true);

    
    }


    //1 main bauen
    public static void main(String[] args){
        new ToDoList();  // starte und baue neue ToDoList
    }

}
