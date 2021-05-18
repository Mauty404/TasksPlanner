import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class TimetableGenerator extends JTable {

    //JTable weekTable;
    JPanel[] hourPanel;

    public TimetableGenerator(Object[][] emptyData, Object[] columnNames) {
        super(emptyData, columnNames);


        //weekTable = new JTable(emptyData, columnNames);
        setRowHeight(30);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableColumnModel columnModel = getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(10);
        for(int i=1; i<8; i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
        }

       /* hourPanel = new JPanel[numberOfHours*2];
        hourPanel[0].add(new JLabel("HEEEE"));*/

    }
}
