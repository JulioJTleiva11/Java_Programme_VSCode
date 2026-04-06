package Aufgaben;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculator1 extends JFrame{

    // b) - f) GUI kompon. deklarieren
    private JComboBox<Renter> renterBox;//b)
    private JRadioButton rbProWohnung, rbQuadratmeter, rbBewohner;// c)
    private JTextField tfBetrag;// d)
    private JButton btnOk;// e)
    private JLabel lblErgebnis;// f)
    
    public Calculator1(){
        //A Basis Einstellungen, FensterTitel, schließen
        super("Nebenkosten-Kalkulator1");          //Titel der JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Fensterschließen können
       
        //Hauptlayout Borderlayout mit Abstand zum Rand
        this.setLayout(new BorderLayout(15,15));

        //Zentrum das Eingabegitter Centerpanel 4xZeilen 2xSpalte
        JPanel centerPanel = new JPanel(new GridLayout(5, 2, 10, 20));

        //B Links 1 Zeile Mieter und add to centerpanel
        centerPanel.add(new JLabel("Mieter: "));
        //B Rechts 2 RenterBox JComboBox
        renterBox = new JComboBox<>(Renter.rentersInPasadena);
        centerPanel.add(renterBox);

        //C Links 3 JLabel Verrechnung
        JPanel labelNord = new JPanel(new BorderLayout());  //Um lblText nordlich zu positionieren
        JLabel lblText = new JLabel("Verrechnung: ");  //centerPanel.add(new JLabel("Verrechnung: "));
        labelNord.add(lblText, BorderLayout.NORTH);          //nordlich positionieren
        centerPanel.add(labelNord);                          //zum centerpanel hinzufügen

        //C Rechts 4 JRadioButtons
        JPanel radioPanel = new JPanel(new GridLayout(3, 1));//JPanel für die JRadioButtoms
        rbProWohnung = new JRadioButton("pro Wohnung");
        rbQuadratmeter = new JRadioButton("nach Quadratmetern", true);
        rbBewohner = new JRadioButton("nach Bewohnerinnen");

        ButtonGroup group = new ButtonGroup(); //Damit die JRadioButtoms nur einmal ausgewählt werden
        group.add(rbProWohnung);
        group.add(rbQuadratmeter);
        group.add(rbBewohner);

        radioPanel.add(rbProWohnung);
        radioPanel.add(rbQuadratmeter);
        radioPanel.add(rbBewohner);

        centerPanel.add(radioPanel); // der kleiner Panel zum großen Panel hinzufügen

        // D 5 Zeile: Betrag links
        centerPanel.add(new JLabel("Betrag: "));
        // 6 JTextField betrageingabe rechts
        tfBetrag = new JTextField();
        centerPanel.add(tfBetrag);

        // 7 Platzhalter leer lassen links
        centerPanel.add(new JLabel(""));

        //E 8 Der OK-Button rechts
        btnOk = new JButton("OK");
        //Button mit actionslistener, damit der Buttom etwas macht
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechneNebenkosten(); //s.u. "private void berechneNebenkosten()"
            }
        });
        centerPanel.add(btnOk);

        // F JLabel für  lblText und lblErgebnis
        lblText = new JLabel("Zu zahlender Betrag : ");   //JLabel mit Text zum Anzeigen
        lblErgebnis = new JLabel();                             // JLabel für das berechnete Ergebnis
        centerPanel.add(lblText);      //hinzufügen vom JLabel lblText zu centerPanel
        centerPanel.add(lblErgebnis);  //hinzufügen vom JLabel lblErgebnis zu centerPanel
 
        this.add(centerPanel, BorderLayout.CENTER);  //Zentrierung und hinzufügen zum GUI
        
        this.setSize(700, 700); //this.pack();
        this.setVisible(true);  // Frame visible
    }
    
    //e) Methode Berechnung der Nebenkosten (JButton Logik)
    private void berechneNebenkosten() {
        // h) Fehlermeldung mit try-catch um Double.parseDouble() bei nicht Parsen von Dateneingaben
        try {
            //try-catch verhindert Abstürze bei Texteingabe
            //Die Zeile wandelt Benutzereingaben aus einem Textfeld in eine Zahl um.
            double gesamtBetrag = Double.parseDouble(tfBetrag.getText());//Texteingabe von JTextField(tfBetrag)
            double ergebnis = 0;
            Renter ausgewaehlterMieter = (Renter) renterBox.getSelectedItem();//welche von JComboBox ausgewählt

            //Falls einer der 3 JRadioButton gedrückt/ausgewählt
            // Berechnung gleichmäßig verteilt
            if(rbProWohnung.isSelected()){
                ergebnis = gesamtBetrag / Renter.rentersInPasadena.length; //Betrag durch die Anteil der Mieter
            } 
            // Berechnung nach Quadratmeter
            else if(rbQuadratmeter.isSelected()){
                double gesamtQm = 0;
                // Die Schleife durchläuft das rentersInPasadena-Array: public static final Renter[] rentersInPasadena = {...};
                for (Renter renterX : Renter.rentersInPasadena){//renterX ist temporären Variable
                    gesamtQm = gesamtQm + renterX.getSquareMeter(); //Summe aller Quadratmeter
                    if (renterX != null) System.out.println(renterX.getName()); //Nur als Beispiel zum Anzeigen der Mitglieder
                }
                ergebnis = (gesamtBetrag / gesamtQm) * ausgewaehlterMieter.getSquareMeter();//anteil des einzelnen Mieter
            } 
            // Berechnung nach Bewohner
            else if(rbBewohner.isSelected()){
                double gesamtPersonen = 0;
                for (Renter renterX : Renter.rentersInPasadena){
                    gesamtPersonen = gesamtPersonen + renterX.getPersons(); //Summe aller Personen
                }
                ergebnis = (gesamtBetrag / gesamtPersonen) * ausgewaehlterMieter.getSquareMeter();//anteil des einzelnen Mieter
            }

            // g) Formatierung auf 2 nachKommaStellen   
            DecimalFormat df = new DecimalFormat("0.00 €"); //
            lblErgebnis.setText(df.format(ergebnis)); //lblErgebnis wird neu gesetzt auf "ergebnis"

        } catch (NumberFormatException e) { //Fehlermeldung mit Info Fenster
            JOptionPane.showMessageDialog(this, "Bitte einen gültigen Zahlenwert eingeben!", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
        }

    }    
    public static void main(String[] args) {
        new Calculator1();
    }
}
