package Lab03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PersonPanel extends JPanel{

    Person personToShow; //attribut deklarieren für den Konstruktor unten

    //konstruktor, eigenschaften von der Malfläche + this.atribut = atribut
    public PersonPanel(Person personToShow){
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.gray);
        this.personToShow = personToShow;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //+++++++System.out.println("repaint");
        g.setColor(Color.LIGHT_GRAY); //hintergrundsfarben
        g.setFont(new Font("Monospaced", Font.BOLD, 48));
        g.drawString(personToShow.getAddress() + " " + 
                    personToShow.getTitle() + " " 
                    + personToShow.getGivenName() + " " 
                    + personToShow.getSurname(), 45, getHeight()/2); //besser...20, getHight()/2);
    }

}
