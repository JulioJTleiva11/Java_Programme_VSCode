package Lab4;

import java.awt.*;

import javax.swing.*;

public class PersonView extends JFrame{
    //Attrib
    //Hier muss man ein neues JPanel erstellen für personToShow und nicht "Person personToShow" deklarieren
    JPanel panel = new JPanel();

    //Constructor
    public PersonView (Person personToShow){
        //JFrame Grund-Attrib
        super("PersonenDaten");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new PersonPanel(personToShow);
        add(panel);

        setSize(new Dimension(700, 500));
        setLocation(new Point(490, 80));
        setVisible(true);

    }
    //Main
    public static void main(String[] args) {
        Person kloebner = new Person("Herr", "Dr.", "Anton", "Kloebner");
        PersonView view = new PersonView(kloebner);
        
    }
    //ActionListener
        //Try-Catch

}
