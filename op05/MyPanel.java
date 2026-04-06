package op05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Simple class of a panel for demonstration purposes only.
 * 
 * <p>Adaption of class MyPanel from D. Abts
 * @author Henning Dierks
 * @version 1.0
 */

public class MyPanel extends JPanel {
  private int id;

  private static final int maxFontSize = 24;
  private static final String fontName = "Monospace"; 
  
  /**
   * Constructor of a panel with ID.
   * @param id the ID to be shown in the panel.
   */
  public MyPanel(int id) {
    this.id = id;
    setBackground(Color.lightGray); // HD made changes
    setPreferredSize(new Dimension(100, 100));
    setMinimumSize(new Dimension(30,30));
    setMaximumSize(new Dimension(500, 500));
  }
  
  public MyPanel(int id, int width, int height) {
	    this.id = id;
	    setBackground(Color.lightGray); // HD made changes
        if (width>0 && height>0) {
	      setPreferredSize(new Dimension(width, height));
	      setMinimumSize(new Dimension(width,height));
	     setMaximumSize(new Dimension(width, height));
        }
	  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    Dimension size = getSize();
    String idText = "ID "+id;
    String dimText = "W "+(int)(size.getWidth())
    		         + " x H " + (int)(size.getHeight());
    
    // find the largest fontsize that fits!
    int fontsize = maxFontSize;
   	Font f = new Font(fontName, Font.BOLD, fontsize);
    g.setFont(f);
    while (g.getFontMetrics().stringWidth(dimText)
           >=size.getWidth()-10) {
    	fontsize--;
       	f = new Font(fontName, Font.BOLD, fontsize);
        g.setFont(f);
    }
    
    int idWidth   = g.getFontMetrics().stringWidth(idText);
    int textWidth = g.getFontMetrics().stringWidth(dimText);
    
    g.drawString(idText, (int) ((size.getWidth()-idWidth)/2),
            (int) (size.getHeight()/3));
    g.drawString(dimText, (int) ((size.getWidth()-textWidth)/2),
            (int) (2*size.getHeight()/3));
  }
}
