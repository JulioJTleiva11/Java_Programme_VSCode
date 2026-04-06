package op06;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ProdConViewer extends JFrame {
    private Storage s;
    private Producer[] prods;
    private Consumer[] cons; 

    public ProdConViewer(Storage s, Producer[] prods, Consumer[] cons) {
        this.s = s;
        this.prods = prods;
        this.cons = cons;

        add (new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.setFont(new Font("SansSerif",Font.BOLD,24));
                int qsize = s.getSize();
                for (int i=0; i<qsize; i++) {

                    g.drawString(""+s.at(i),250,i*25+20);
                }

                g.setColor(Color.red);
                g.fillOval(235,15+25*s.getFirstEmpty(),5,5);
                 g.setColor(Color.blue);
                g.fillOval(300,15+25*s.getFirstOccpd(),5,5);
            g.setColor(Color.black);    
                for (int i=0; i<prods.length; i++) {
                    Object secret = prods[i].getSecret();
                    if (secret!=null) {
                        g.drawString(secret.toString(),50,i*25+20);
                    } 
                }
                for (int i=0; i<cons.length; i++) {
                    Object secret = cons[i].getObject();
                    if (secret!=null) {
                        g.drawString(secret.toString(),450,i*25+20);
                    } 
                }
            }
        });

        setSize(600,500);
        setResizable(false);
        setVisible(true);
    }

}
