package HSL_VL;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BSP_BOXLayout extends JFrame{
    //GUI-Komponenten
    private JButton button1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JLabel label1;


    //GUI_Konstruktor
    public BSP_BOXLayout(){
        super("BSP-Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // 1. Panel erstellen und BoxLayout zuweisen (Y_AXIS = von oben nach unten)
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        //panel1.setLayout(new GridLayout(7, 2, 5, 5));
        

        //JButton init
        button1 = new JButton("Button1");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT); // nur zu zentrieren
        panel1.add(button1);
        //this.add(panel1); //ganz am Ende alles hinzufügen

        //JTextField init
        textField1 = new JTextField("JTextField1");
        panel1.add(textField1);
        


        this.add(panel1); //ganz am Ende alles hinzufügen

        // 2. Label erstellen und Text hinzufügen (wichtig für die Sichtbarkeit)
        JLabel label2 = new JLabel("Hier steht Ihr Label-Text");        
        
        // Label im BoxLayout horizontal zentrieren
        //label1.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 3. Der korrigierte Rahmen (mit Punkten und Komma!)
        label2.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));

        // 4. Komponenten zusammenfügen
        panel1.add(label2);       // Label zum Panel hinzufügen
        //this.add(panel);         // Panel zum JFrame hinzufügen


        //this.setVisible(true);  //siehe bei der Main!
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new BSP_BOXLayout().setVisible(true);
        });
    }

}
