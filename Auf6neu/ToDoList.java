package Auf6neu;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout; //Für BorderLayout sonst geht nicht
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


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


    // main bauen
    public static void main(String[] args){
        new ToDoList();  // starte und baue neue ToDoList
    }


    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == load) {

      //hier wird die Logik vom Button erstellt
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(".")); //"." -> arbeite da, wo du grad bist
      //  "." is the current working directory.

      fc.setFileSelectionMode(
      JFileChooser.FILES_AND_DIRECTORIES);
      // alternatively: FILES_ONLY, DIRECTORIES_ONLY

      // allow only a single file to be selected
      fc.setMultiSelectionEnabled(false);

      if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
    	  // user pressed OK, ie. a selection is approved
        String fname = fc.getSelectedFile().getAbsolutePath();
        //textArea.setText(textArea.getText() + fname + "\n");
      }
    }

}
