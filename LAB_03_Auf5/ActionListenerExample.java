package LAB_03_Auf5;

import javax.swing.*;

import java.awt.*;

public class ActionListenerExample extends JFrame {

    public ActionListenerExample() {
        super("ActionListener Beispiel");
        setSize(600, 600);//
        setLocation(new Point(390, 80));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 1. JButton erstellen
        JButton button = new JButton("Klick mich");
        
        // 2. JTextField erstellen (reagiert auf Enter)
        JTextField textField = new JTextField(10);
        
        // 3. JComboBox erstellen
        String[] optionen = {"Option A", "Option B", "Option C"};
        JComboBox<String> comboBox = new JComboBox<>(optionen);

        // --- ActionListener hinzufügen ---

        // Verwendung von modernen Lambda-Ausdrücken (Java 8+)
        button.addActionListener(e -> System.out.println("Button wurde geklickt!"));

        textField.addActionListener(e -> System.out.println("Text eingegeben: " + textField.getText()));

        comboBox.addActionListener(e -> System.out.println("Ausgewählt: " + comboBox.getSelectedItem()));

        // Komponenten dem Fenster hinzufügen
        add(button);
        add(textField);
        add(comboBox);
        //setVisible(true);
    }

    public static void main(String[] args) {
        // GUI im Event Dispatch Thread starten
        SwingUtilities.invokeLater(() -> {
            new ActionListenerExample().setVisible(true);
        });
    }
}