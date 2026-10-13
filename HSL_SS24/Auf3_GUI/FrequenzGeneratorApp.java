package HSL_SS24.Auf3_GUI;

import java.awt.BorderLayout;//Muss oben(also hier) sein, sonst Fehler
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

public class FrequenzGeneratorApp extends JFrame implements ActionListener{
    
    private ZeichenPanel zeichenPanel;                        //attrib
    private JLabel anzahlPeriod;
    private JTextField txtPeriod;
    private JButton btnAktuali;

    public FrequenzGeneratorApp(){                            //Konstr
        super("FrequenzGeneratorApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false); //ANFORDERUNG 1
        
        //"obere Panel" zeichenbret init
        zeichenPanel =  new ZeichenPanel();
        
        //untere controlPanel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 3, 5, 5));
        
        //attrib init und bereitstellen
        anzahlPeriod = new JLabel("Anzahl Perioden: ", JLabel.CENTER);
        //anzahlPeriod.setHorizontalAlignment(JLabel.CENTER); // zentrieren von JLabel
        controlPanel.add(anzahlPeriod);

        txtPeriod = new JTextField("1.6", 5);
        txtPeriod.setHorizontalAlignment(JTextField.CENTER); // zentrieren von JTextField
        controlPanel.add(txtPeriod);

        btnAktuali = new JButton("Aktualisieren");
        btnAktuali.addActionListener(this);
        controlPanel.add(btnAktuali);
        //Layout aufbauen und zum fenster hinzufügen
        setLayout(new BorderLayout());//nötig?
        add(zeichenPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true); //siehe sonst Main
    }
    //Event Handling ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAktuali){
            String eingabe = txtPeriod.getText().trim();
            try {   //text aus dem JTextField in double umwandeln
                double perioden = (double) Double.parseDouble(eingabe);
                // Anf 9, validierung des werts zwi. 1 und 3.0
                if (perioden >= 1.0 && perioden <= 3.0){
                    zeichenPanel.setPeriodenAnzahl(perioden);
                } else {
                    //Fehlermeldung bei mehr als 3 oder <1 perioden
                    JOptionPane.showMessageDialog(this, "bitte nur einen Wert zwischen 1.0 und 3.0 eingeben", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                //Fehlermeldung, falls falsche eingabe
                JOptionPane.showMessageDialog(this, "ungültiges Format, bitte  eine gültige Zahl eingeben.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //Inne. Class für math. Zeichnen
    private class ZeichenPanel extends JPanel{ //extends JPanel,da zeichnen
        private double periodenAnzahl = 1.0;
        //Hintergrund  in Weiß
        public ZeichenPanel(){
            setBackground(Color.GREEN);
        }
        //SetterMethod um Periodenanzahl zun ändern mit repaint();
        public void setPeriodenAnzahl(double perioden) {  //hier parameter perioden aus Event Handling
            this.periodenAnzahl = perioden;//hier perioden übergibt seinen aktu. Wert aus Event Handling
            repaint();            
        } 
        //Method für die Graphik aufgerufen mit QuellAktion in der inne. Klasse
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int breite = getWidth();
            int hoehe = getHeight();
            //Achsen NullPKT def
            int xZero = 40;  // ANFORDERUNG 3 y-achse ganz links
            int yZero  = hoehe / 2;  // ANFORDERUNG 2 x achse mittig

            int plotBreite = breite - xZero - 40; //
            int plotHoehe = yZero - 40;

            // 1. Hauptachsen zeichnen
            g2d.setColor(Color.BLACK);
            g2d.drawLine(xZero, yZero, breite - 20, yZero); //xAchse()
            g2d.drawLine(xZero, 20, xZero, hoehe - 20);  //yAchse
            //ANFORDERUNG 4 und 7, beschriftung
            g2d.setFont(new Font("Arial", Font.BOLD, 12));
            g2d.drawString("X", breite - 15, yZero + 5);
            g2d.drawString("f(x)", xZero - 10, 15);
            g2d.setFont(new Font("Kursiv", Font.ITALIC, 10));
            g2d.drawString("O(0,0)", xZero - 35, yZero + 15);

            // 2. Gitterlinien zeichnen
            g2d.setColor(Color.LIGHT_GRAY);
            //ANFORDERUNG 5 bereiche unter- und oberhalb der x-achse in 2 blöcke
            int yObenMitte = yZero - (plotHoehe / 2);
            int yMax = yZero - plotHoehe;
            int yUntenMitte = yZero + (plotHoehe / 2);
            int yMin = yZero + plotHoehe;
            // horizontale 4 GitterLinien
            int gitterEndeX = breite - 40;
            g2d.drawLine(xZero, yMax, gitterEndeX, yMax); 
            g2d.drawLine(xZero, yObenMitte, gitterEndeX, yObenMitte); // bei horiz b=d
            g2d.drawLine(xZero, yMin, gitterEndeX, yMin);
            g2d.drawLine(xZero, yUntenMitte, gitterEndeX, yUntenMitte);
            // vertikale 4 Gitterlinien: ANFORDERUNG 6
            int xGitterAbstand = plotBreite / 4;
            for ( int i = 1; i <= 4; i++){
                int xPos = xZero + (i * xGitterAbstand);//von links 4 linien-> 40(yAchse) + i*gitterabstand
                g2d.drawLine(xPos, yMax, xPos, yMin); // bei vertik a=c
            }

            // 3. Sinuskurve zeichnen
            g2d.setColor(Color.BLUE);
            int prevX = xZero;//Ursprung der Sinus bei x
            int prevY = yZero;//Ursprung der Sinus bei y
            for (int px = 0; px <= plotBreite; px++){
                double progress = (double) px / plotBreite;
                // ANFORDERUNG 7, sin(ax) dynam double-Wert
                double xMath = progress * periodenAnzahl * 2 * Math.PI;// sin(progress*2*pi)
                double yMath = Math.sin(xMath);
                int screenX = xZero + px;
                int screenY = (int) (yZero - (yMath * plotHoehe));//ANFORDERUNG 8, max Amplitude
                if (px > 0) {
                    g2d.drawLine(prevX, prevY, screenX, screenY);
                }
                prevX = screenX;
                //prevY = screenY;
            }
        }
    }    
    //Main
    public static void main(String[] args) {
        new FrequenzGeneratorApp();
       // SwingUtilities.invokeLater(()->{
       //     new FrequenzGeneratorApp().setVisible(true);
       //});
    }
   
}
