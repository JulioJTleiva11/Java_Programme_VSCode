package Lab03;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Tarifrechner extends JFrame implements ActionListener {

    //2 RadioButtons 
    private JRadioButton moFr;
    private JRadioButton saSo;

    //JLabel1
    private JTextField anzahlPersonen; //???

    //comboBox
    private JComboBox <String> comboBoxTicket;
    private static final String[] ticket = {"Kurzstrecke", "Innerer Ring", "Ganze Stadt", "Tagesticket"};
    private static final double[] ticketPreis = {1.00, 2.2, 3.6, 8.2};

    //JLabel2

    //JText

    //JButton "Berechnen"

    //Jtext berechnet

    //Konstruktor
    public Tarifrechner (){
        super("Tarifrechner");//Titel des Fensters
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.green);
        c.setLayout(new GridLayout(0, 2, 20, 20));
        

        //RadioButtons erstellen, hinzufügen und RadioButtonsGroup
        moFr = new JRadioButton("Mo-Fr", true);
        saSo = new JRadioButton("Sa-So");
        c.add(moFr);
        //moFr.addActionListener(this);//nicht notwendig
        c.add(saSo);
        ButtonGroup tage = new ButtonGroup();
        tage.add(moFr);
        tage.add(saSo);

        //Label
        c.add(new JLabel("Tarif"));
        
        
        setSize(700, 700);
        setVisible(true);
    }

    //Main
    public static void main(String[] args) {
        new Tarifrechner();//neues Object Fenster erzeugt
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
