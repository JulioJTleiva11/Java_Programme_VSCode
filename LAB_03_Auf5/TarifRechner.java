package LAB_03_Auf5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TarifRechner extends JFrame implements ActionListener{ 

    //Attrib
    private JRadioButton moFr, saSo;
    private JLabel tarif;
    private JComboBox <String> ticket;
    private static final String[] ticketArt = {"Kurzstrecke", "Innerer Ring", "Ganze Stadt", "Tagesticket"};
    private static final Double[] preise = {1.00, 2.20, 3.60, 8.20};
    private JLabel anzahlPersonen;
    private JTextField anzahl;
    private JButton berechne;
    private JLabel preisLabel;

    //Constructor
    public TarifRechner(){
        //JFrame Grund-Attrib
        super("Tarifrechner");
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
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));// ************
        centerPanel.setBackground(Color.lightGray);

        //==================================================
        // Zeilen-Panel JLabel, JRadioButton, JButton, JtextField 
        //==================================================
        //zeile1
        JPanel zeile1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 60)); //zeile1.setBackground(Color.green);
        moFr = new JRadioButton("Mo-Fr", true);
        saSo = new JRadioButton("Sa-So");
        ButtonGroup woche = new ButtonGroup();
        woche.add(moFr);
        woche.add(saSo);

        //zeile2
        JPanel zeile2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 50));
        tarif = new JLabel("Tarif:");
        ticket = new JComboBox<>(ticketArt);
        ticket.setPreferredSize(new Dimension(200, 50));// Modifizieren der Grösse vom Button ************
        ticket.setSelectedIndex(3); //selektiere was erscheint im JComboBox  ************  

        //zeile3
        JPanel zeile3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 70));
        anzahlPersonen = new JLabel("Anzahl Personen: ");
        anzahl = new JTextField("2");
        anzahl.setPreferredSize(new Dimension(200, 50));// Modifizieren der Grösse vom Button

        //zeile4
        JPanel zeile4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 60));
        berechne = new JButton("Berechne/Preis: ");
        berechne.setPreferredSize(new Dimension(200, 50));        
        berechne.addActionListener(this);  //addActionListener
        preisLabel = new JLabel("12,30");
        
        //==================================================
        // add zu Fenster(Container c): Zeilen-Panel -> centerPanel -> Container c 
        //==================================================
        zeile1.add(moFr);
        zeile1.add(Box.createHorizontalStrut(170));//Abstand zu anderen JRadioButton ************
        zeile1.add(saSo);
        centerPanel.add(zeile1);
        c.add(centerPanel);

        zeile2.add(tarif);
        zeile2.add(Box.createHorizontalStrut(200));//Abstand zu anderen JRadioButton ************
        zeile2.add(ticket);
        centerPanel.add(zeile2);
        c.add(centerPanel);

        zeile3.add(anzahlPersonen);
        zeile3.add(Box.createHorizontalStrut(125));//Abstand zu anderen JRadioButton ************
        zeile3.add(anzahl);
        centerPanel.add(zeile3);
        c.add(centerPanel);

        zeile4.add(berechne);
        zeile4.add(Box.createHorizontalStrut(30));//Abstand zu anderen JRadioButton ************ 
        zeile4.add(preisLabel);
        centerPanel.add(zeile4);
        c.add(centerPanel);

        //JFrame Grund-Attrib
        setLocation(new Point(400, 100));//
        setSize(new Dimension(500, 700));
        setVisible(true);
    }

    //Main
    public static void main(String[] args) {
        new TarifRechner();// ...
    }

    //ActionListener
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Try-Catch
        try {
            //if(berechne.isSelected()){ // funktioniert NICHT bei JButton, aber bei JRadioButton schon?
                //String auslesen und in integer umwandeln
                String eingabe = anzahl.getText().trim();//trim() bereinigt den String von Spaces
                Integer eingabeInt = Integer.parseInt(eingabe);                
                if(eingabeInt <= 0){
                    preisLabel.setText("ERROR");
                    return;
                }

                //Basispreis ermitteln
                int auswahlTarif = ticket.getSelectedIndex();
                double auswahlPreis = preise[auswahlTarif];
                if(saSo.isSelected()){
                    auswahlPreis *= 0.75;
                }

                // 4. Gesamtpreis berechnen
                double gesamtPreis = (auswahlPreis * eingabeInt);

                // 5. Double Formatierung auf exakt zwei Nachkommastellen
                DecimalFormat df = new DecimalFormat("0.00");
                preisLabel.setText(df.format(gesamtPreis) + " €"); 
            //}
        } 
        catch (NumberFormatException e) {
            preisLabel.setText("Ungültige Zahl!");
        }
        catch (Exception ex){
            preisLabel.setText("Ungültige Eingabe!");
        }
    }

}
