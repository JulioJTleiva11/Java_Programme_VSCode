/*
Programm     : PersonPanel.java
Autor        : Julio Jesus Tomasto Leiva
Datum        : heute
Beschreibung : 
 */
package LAB_03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PersonPanel extends JPanel{
    //Attribute
    Person personToShow;

    //Konstruktor
    public PersonPanel(Person personToShow){  //Fenster kontruieren
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.gray);
        this.personToShow = personToShow;
    }

    @Override
    protected void paintComponent(Graphics g) {  //was ins Fenster gemalt wird, FensterInhalt
       super.paintComponent(g);
       //Prüfen ob person existiert
       if(personToShow != null ){
        //String text = personToShow.getAddress() + " " + 
                     // personToShow.getTitle() + " " + 
                     // personToShow.getGivenName() + " " + 
                     // personToShow.getSurname();
        g.setColor(Color.yellow);
        g.setFont(new Font("SansSerif", Font.BOLD, 15));
        g.drawString(personToShow.getAddress() + " " + 
                     personToShow.getTitle() + " " + 
                     personToShow.getGivenName() + " " +
                     personToShow.getSurname() + " geboren am: " + 
                     personToShow.getDay() + " " + 
                     personToShow.getMonth() + " " +
                     personToShow.getYear() + " ", 
                     getWidth()/4, 
                     getHeight()/2);
        //g.drawString(text, getWidth()/4, getHeight()/2); //so mittig wie möglich
       }
        
    }   

    
}
