package op01;

import java.awt.Font;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Author: JulioJTLeiva
 * Description: This Program is sample for a new Window
 * version 1.1
 */

 @SuppressWarnings("serial")
public class demoTest2 extends JFrame //this generates a simple window
{
    public demoTest2()//Constructor
    {
        super("HERE IS A NEW WINDOW");
        Icon icon = new ImageIcon(getClass().getResource("duke.gif"));  //duke.gif  Plane.gif
        JLabel label = new JLabel("Buenos Dias!!!", icon, JLabel.CENTER);  //
        add(label);

        // Set font
        Font font =  new Font("SANS_SERIF", Font.BOLD, 50);//SANS_SERIF"
        label.setFont(font);
        label.setForeground(Color.BLUE);
        label.setBackground(Color.YELLOW);
        label.setOpaque(true);

        // Set X button funktion
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocation(150, 50);
        setVisible(true); //this input is what makes a new window appear, without it nothing can appear

    } 

    public static void main(String [] args) 
    {
        new demoTest2(); //Erstellen ein neues Fenster
        System.out.println("Hola!...");
    }
    
}
