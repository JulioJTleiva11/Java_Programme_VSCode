package HSL_VL;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//@SuppressWarnings("serial")
public class BSP_Menu extends JFrame{
    //GUI Komponenten
    //private JPanel panelFenster;

    //GUI-Konstruktor
    public BSP_Menu(){
        super("BSP-Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);//this.pack();
        this.setLocationRelativeTo(null);  //this.setLocation(50, 50);

        // 1. menubar erstellen
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);

        // 2. menus erstellen
        // Menu1
        JMenu menuFile1 =  new JMenu("Menu1");
        menubar.add(menuFile1);  // JMenu hinzufpgen zu JMenubar

        menuFile1.add(new JMenuItem("Open1"));
        menuFile1.add(new JMenuItem("Save1"));
        menuFile1.addSeparator();
        menuFile1.add(new JMenuItem("Exit1"));

        // Menu2
        JMenu menuFile2 = new JMenu("Menu2");
        menubar.add(menuFile2);  // JMenu hinzufpgen zu JMenubar

        menuFile2.add(new JMenuItem("Open2")); //JMenuItem für JMenu
        menuFile2.add(new JMenuItem("Save2"));
        menuFile2.addSeparator();
        menuFile2.add(new JMenuItem("Help2"));

        //JPanel erstellen
        JPanel panelFenster = new JPanel();
        panelFenster.setLayout(new GridLayout(2, 4, 5, 5));

        //Icon oder ImageIcon mit JLabel
        //ImageIcon bild = new ImageIcon("DateiPfad vom Bild1");
        JLabel label1 = new JLabel("JLabel_1 und JPanel", JLabel.CENTER);//JLabel label1 = new JLabel("Buenos Dias!!!", bild, JLabel.CENTER);  //
        label1.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));
        panelFenster.add(label1);

        //JLabel hinzufügen
        JLabel label2 = new JLabel("mit setLayout(new GridLayout())");
        label2.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));
        panelFenster.add(label2);//panelFenster.add(new JLabel("JLabel_Hier"));

        //JLabel hinzufügen
        JLabel label3 = new JLabel("JLabel_3", JLabel.CENTER);
        label3.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));
        panelFenster.add(label3);//panelFenster.add(new JLabel("JLabel_Hier"));

        this.add(panelFenster);//this.add(panelFenster, BorderLayout.NORTH);

        //this.setVisible(true);  //siehe bei der Main!
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BSP_Menu().setVisible(true);
        });    //new BSP_Menu();
    }

}
