package Lab03;
/*
Dies dient nur zur Anhaltspkt, es ist von KI
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Tarifrechner extends JFrame {

    // GUI-Komponenten deklarieren
    private JRadioButton rbWerktag, rbWochenende;
    private JComboBox<String> cbTarif;
    private JTextField tfPersonen;
    private JButton btnBerechne;
    private JLabel lblErgebnis; // Das geforderte JLabel für den Preis

    // Tarife und Preise (Mo-Fr) definieren
    private final String[] tarife = {"Kurzstrecke", "Innerer Ring", "Ganze Stadt", "Tagesticket"};
    private final double[] preise = {1.00, 2.20, 3.60, 8.20};

    public Tarifrechner() {
        // Fenster-Einstellungen
        setTitle("Tarifrechner");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10)); // Übersichtliches Raster-Layout

        // (a) RadioButtons für Wochentag
        rbWerktag = new JRadioButton("Mo-Fr", true);
        rbWochenende = new JRadioButton("Sa-So");
        ButtonGroup bgWochentag = new ButtonGroup();
        bgWochentag.add(rbWerktag);
        bgWochentag.add(rbWochenende);

        JPanel panelWochentag = new JPanel();
        panelWochentag.add(rbWerktag);
        panelWochentag.add(rbWochenende);

        // (b) ComboBox für Tarife
        cbTarif = new JComboBox<>(tarife);

        // (c) JTextField für Personenanzahl
        tfPersonen = new JTextField();

        // (d) JButton für die Berechnung
        btnBerechne = new JButton("Berechne");

        // (e) JLabel für das Ergebnis
        lblErgebnis = new JLabel("0,00 €");
        lblErgebnis.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // OPTIONAL: Wenn das JLabel wie ein graues Textfeld aussehen soll:
        //lblErgebnis.setOpaque(true);
        // lblErgebnis.setBackground(new Color(230, 230, 230));
        // lblErgebnis.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Komponenten dem Fenster hinzufügen
        add(new JLabel("Wochentag:"));
        add(panelWochentag);
        add(new JLabel("Tarif:"));
        add(cbTarif);
        add(new JLabel("Anzahl Personen:"));
        add(tfPersonen);
        add(new JLabel("")); // Platzhalter
        add(btnBerechne);
        add(new JLabel("Gesamtpreis:"));
        add(lblErgebnis);

        // Logik für den Button hinzufügen
        btnBerechne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechnePreis();
            }
        });
    }

    private void berechnePreis() {
        try {
            // 1. Personenanzahl auslesen und validieren
            String personenText = tfPersonen.getText().trim();
            int anzahlPersonen = Integer.parseInt(personenText);

            if (anzahlPersonen <= 0) {
                lblErgebnis.setText("Fehler: Personen < 0!");
                return;
            }

            // 2. Basispreis ermitteln
            int ausgewählterIndex = cbTarif.getSelectedIndex();
            double basisPreis = preise[ausgewählterIndex];

            // 3. Wochenend-Rabatt anwenden (25% Reduzierung = 75% des Preises)
            if (rbWochenende.isSelected()) {
                basisPreis *= 0.75;
            }

            // 4. Gesamtpreis berechnen
            double gesamtPreis = basisPreis * anzahlPersonen;

            // 5. Formatierung auf exakt zwei Nachkommastellen
            DecimalFormat df = new DecimalFormat("0.00");
            lblErgebnis.setText(df.format(gesamtPreis) + " €");

        } catch (NumberFormatException ex) {
            // Fehlermeldung anzeigen, wenn keine gültige Ganzzahl eingegeben wurde
            lblErgebnis.setText("Fehler: Ungültige Zahl!");
        }
    }

    public static void main(String[] args) {
        // GUI im Event Dispatch Thread starten
        SwingUtilities.invokeLater(() -> {
            new Tarifrechner().setVisible(true);
        });
    }
}