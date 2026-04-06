package Auf6neu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout; //Für BorderLayout sonst geht nicht
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Fenster mit der Liste bauen (JFrame abgeleitet)
public class ToDoList extends JFrame implements ActionListener {
    
    
    private ToDoListModel model;
    private JTable table;
    private JButton load;


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
        load.addActionListener(this); //damit der JButton was macht



        setSize(500, 500);
        setVisible(true);

    
    }


    //1 main bauen
    public static void main(String[] args){
        new ToDoList();  // starte und baue neue ToDoList
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
