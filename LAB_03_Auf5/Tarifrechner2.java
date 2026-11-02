package LAB_03_Auf5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Tarifrechner2 extends JFrame{

    //Attrib    
    private JRadioButton moFr, saSo;
    private JLabel tarifLabel;
    private JComboBox <String> ticket;
    private static final String[] tarif = {"Kurzstrecke", "Innerer Ring", "Ganze Stadt", "Tagesticket"};
    private static final Double[] kosten = {1.00, 2.20, 3.60, 8.20};
    private JLabel anzahlPersonen;
    private JTextField anzahlTicket;
    private JButton berechne;
    private JLabel preis;

    //Constructor
    public Tarifrechner2 (){
        //JFrame Grund-Attrib
        super("Tarifrechner2");    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        //==================================================
        // HauptPanel Container c
        //==================================================
        Container c = getContentPane();

        //==================================================
        // centerPanel 
        //==================================================
        JPanel centerPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        centerPanel.setBackground(Color.lightGray);
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        //==================================================
        // Zeilen-Panel Attributte definieren: JLabel, JRadioButton, JButton, JtextField 
        //==================================================
        //zeile1: JPanel, JRadiobutton + ButtonGroup
        JPanel zeile1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 70));
        moFr = new JRadioButton("Mo-Fr", true);
        saSo = new JRadioButton("Sa-So");
        ButtonGroup auswahlJRadioButton = new ButtonGroup();
        auswahlJRadioButton.add(moFr);
        auswahlJRadioButton.add(saSo);

        //zeile2 
        JPanel zeile2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 60));
        tarifLabel = new JLabel("Tarif:");
        ticket = new JComboBox<>(tarif);
        ticket.setPreferredSize(new Dimension(200, 50));
        ticket.setSelectedIndex(3);

        //zeile3
        JPanel zeile3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 70));
        anzahlPersonen = new JLabel("Anzahl Personen:");
        anzahlTicket = new JTextField("2");
        anzahlTicket.setPreferredSize(new Dimension(200, 50));// Modifizieren der Grösse vom Button

        //zeile4 
        JPanel zeile4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 70));
        berechne = new JButton("Berechne:");
        berechne.setPreferredSize(new Dimension(200, 50));// Modifizieren der Grösse vom Button
        preis = new JLabel("12.30€");
        berechne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {                
                berechnePreis();
            }
            
        });

        //==================================================
        // add zu Fenster: zeile1.add(attribut) -> centerPanel.add(zeile1) -> Container c.add(centerPanel) 
        //==================================================
        zeile1.add(moFr);
        zeile1.add(Box.createHorizontalStrut(170));//Abstand zu anderen JRadioButton ************
        zeile1.add(saSo);
        centerPanel.add(zeile1);
        c.add(centerPanel);

        zeile2.add(tarifLabel);
        zeile2.add(Box.createHorizontalStrut(200));//Abstand zu anderen JRadioButton ************
        zeile2.add(ticket);
        centerPanel.add(zeile2);
        c.add(centerPanel);

        zeile3.add(anzahlPersonen);
        zeile3.add(Box.createHorizontalStrut(125));//Abstand zu anderen JRadioButton ************
        zeile3.add(anzahlTicket);
        centerPanel.add(zeile3);
        c.add(centerPanel);

        zeile4.add(berechne);
        zeile4.add(Box.createHorizontalStrut(30));//Abstand zu anderen JRadioButton ************
        zeile4.add(preis);
        centerPanel.add(zeile4);
        c.add(centerPanel);

        //JFrame Grund-Attrib
        setSize(new Dimension(500, 700));   //Fenstergröße
        setLocation(new Point(400, 100));   // Fensterposition
        setVisible(true);                   // Fenstersichtbarkeit
    }

    //Main
    public static void main(String[] args) {
        new Tarifrechner2();  //neues Fenster erzeugen
    }

    //ActionListener
    protected void berechnePreis() {
        //Try-Catch
        try {
            //String auslesen und in Integer umwandeln mit Fehlermeldung
            String input = anzahlTicket.getText().trim();//auslesen der JTextField und speichern in input
            Integer inputToInt = Integer.parseInt(input);//input in Interger umwandeln 
            if(inputToInt <= 0){
                preis.setText("Eingabe > 0 bitte!");
            }

            //Ticket- und Preise-Array heiraten
            int auswahlComboBox = ticket.getSelectedIndex();
            double auswahlPreis = kosten[auswahlComboBox];
            if(saSo.isSelected()){
                auswahlPreis *= 0.75;
            }

            //gesamtpreisberechnung und DezimalFormatierung 
            double gesamtpreis = auswahlPreis * inputToInt;
            DecimalFormat df = new DecimalFormat("0.00");//Hier mit Punkt!!!
            preis.setText(df.format(gesamtpreis) + " €");
        } 
        catch (NumberFormatException e) {
            preis.setText("Ungültige Zahl!");
        }
        catch (Exception ex){
            preis.setText("Ungültige Eingabe!");
        }
    }
}
