package HSL_SS24.Auf3_GUI;

import java.awt.BorderLayout; //Muss oben(also hier) sein, sonst Fehler
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FrequenzGenerator extends JFrame implements ActionListener {
    //GUI Komponenten
    private ZeichenPanel zeichenPanel;
    private JLabel anzahlPeriod;
    private JTextField periodenEingabe; //     
    private JButton aktualisiereBtn;
    

    //GUI Konstruktor
    public FrequenzGenerator(){
        //Basiseinstellungen des Fensters
        super("Frequenz-Generator");//super() ruft den Konstruktor der Oberklasse JFrame als erstes Deklarieren!
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Schließen mit X
        setSize(500, 500);   //oder this.pack(); mit automatischer Größe-Festlegung
        setLocationRelativeTo(null);    // Fenster in der Mitte platzieren
        setResizable(false);    //Anforderung 1, FensterGröße nicht resizable/veränderbar

        //Steuerungspanel unteren Rand 1 Zeile, 3 Spalten und Abstand 5 pxl
        JPanel steuerungsPanel = new JPanel();  //muss mit import java.awt.BorderLayout; 
        steuerungsPanel.setLayout(new GridLayout(1, 3, 5, 5));
        
        zeichenPanel = new ZeichenPanel();
        // von links nach rechts Panel aufbauen:JLabel, JTextField ...
        anzahlPeriod = new JLabel("Anzahl Perioden: ", JLabel.CENTER);
        steuerungsPanel.add(anzahlPeriod);  // hinzufügen von JLabel
        
        periodenEingabe = new JTextField("2.6");
        periodenEingabe.setHorizontalAlignment(JTextField.CENTER); // zentrieren von JTextField
        steuerungsPanel.add(periodenEingabe); // hinzufügen von JTextField

        aktualisiereBtn = new JButton("Aktualisiere");
        aktualisiereBtn.addActionListener(this);
        steuerungsPanel.add(aktualisiereBtn);  // hinzufügen von JButton

        //Alles im Haptfenster und unten anordnen
        this.add(zeichenPanel, BorderLayout.CENTER);
        this.add(steuerungsPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    // Event Handling actionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aktualisiereBtn){
            String input = periodenEingabe.getText().trim();

            try {
                double perioden = (double) Double.parseDouble(input);
                
                if(perioden <= 3.0 && perioden >= 1.0){
                    zeichenPanel.setPeriodenAnzahl(perioden);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Wert größer als 1 und kleiner als 3.0 eigeben", "ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "ungültiges format, bitte noch mal eingeben", "ungültige Eingabe", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    //Innere Klasse für das Koord. //eigen. Klasse die vom JPanel erbt
    private class ZeichenPanel extends JPanel{
        private double periodenAnzahl = 1.0;
        
        //Hintergrund  in Weiß
        public ZeichenPanel(){
            setBackground(Color.WHITE);
        }

        //SetterMethod um Periodenanzahl zun ändern mit repaint();
        public void setPeriodenAnzahl(double perioden) {
            this.periodenAnzahl = perioden;
            repaint();
        }

        
        //Method für die Graphik
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = this.getWidth();
            int height = this.getHeight();

            //Achsen NullPKT def
            int xZero = 40; // ANFORDERUNG 3 y-achse ganz links
            int yZero = height / 2; // ANFORDERUNG 2 x achse mittig
            
            int plotWidth = width - xZero - 40;
            int plotHeight = yZero - 40;

            // 1. Hauptachsen zeichnen
            g2.setColor(Color.BLACK);

            g2.drawLine(xZero, yZero, width - 20, yZero); //xAchse()
            g2.drawLine(xZero, 20, xZero, height - 20);  //yAchse

            //anf 4 und 7, beschriftung
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            g2.drawString("X", width - 15, yZero + 5);
            g2.drawString("f(x)", xZero - 10, 15);
            g2.setFont(new Font("Kursiv", Font.ITALIC, 10));
            g2.drawString("O(0,0)", xZero - 35, yZero + 15);

            // 2 gitterlinien zeichnen
            g2.setColor(Color.LIGHT_GRAY);

            //Anforderung 5, gitterbereichen unter-und oberhalb der x_Achse
            int yObenMitte = yZero - (plotHeight / 2);
            int yMax = yZero - plotHeight;
            int yUntenMitte = yZero + (plotHeight / 2);
            int yMin = yZero + plotHeight;

            //horizotanle 4 gitterlinien
            int gitterEndeX = width - 40;
            g2.drawLine(xZero, yMax, gitterEndeX, yMax);
            g2.drawLine(xZero, yObenMitte, gitterEndeX, yObenMitte);
            g2.drawLine(xZero, yUntenMitte, gitterEndeX, yUntenMitte);
            g2.drawLine(xZero, yMin, gitterEndeX, yMin);

            // vertikale 4 Gitterlinien
            int xGitterAbstand = plotWidth / 4;
            for (int i = 1; i <= 4; i++){
                int xPos = xZero + (i * xGitterAbstand);
                g2.drawLine(xPos, yMax, xPos, yMin);
            }

            // 3. Sinuskurve zeichnen
            g2.setColor(Color.BLUE);

            //ursprung der sinuskurve
            int prevX = xZero;
            int prevY = yZero;

            for (int px = 0; px <= plotWidth; px++){
                double progress = (double) px / plotWidth;

                double xMath = progress * periodenAnzahl * 2 * Math.PI;
                double yMath = Math.sin(xMath);

                int screenX = xZero + px;
                int scrennY = (int) (yZero - (yMath * plotHeight));

                if (px > 0){
                    g2.drawLine(prevX, prevY, screenX, scrennY);
                }
                prevX = screenX;
                //prevY = screenY;
            }
        }
    }

    //Main
    public static void main(String[] args) {
        new FrequenzGenerator();
    }
    
}
