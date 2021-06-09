package pl;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class EventRenderer extends DefaultTableCellRenderer {
    Color backgroundColor;

    public EventRenderer(Color backgroundColor) {

        this.backgroundColor = backgroundColor;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component renderComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        if (MainWindow.signatures[column][row])
            renderComp.setBackground(backgroundColor);
        else
            renderComp.setBackground(Color.WHITE);

        return renderComp;
    }
}
