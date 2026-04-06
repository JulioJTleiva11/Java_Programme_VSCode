package Lab03;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PersonCtrl extends JFrame implements ActionListener{
    
    /*JRadioButton's, , ComboBox, */
    //Attribut 3 JRadioButtons Herr Frau keine 
    private JRadioButton herr;
    private JRadioButton frau;  
    private JRadioButton keine;

    //Attribut: 2 Labels für Textfelder: Vor- und Nachname 
    private JTextField givenName;    //Vorname
    private JTextField surname;

    //Attribut: 1x JComboBox mit dreiAuswahl:Keine, Dr., Prof. Dr.
    private JComboBox<String> comboBoxTitle;
    private static final String[] title = {"keine Auswahl", "Dr.", "Prof. Dr."};
    
    //Attribut: Ok-JButton eingabe fertig
    private JButton okButton;

    //Objekt der Klasse Person
    private Person personToShow;

    //Konstruktor der Klasse PersonCtrl mit Verbindungsparameter
    //des Konstruktors von der Klasse Person
    public PersonCtrl (Person personToShow){

        super("FlowLayout Fenster zur Auswahl");//Aufruf des Konstruktors der Oberklasse
        this.personToShow = personToShow;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);//FensterGröße änderbar?
        
        /* Container Features */
        Container c = getContentPane(); //malen aufs Fenster
        c.setBackground(Color.cyan); //Color Hintergrund
        c.setLayout(new GridLayout(5,2,11,11));//hgap=abstand in x, vgap=abstand in Y
        
        /* RadioButtons, kreisformig zum anklicken/auswählen, brauchen Buttongroup!!!*/
        herr = new JRadioButton("Herr", true); //true=ausgewählt
        // herr.addActionListener(this); //nicht nötig, da...
        frau = new JRadioButton("Frau");
        // frau.addActionListener(this); //nicht nötig
        keine = new JRadioButton("keine");
        //keine.addActionListener(this);  //nicht nötig

        /*RadioButtons zur ButtonGroup hinzufügen, beim Klicken wird dann 
        nur einer von den Button ausgewählt und nicht alle gleichzeitig*/
        ButtonGroup einerAuswahl = new ButtonGroup();
        einerAuswahl.add(herr);
        einerAuswahl.add(frau);
        einerAuswahl.add(keine);

        /*Buttons ans Fenster brinden*/
        c.add(herr);
        c.add(frau);
        c.add(keine);


        /*KomboBox Button, klick und erscheint eine Liste zur Auswahl */
        comboBoxTitle = new JComboBox<String>(title);
        //comboBoxTitle.addActionListener(this);//nicht nötig
        comboBoxTitle.setSelectedIndex(2);//index0:"keine Auswahl", index1:"Dr.", index2:"Prof. Dr."

        /*ComboBox Button ans Fenster brinden */
        c.add(comboBoxTitle);

        /*givenName LJabel() */
        c.add(new JLabel("Vorname: "));  //Label "Vorname: "
        givenName = new JTextField(50); //max 50 Char Eingabe
        /*JTextField() Feld wo man schreibt für Vorname */
        c.add(givenName); //hier erscheint das Feld zum Schreiben
        givenName.addActionListener(this); //nicht nötig

        /*surname JLabel (icon, Text ...) */
        c.add(new JLabel("Nachname: ")); //Label Nachname
        surname = new JTextField(50);//max 50 char Eingabe
        /*JTextField() Feld wo man schreibt für Nachname, ins Fenster bringen */        
        c.add(surname);//erscheint das Feld zum schreiben
        surname.addActionListener(this);//in diesem Fall unnötig
        
        //OkButton erstellen
        okButton = new JButton("OK");
        okButton.setToolTipText("Eingabe Bestätigen");
        okButton.addActionListener(this); 

        /*OkButton ans Fenster brinden */
        c.add(okButton);

        //Visible? und Größe 
        setSize(500,500);
        setVisible(true);

    }
    
    /*Kalibrierung der okButton */
    @Override
    public void actionPerformed(ActionEvent e) { //Methode der actionListener
       // okButton aktiv machen mit getSource()  
        if(e.getSource() == okButton){ //der letzte Button, also okButton, ist zuerst als if(){}
            //getSource(), ob der Button aktiviert wurde?
            if(herr.isSelected()){
                personToShow.setAddress("Herr");
            }
            else if(frau.isSelected()){
                personToShow.setAddress("Frau");
            }
            else {  //else if (keine.isSelected())
                personToShow.setAddress(" ");
            }

            //Angaben für Vorname und Nachname
            String givenNameString = givenName.getText();//.trim();//String um die Eingabe zu speichern/übergeben
            if(!givenNameString.isEmpty()){ //falls die Eingabe nicht leer ist
                personToShow.setGivenName(givenNameString);
            }
            String surnameString = surname.getText();
            if(!surnameString.isEmpty()){
                personToShow.setSurname(surnameString);
            }

            //ComboBox Definition
            int select = comboBoxTitle.getSelectedIndex();//int für EingabeSpeicherung
            if(select == 0){
                personToShow.setTitle(" ");
            }
            else{
                personToShow.setTitle(title[select]);;
            }

        }
        
        
    
    }
    

    



}
