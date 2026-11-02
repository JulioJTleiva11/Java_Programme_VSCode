/*
Programm     : PersonView.java
Autor        : Julio Jesus Tomasto Leiva
Datum        : heute
Beschreibung : 
 */
package LAB_03;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonView extends JFrame {
    //Atributte
    JPanel pan = new JPanel();
    //Konstruktor
    public PersonView(Person personToShow){
        super("PersonenDaten");//setTitle("PersonenDaten");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pan = new PersonPanel(personToShow);
        add(pan);

        setLocation(new Point(490,80));//setLocationRelativeTo(null);
        setSize(new Dimension(700, 500)); //this.pack(); //
        setVisible(true);
    }

    public static void main(String[] args) {
        Person kloebner = new Person ("Senora", "Dr.", "Ymelda", "Leiva De La Cruz");
        PersonView view = new PersonView(kloebner);
        kloebner.setMyView(view);
        new PersonCtrl(kloebner);
    }
}
