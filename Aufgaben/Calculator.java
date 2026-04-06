package Aufgaben;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*; // mit * kann man alle bibliotheken von javax.swing

public class Calculator extends JFrame{
        // b) - f) GUI kompon. deklarieren
        private JComboBox<Renter> renterBox; // b)
        
        private JRadioButton rbProWohnung; // c)
        private JRadioButton rbQuadratmeter;
        private JRadioButton rbBewohner;

        private JTextField tfBetrag; // d)
        private JButton btnOk; // e)

        private JLabel lblErgebnis;  // f)


    public Calculator() {  
        //a) Basis Einstellungen, FensterTitel, schließen,
        super("Nebenkosten-Kalkulator");  //Titel der JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fensterschließen können
        this.setLayout(new GridLayout(5, 2, 10, 40));  // import java.awt.GridLayout
        
        //b)JLabel für die Mieter-Auswahl
        this.add(new JLabel("Mieter:"));  //Label für Mieter:
        // JComboBox<>(Rasterauswahl) Mieterliste aus der statischen Konst. in Renter
        renterBox = new JComboBox<>(Renter.rentersInPasadena); //Liste von rentersInPasadena in JComboBox
        this.add(renterBox); //Hinzufü. zu der private JComboBox<Renter> renterBox

        //c) JRadioButtons, ButtonGroup, add
        this.add(new JLabel("Verrechnung:")); // JLabel "Verrechnung:"
        JPanel radioPanel = new JPanel (new GridLayout(3, 1));
        rbProWohnung = new JRadioButton("pro Wohnung");
        rbQuadratmeter = new JRadioButton("nach Quadratmeter", true);
        rbBewohner = new JRadioButton("nach Bewohnerinnen");
        //Buttongroup, sorgt dafür dass nur 1 gewählt werden kann
        ButtonGroup group = new ButtonGroup();
        group.add(rbProWohnung);
        group.add(rbQuadratmeter);
        group.add(rbBewohner);
        //Hinzufügen zu radioPanel
        radioPanel.add(rbProWohnung);
        radioPanel.add(rbQuadratmeter);
        radioPanel.add(rbBewohner);
        //Hinzufügen zu Fenster"Calculator"
        this.add(radioPanel);

        // d) JLabel für "Betrag" mit JTextField zum Eingeben
        this.add(new JLabel("Betrag:"));  //Label für Betrag:
        tfBetrag = new JTextField();  //tfBetrag oben ausserhalb der Classe deklarieren
        this.add(tfBetrag);
        
        // Platzhalter links leer lassen
        this.add(new JLabel(""));

        // e) OK_Button mit Logik und Berechnung    
        btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier kommt die Logik für den JButton btnOk: eine Methode zur Berechnung (ausserhalb der Klasse)
                berechneNebenkosten();
            }
            
        });
        this.add(btnOk);

        // f) Ergebnis Label
        lblErgebnis = new JLabel("Zu zahlender Betrag: ");
        this.add(lblErgebnis);

        //this.setSize(700, 700);
        this.pack(); //setSize automatisch anpassen
        this.setVisible(true);
    }

    //e) Methode Berechnung der Nebenkosten (JButton Logik)
    private void berechneNebenkosten(){

        // h) Fehlermeldung mit try-catch bei nicht Parsen von Dateneingaben
        try {
            
            //tfBetrag.getText()ruft den Inhalt des Textfeldes tfBetrag ab, 
            //Double.parseDouble() String in eine Zahl vom Typ double umwandeln.
            double gesamtBetrag = Double.parseDouble(tfBetrag.getText());
            double ergebnis = 0;
            Renter ausgewaehlterMieter = (Renter) renterBox.getSelectedItem();

            if(rbProWohnung.isSelected()){   // Gleichmäßig für alle Wohnungen verteilt
                ergebnis = gesamtBetrag / Renter.rentersInPasadena.length;
            } 
            else if (rbQuadratmeter.isSelected()){ // Berechnung nach Quadratmeter 
                double gesamtQm = 0;
                for (Renter renterX : Renter.rentersInPasadena){
                    gesamtQm = gesamtQm + renterX.getSquareMeter();
                }
                ergebnis = (gesamtBetrag / gesamtQm) * ausgewaehlterMieter.getSquareMeter();
            } 
            else if (rbBewohner.isSelected()){  // Berechnung nach Bewohner
                double gesamtPersonen= 0;
                for (Renter renterX : Renter.rentersInPasadena){
                    gesamtPersonen = gesamtPersonen + renterX.getPersons();
                }
                ergebnis = (gesamtBetrag / gesamtPersonen) * ausgewaehlterMieter.getSquareMeter();
            }

            // g) Formatierung auf 2 nachKommaStellen   
            DecimalFormat df = new DecimalFormat("€ 0.00"); //Hier Ausgabe mit €
            lblErgebnis.setText("Zu zahlender Betrag: " + df.format(ergebnis) + " $"); //Hier Ausgabe mit $

            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bitte einen gültigen Zahlenwert eingeben!", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
        }

        
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
