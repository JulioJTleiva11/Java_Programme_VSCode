package op05;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Example that uses many fonts.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
class FontExample extends JPanel {

  public FontExample() {
    setBackground(Color.white); // meaning should be obvious
    setPreferredSize(new Dimension(800,400));
  }

  private static final String[] fontnames = {
    "Monospace", "SansSerif", "Source Code Pro", 
    "Courier", "Caladea", "Hack"};
  private static final int[] styles = { 
    Font.PLAIN, Font.BOLD, Font.ITALIC };
  private static final int[] sizes = { 16, 24, 32 };

  protected void paintComponent(Graphics g) {
    super.paintComponent(g); // never forget!
    g.setColor(Color.black); // we use black now
    Dimension d = getSize(); // get current size

    // compute distances
    int dx = d.width / (sizes.length+1); 
    int dy = d.height / (fontnames.length*styles.length+1); 

    int col=0;
    int row=0;
    for (String fontname : fontnames) {
      for (int style : styles) {
        for (int size : sizes) {
          Font f = new Font(fontname,// this font
                            style,   // this style
                            size);   // this size
          g.setFont(f);
          g.drawString(fontname + (size),       // text
                       col*dx+dx/2, row*dy+dy); // pos.
          col++;
        }
        col=0;
        row++;		
      }
    }
  }

	public static void main(String[] args) {
		JFrame window = new JFrame();
		FontExample fe = new FontExample();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		window.add(fe);
		window.pack();
		window.setVisible(true);

	}
}
