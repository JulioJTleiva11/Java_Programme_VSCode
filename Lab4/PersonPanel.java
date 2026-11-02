package Lab4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class PersonPanel extends JPanel{
    //Attrib
    Person personToShow;

    //Constructor fürs Panel
    public PersonPanel(Person personToShow){
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.green);
        this.personToShow = personToShow;
    }

    @Override  //hier wird ins Fenster einen Name als String gemalt
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (personToShow != null){
            g.setColor(Color.red);  //Schriftcolor
            g.setFont(new Font("SansSerif", Font.BOLD, 25));//SchriftArt, Größe
            g.drawString(personToShow.getAddress() + " " + 
                            personToShow.getTitle() + " " + 
                            personToShow.getGivenName() + " " + 
                            personToShow.getSurname(), 
                            getWidth()/4, 
                            getHeight()/2);
        }
    }

    

}
