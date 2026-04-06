/* Programm : PersonenView.java
   Autoren  : Julio Jesus Tomasto Leiva
   Datum    : 11.12.2024
*/

package Lab03;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonView extends JFrame {//Klasse PersonView, die von JFrame abgeleitet
    public PersonView(Person personToShow){ //1Kosntruktor fürs Fenster
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //2 Fenster schließen können
        JPanel pan = new PersonPanel(personToShow); //neues Panel
        
        add(pan);
        //setBounds(250, 250, 800, 400); //leiber nicht-Position und Größe des Fensters
        setSize(new Dimension(700,400)); //besser
        setLocation(new Point(590,80));
        //setResizable(false);//false = FensterGröße nicht verändertbar
        setTitle("PersonenDaten"); //title für die GUI
        setVisible(true); //gui visible machen
        
    }

    public static void main(String[] args) {
        //neue Person erstellen fürs Panel anzeigen lassen
        Person Samuel = new Person("Herr", "Dr.", "Samuel", "T. C.");
        PersonView SamuelView = new PersonView(Samuel); //neue Gui erstellen
        Samuel.setMyView(SamuelView); //neues Attribut in Person mit setter + setter modifizierung sowie Konstruktor
        new PersonCtrl(Samuel);

    }
}
