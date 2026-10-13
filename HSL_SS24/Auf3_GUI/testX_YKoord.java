package HSL_SS24.Auf3_GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class testX_YKoord extends JPanel{

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Breite Höhe
        int breite = getWidth();
        int hoehe = getHeight();

        //Hintergrund
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, breite, hoehe);

        //Gitterlinien zeichnen
        g.setColor(Color.LIGHT_GRAY);

        //X-Achse
        int xAchseY = hoehe / 2;
          //g.drawLine(0, xAchseY, breite, xAchseY); siehe unten
        
        //Y-Achse
        int yAchseX = 40;
          //g.drawLine(yAchseX, 0, yAchseX, hoehe); siehe unten

        //Vertikale Gitterlinien
        for (int i = 1; i <= 3; i++){
            int x = yAchseX + (breite * i) / 4;
            g.drawLine(x, 0, x, hoehe);
        }

        //Horizontale Gitterlinien
        for (int i = 1; i <= 3; i++){
            int y = (hoehe * i) / 4;
            g.drawLine(yAchseX, y, breite, y);
        }

        //Achsen zeichnen in schwarz
        g.setColor(Color.BLACK);
            
        //X-Achse zeichnen
         //int xAchseY = hoehe / 2;  siehe oben
        g.drawLine(0, xAchseY, breite, xAchseY);
        
        //Y-Achse zeichnen
         //int yAchseX = 40;  siehe oben
        g.drawLine(yAchseX, 0, yAchseX, hoehe);

        //Achsepfeile für X und Y Achse
        g.drawLine(breite - 10, xAchseY - 5, breite, xAchseY);
        g.drawLine(breite - 10, xAchseY + 5, breite, xAchseY);
        g.drawString("x", breite - 15, xAchseY + 20);

        g.drawLine(yAchseX - 5, 10, yAchseX, 0);
        g.drawLine(yAchseX + 5, 10, yAchseX, 0);
        g.drawString("f(x)", yAchseX + 10, 15);

    }

    public static void main(String[] args) {
        //JFrame fenster erstellen
        JFrame fenster = new JFrame("Koordinanten Beispiel");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setSize(600, 500);

        //Koordinantensystem
        testX_YKoord panel = new testX_YKoord();
        fenster.add(panel);

        //fenster sichtbar
        fenster.setVisible(true);   

    }
}

