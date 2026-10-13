package HSL_SS25;

import java.awt.*; // für GridLayout Fehler vermeiden
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AUF3_RandomDistributions extends JFrame implements ActionListener {
    //Attrib
    private ZeichenPanel zeichenPanel;
    private JButton newData;
    private JButton clear;

    private List<Datenpunkt> punkteListe = new ArrayList<>();
    private static class Datenpunkt{
        int x, y;
        Color farbe;
        public Datenpunkt(int x, int y, Color farbe) {
            this.x = x;
            this.y = y;
            this.farbe = farbe;
        }        
    }

    //Konstr
    public AUF3_RandomDistributions(){
        super("Random distributions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // attrib init
        zeichenPanel = new ZeichenPanel(); //obere Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,2));

        newData = new JButton("New Data"); //untere Panel mit 2 JButton
        newData.addActionListener(this);
        controlPanel.add(newData);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        controlPanel.add(clear);


        add(zeichenPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    //Event handling
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==newData){
            punkteListe.clear();//Anf 6 daten löschen

            Random random = new Random();
            int breite = zeichenPanel.getWidth();
            int hoehe = zeichenPanel.getHeight();

            //Ränder def
            int xAchseLinks = 50;
            int yAchseUnten = hoehe - 60;
            
            //Plotbereich
            int plotBreite = breite - xAchseLinks - 40;
            int plotHoehe = yAchseUnten - 40;

            //Anf 6, erste verteilung von 150 Pkte
            for(int i = 0; i < 150; i++){
                //Gauss- Normalverteilung
                int x = (int) (xAchseLinks + (plotBreite * 0.7) + (random.nextGaussian() * 40));
                int y = (int) (yAchseUnten - (plotHoehe * 0.7) + (random.nextGaussian() * 40));

                //sicherstellen dass die pkte im achsenbereich bleiben
                x = Math.max(xAchseLinks, Math.min(x, xAchseLinks + plotBreite - 5));
                y = Math.max(40, Math.min(y, yAchseUnten - 5));

                //Anf 6 und 7, visuell unterscheidbar durch blaue kreise
                punkteListe.add(new Datenpunkt(x, y, Color.BLUE));                
            }

            //Anf 6, zweite verteilung von 150 Pkte
            for(int i = 0; i < 150; i++){
                //Gauss- Normalverteilung
                int x = (int) (xAchseLinks + (plotBreite * 0.3) + (random.nextGaussian() * 40));
                int y = (int) (yAchseUnten - (plotHoehe * 0.3) + (random.nextGaussian() * 40));

                //sicherstellen dass die pkte im achsenbereich bleiben
                x = Math.max(xAchseLinks, Math.min(x, xAchseLinks + plotBreite - 5));
                y = Math.max(40, Math.min(y, yAchseUnten - 5));

                //Anf 6 und 7, visuell unterscheidbar durch blaue kreise
                punkteListe.add(new Datenpunkt(x, y, Color.RED));   
            }

            //Alles neu zeichnen
            zeichenPanel.repaint();

        }else if(e.getSource() == clear){
            punkteListe.clear();
            zeichenPanel.repaint();
        }
    }

    //(innere) Klasse
    private class ZeichenPanel extends JPanel{

        public ZeichenPanel(){ //Anf 1 hintergrund weiss
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//KantenGlättung der Linien und Kreisen
            
            int breite = getWidth(); 
            int hoehe = getHeight(); 

            int xZero = 40;
            int yZero = hoehe - 20;

            //int plotBreite = breite - xZero - 40; siehe EVENT HANDLING
            //int plotHoehe = yZero;

            //Hauptachsen zeichnen
            g2.setColor(Color.BLACK);
            g2.drawLine(xZero, yZero, breite - 40, yZero); //x achse anf 2 horizontale
            g2.drawLine(xZero, 20, xZero, hoehe -20); // y achse anf 3

            //Beschriftung
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            g2.drawString("x1", breite-35, yZero+5);
            g2.drawString("x2", xZero+10, 25);

            //Anf 6 und 7, aus EVENT HANDLING wird hier punkte gezeichnet
            for (Datenpunkt p : punkteListe){
                g2.setColor(p.farbe);
                g2.drawOval(p.x - 4, p.y - 4, 8, 8);
            }
        }
    
        
    }

    //Main
    public static void main(String[] args) {
        new AUF3_RandomDistributions();
    }

    
}
