package op05;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MemberRenderer extends DefaultTableCellRenderer {

    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.YYYY");

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int col) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        if (isSelected) {            // Member ist gelb, wenn mit dem klick ein Member selektiert wird, man kann auch die Schriftgrösse ändern
            setBackground(Color.yellow);
        } else {
            if (row % 2 == 0) {
                setBackground(Color.lightGray);
            } else {
                setBackground(Color.white);
            }
        }
        if (value instanceof LocalDate) {
            setText(((LocalDate) value).format(df));
        }
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        return this;
    }

}
