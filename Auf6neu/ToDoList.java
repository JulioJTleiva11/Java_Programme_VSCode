package Auf6neu;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import op07.serialisation.Comp;

import java.awt.BorderLayout; //Für BorderLayout sonst geht nicht
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


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

    // main bauen ok ab hier geht los
    public static void main(String[] args){
        new ToDoList();  // starte und baue neue ToDoList
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == load) { 

            //hier wird die Logik vom Button erstellt
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(".")); //"." -> arbeite da, wo du grad bist. "." is the current working directory.

            //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // FILES_AND_DIRECTORIES
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY); // alternatively: FILES_ONLY, DIRECTORIES_ONLY

            // allow only a single file to be selected
            fc.setMultiSelectionEnabled(false);
        
            // Wenn "Laden" gedrückt wurde, dann öffne File f
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
    	        // user pressed OK, ie. a selection is approved
                //String fname = fc.getSelectedFile().getAbsolutePath();
                File f = fc.getSelectedFile();
             
             //Ab hier versuch etwas zu lesen: ObjectInputStream VERSUCHT AUFZUMACHEN dann ein object gelesen
                ObjectInputStream in = null;

                try {
                    //aufmachen vom File "f" 
                    in = new ObjectInputStream(new FileInputStream(f));
                    //object lesen und casting auf Integer, da ganz links eine Zahl ist
                    Integer count = (Integer) in.readObject(); //versuch ein Object zu lesen, also ein INTEGER

                    //wie viele weitere objecte i < count in dieser Datei sind:
                    for (int i = 0; i < count; i++){
                        //noch mal object lesen und casting auf ToDoItem
                        ToDoItem job = (ToDoItem)in.readObject();
                        /* also 1. Object lesen: in.readObject(); 
                        2. casting auf Integer: (Integer) 
                        3. speicher in einer Var derselben Klasse: ToDoItem job =*/
                        model.add(job);// alles in ToDoListModel model hinzufügen
                    }
                } 
                catch(ClassNotFoundException | IOException e){ //falls die Datei nicht kennt, oder Datei Kaputt
                    e.printStackTrace();
                }

                //guter Programmierstil: File schließen mit Try-Catch!
                finally{
                    if( in!=null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
