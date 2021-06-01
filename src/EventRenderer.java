import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class EventRenderer extends DefaultTableCellRenderer {
    TableCellRenderer renderer;
    Color backgroundColor;
    int startRow, endRow;

    public EventRenderer(TableCellRenderer renderer, Color backgroundColor, int startRow, int endRow) {
        this.renderer = renderer;
        this.backgroundColor = backgroundColor;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row2, column2);
        //cell.setBackground(backgroundColor);
        Component renderComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if(row >= startRow && row <= endRow)
            renderComp.setBackground(backgroundColor);
        return renderComp;
    }
}
