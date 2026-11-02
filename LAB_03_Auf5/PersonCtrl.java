/*
Programm     : PersonCtrl.java
Autor        : Julio Jesus Tomasto Leiva
Datum        : heute
Beschreibung : 
 */
package LAB_03_Auf5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;


public class PersonCtrl extends JFrame implements ActionListener{
    //Attrib
    private JLabel anrede;
    private JRadioButton frau, herr, keiner;
    private JLabel titel, vorname, nachname;
    private JComboBox<String> comboBoxTitle;
    private static final String[] title = {"keine Auswahl", "Dr.", "Prof. Dr."};
    private JTextField textVorname, textNachname;
    private JLabel geborenAm;

    private JComboBox<Integer> tag;
    private DefaultComboBoxModel<Integer> modelTag;
    private JComboBox<String> monat;
    private static final String[] monate = {"Januar", "Februar", "März", "April", "Mai", "Juni", 
                               "Juli", "August", "September", "Oktober", "November", "Dezember"
    };
    private DefaultComboBoxModel<String> modelMonat;
    private JComboBox<Integer> jahr;
    private DefaultComboBoxModel<Integer> modelJahr;
    
    private JButton okButton;
    private Person personToShow;
    
    //Constructor
    public PersonCtrl(Person personToShow){
        super("FlowLayout Fenster zur Auswahl");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        this.personToShow = personToShow;
        //==================================================
        // HauptContainerPanel
        //==================================================
        Container c = getContentPane();  //malen aufs Fenster//c.setBackground(Color.red);
        
        //==================================================
        // CenterPanel 
        //==================================================
        JPanel centerPanel = new JPanel(new GridLayout(7, 3, 5, 5));
        centerPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
        centerPanel.setBackground(Color.lightGray);

        //==================================================
        // Zeilen-Panel JLabel, JRadioButton, JButton, JtextField...
        //==================================================
        //1. Zeile
        JPanel zeile1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        //zeile1.setBackground(Color.green);
        anrede = new JLabel("Anrede:");
        
        //2. Zeile
        JPanel zeile2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        frau = new JRadioButton("Frau", true);
        herr = new JRadioButton("Herr");
        keiner = new JRadioButton("keiner");
        //JRadioButtons zur ButtonGroup
        ButtonGroup auswahl = new ButtonGroup();
        auswahl.add(frau);
        auswahl.add(herr);
        auswahl.add(keiner); 

        //3. Zeile
        JPanel zeile3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        titel = new JLabel("Titel:");
        vorname = new JLabel("Vorname:");
        nachname = new JLabel("Nachname:");

        //4.Zeile
        JPanel zeile4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        comboBoxTitle = new JComboBox<String>(title);
        comboBoxTitle.setPreferredSize(new Dimension(100, 50));// Modifizieren der Grösse vom Button
        comboBoxTitle.setSelectedIndex(2); //selektiere was erscheint im JComboBox
        textVorname = new JTextField("Ymelda", 15);
        textVorname.setPreferredSize(new Dimension(100, 50));// Modifizieren der Grösse vom Button
        textNachname = new JTextField("Leiva De La Cruz", 15);
        textNachname.setPreferredSize(new Dimension(100, 50));// Modifizieren der Grösse vom Button

        //Zeile 5
        JPanel zeile5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        geborenAm = new JLabel("Geboren am:");       
        
        //Zeile 6
        JPanel zeile6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        modelTag =  new DefaultComboBoxModel<>();//Model für Tage
        for (int i = 1; i <=31; i++){
            modelTag.addElement(i);
        }
        tag = new JComboBox<>(modelTag);
        tag.setPreferredSize(new Dimension(90, 50));// Modifizieren der Grösse vom Button
        tag.setSelectedIndex(7); //Selektiere welcher Index erscheint im JComboBox

        modelMonat = new DefaultComboBoxModel<>(monate);//Model für Monate
        monat = new JComboBox<>(modelMonat);
        monat.setPreferredSize(new Dimension(90, 50));// Modifizieren der Grösse vom Button
        monat.setSelectedIndex(9); //Selektiere welcher Index erscheint im JComboBox

        modelJahr = new DefaultComboBoxModel<>();//Model für Jahre
        for (int i = 1900; i <= 2027; i++){
            modelJahr.addElement(i);
        }
        jahr = new JComboBox<>(modelJahr);
        jahr.setPreferredSize(new Dimension(90, 50));// Modifizieren der Grösse vom Button
        jahr.setSelectedIndex(49);
        
        //Zeile 7
        JPanel zeile7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        okButton = new JButton("OK");
        okButton.setToolTipText("Eingabe Bestätigen");
        okButton.setPreferredSize(new Dimension(80, 60));// Modifizieren der Grösse vom Button
        okButton.addActionListener(this);
        //okButton.addActionListener(e -> System.out.println("Button wurde geklickt!"));//test ob es funkt.      

        //==================================================
        // add zu Fenster(Container c): Zeilen-Panel -> centerPanel -> Container c 
        //==================================================
        zeile1.add(anrede);
        centerPanel.add(zeile1);
        c.add(centerPanel);

        zeile2.add(herr);
        zeile2.add(Box.createHorizontalStrut(100));//Abstand zu anderen JRadioButton
        zeile2.add(frau);
        zeile2.add(Box.createHorizontalStrut(100));
        zeile2.add(keiner);
        centerPanel.add(zeile2);
        c.add(centerPanel);

        zeile3.add(titel);
        zeile3.add(Box.createHorizontalStrut(100));//Abstand zum anderen Feld
        zeile3.add(vorname);
        zeile3.add(Box.createHorizontalStrut(100));//Abstand zum anderen Feld
        zeile3.add(nachname);
        centerPanel.add(zeile3);
        c.add(centerPanel);

        zeile4.add(comboBoxTitle);
        zeile4.add(Box.createHorizontalStrut(20));//Abstand zum anderen Feld
        zeile4.add(textVorname);
        zeile4.add(Box.createHorizontalStrut(20));//Abstand zum anderen Feld
        zeile4.add(textNachname);
        centerPanel.add(zeile4);
        c.add(centerPanel);

        zeile5.add(geborenAm);
        centerPanel.add(zeile5);
        c.add(centerPanel);       

        zeile6.add(tag);
        zeile6.add(Box.createHorizontalStrut(80));//Abstand zum anderen Feld
        zeile6.add(monat);
        zeile6.add(Box.createHorizontalStrut(80));//Abstand zum anderen Feld
        zeile6.add(jahr);
        centerPanel.add(zeile6);
        c.add(centerPanel);
        
        zeile7.add(okButton);
        centerPanel.add(zeile7);
        c.add(centerPanel);

        setLocation(new Point(90, 80));
        setSize(new Dimension(500, 700));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //der letzte okButton entscheidet
        if(e.getSource() == okButton){ //Fall der okButton gedruck wurde
            //zeile2 JRadioButtons
            if(herr.isSelected()){
                personToShow.setAddress("Herr");
            }
            else if (frau.isSelected()){
                personToShow.setAddress("Frau");
            }
            else if (keiner.isSelected()){
                personToShow.setAddress(" ");
            }

            //zeile4 comboBox und Texteingabe
            int titelSelected = comboBoxTitle.getSelectedIndex();
            if(titelSelected == 0){
                personToShow.setTitle(" ");
            }
            else if (titelSelected == 1){
                personToShow.setTitle("Dr. ");
                //personToShow.setTitle(title[titelSelected]);
            }
            else if(titelSelected == 2){
                personToShow.setTitle("Prof. Dr. ");
            }

            String eingabe1 = textVorname.getText();   
            if(!eingabe1.isEmpty()){
                personToShow.setGivenName(eingabe1);
            }
            String eingabe2 = textNachname.getText();
            if(!eingabe2.isEmpty()){
                personToShow.setSurname(eingabe2);
            }

            //zeile6 JComboBox mit Integer und Object,Trycatch (Problem!)
            Object tagSelected = tag.getSelectedIndex(); //
            try {
                // Den Text direkt in eine Zahl umwandeln – ohne Array!
                int tagAlsZahl = Integer.parseInt(tagSelected.toString());
                personToShow.setDay(tagAlsZahl + 1);
            } 
            catch (NumberFormatException ex) {
                // Sicherheitshalber, falls das Parsen fehlschlägt
                personToShow.setDay(5);
            }
            //zeile6 JComboBox mit String 
            int monatSelected = monat.getSelectedIndex();
            if(monatSelected == 0){
                personToShow.setMonth("März");
            }
            else {
                personToShow.setMonth(monate[monatSelected]);  
            }
            //zeile6 JComboBox mit Integer (Problem!)  
            Integer jahrSelected = (Integer) jahr.getSelectedItem();
            if (jahrSelected != null) {
                // Setzt direkt die vierstellige Zahl (z. B. 1950) in dein Objekt
                personToShow.setYear(jahrSelected); 
            } else {
                // Falls aus irgendeinem Grund nichts ausgewählt ist
                personToShow.setYear(2027); 
            }



            
        }
    }

}
