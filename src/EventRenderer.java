import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.time.chrono.MinguoChronology;
import java.util.Iterator;

public class EventRenderer extends DefaultTableCellRenderer {
    TableCellRenderer renderer;
    Color backgroundColor;
    int startRow, endRow;

    public EventRenderer(Color backgroundColor) {

        //this.renderer = renderer;
        this.backgroundColor = backgroundColor;

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row2, column2);
        //cell.setBackground(backgroundColor);
        Component renderComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


            if (MainWindow.signatures[column][row])
                renderComp.setBackground(backgroundColor);
            else
                renderComp.setBackground(Color.WHITE);







        /*if(row >= startRow && row <= endRow)
            renderComp.setBackground(backgroundColor);
        else
            renderComp.setBackground(Color.WHITE);*/
        return renderComp;
    }
}
