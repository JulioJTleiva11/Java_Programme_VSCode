package op05;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NeverDie extends JFrame
  implements MouseMotionListener
{

  private JPanel panel;

  public NeverDie() {
    super("I will never die!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cnt = getContentPane();
    cnt.setLayout(new BorderLayout());

    panel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawLine(100,200,300,200); 
        g.drawLine(200,100,200,300); 
      } 
    };
    panel.setMinimumSize(new Dimension(500,500));
    panel.setMaximumSize(new Dimension(500,500));
    panel.setPreferredSize(new Dimension(500,500));

    cnt.add(panel,BorderLayout.CENTER);

    addMouseMotionListener(this);
    
    pack();
    setSize(500,550);
    setVisible(true); // show time!
  }


  public static void main (String[] args) {
    new NeverDie();
  }


  @Override
  public void mouseDragged(MouseEvent me) {
    int x = me.getX();
    int y = me.getY();

    Point current = getLocation();
    
    this.getMousePosition();
    System.out.println("MP"+ this.getMousePosition());
    int pX = (int) (current.getX()+ x-200);
    int pY = (int) (current.getY()+y-200);
    setLocation(pX,pY);
    System.out.println(" X= "+x + ", Y=" + y + "  Setze nach " + pX +","+ pY);
  }


  @Override
  public void mouseMoved(MouseEvent me) {
   mouseDragged(me);
  }
}
