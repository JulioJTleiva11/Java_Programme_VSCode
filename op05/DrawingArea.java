package op05;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 * Dialog that asks the user to enter a text.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class DrawingArea extends JPanel 
    implements MouseMotionListener, // listen to mouse
        MouseListener,       // listen to mouse buttons
        ActionListener {     // for popup-menu
  private static final int col = 1000;
  private static final int row = 500;
  private static final int 
                       traceColor = Color.blue.getRGB();
  private static final int 
                       dragColor  = Color.red.getRGB();
  private static final int 
                       whiteColor = Color.white.getRGB();

  private int[][] pic = new int[col][row]; // the picture
  private int curX; // cursor position
  private int curY;   
  private SimpleDraw home; // the frame this belong to

  /**
   * Implements a simple drawing area and adds items to the menu.
   * @param home is the window to which menu items are added.
   */
  public DrawingArea(SimpleDraw home) {
    this.home = home;
    // set size
    setMinimumSize(new Dimension(col,row));
    setPreferredSize(new Dimension(col,row));
    setMaximumSize(new Dimension(col,row));
    
    // whitening the "paper"
    for (int x = 0; x < col; x++) {
      for (int y = 0; y < row; y++) {
        pic[x][y] = whiteColor;
      }
    }
    buildMenu();
    // add me to the listener lists
    addMouseMotionListener(this);
    addMouseListener(this); // for mouse buttons
  }

  @Override
  protected void paintComponent(Graphics g) {
    for (int x = 0; x < col; x++) {
      for (int y = 0; y < row; y++) {
        g.setColor(new Color(pic[x][y]));
        g.drawLine(x,y,x,y); // funny way to draw a point
      }
    }
  }

  // Mouse motion, Interface MouseMotionListener
  /* (non-Javadoc)
   * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
   */
  public void mouseMoved(MouseEvent me) { 
    int x = me.getX();
    int y = me.getY();
    System.out.println("Moved : " + x + "/" + y);
    draw(x,y,traceColor);
    repaint();
  }
  
  /* (non-Javadoc)
   * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
   */
  public void mouseDragged(MouseEvent me) {
    int x = me.getX();
    int y = me.getY();
    System.out.println("Dragged : " + x + "/" + y);
    draw(x,y,dragColor);
    repaint();
  }
  
  /**
   * Draws a point.
   * @param x is the x-coordinate
   * @param y is the y-coordinate
   * @param color of the point
   */
  private void draw(int x, int y, int color) {
    int thick = home.getThickness();
    for (int dx = x - thick; dx <= x + thick; dx++) {
      for (int dy = y - thick; dy <= y + thick; dy++) {
        if (0 <= dx && 0 <= dy && dx < col && dy < row) {
          pic[dx][dy] = color;
        }
      }
    }
  }

  // For mouse buttons; from interface MouseListener
  public void mousePressed(MouseEvent me) {
    home.addLog("Pressed  : " + me.getX() 
                        + "/" + me.getY());
    checkMouseEvent(me);
  }
  
  public void mouseReleased(MouseEvent me) {
    home.addLog("Released : " + me.getX() 
                        + "/" + me.getY());
    checkMouseEvent(me);
  }
  
  public void mouseClicked(MouseEvent me) {
    home.addLog("Clicked  : " + me.getX() 
                        + "/" + me.getY());
    checkMouseEvent(me);
  }
  
  public void mouseEntered(MouseEvent me) {
    home.addLog("Entered  : " + me.getX() 
                        + "/" + me.getY());
    checkMouseEvent(me);
  }
  
  public void mouseExited(MouseEvent me) {
    home.addLog("Exited   : " + me.getX() 
                        + "/" + me.getY());
    checkMouseEvent(me);
  }
  
  /**
   * Method that handles all mouse button events.
   * @param me the mouse event provided by the OS
   */
  private void checkMouseEvent(MouseEvent me) {
    if (me.getClickCount() > 1) { // double clicked?
      home.addLog("ClickCount = " + me.getClickCount());
    }
    if (me.isPopupTrigger()) { // or popup-menu?
      home.addLog("Ist PopupTrigger");
      curX = me.getX();
      curY = me.getY();
      popupMenu.show((Component) me.getSource(), 
                     curX, curY);
    }
  }

  // building the menu
  private JPopupMenu popupMenu;
  private JMenuItem    clearAll; 
  private JMenuItem    clear;
  
  private void buildMenu() {
    // constructing
    popupMenu = new JPopupMenu();
    clear       = new JMenuItem("Löschen");
    clearAll    = new JMenuItem("Alles löschen");

    // adding 
    popupMenu.add(clear);
    popupMenu.add(clearAll);

    // subscribing
    clear.addActionListener(this);
    clearAll.addActionListener(this); 
  }
  
  @Override
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == clearAll) { 
      // erase everything: whitening all pixels
      for (int x = 0; x < col; x++) {
        for (int y = 0; y < row; y++) {
          pic[x][y] = whiteColor;
        }
      }
      repaint();
    } else if (ev.getSource() == clear) {
      // erase the area around cursor
      int x = curX;
      int y = curY;
      int size = 100; // hence 200x200 pixels
      for (int dx = x - size; dx <= x + size; dx++) {
        for (int dy = y - size; dy <= y + size; dy++) {
          if (   0 <= dx  && dx < col 
              && 0 <= dy  && dy < row) {
            pic[dx][dy] = whiteColor;
          }
        }
      }
      repaint();
    } 
  }
}
