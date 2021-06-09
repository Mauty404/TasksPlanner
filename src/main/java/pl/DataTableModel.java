package pl;
import javax.swing.table.AbstractTableModel;

public class DataTableModel extends AbstractTableModel {

    private final String[] columnNames = {
            "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };
    private final Object[][] data;

    public DataTableModel(int numberOfHours, int startHoursFrom) {

        data = new Object[numberOfHours*2+1][8];

        Object[] hoursLabels = new Object[numberOfHours*2+1];

        int counterFullHours = 0;
        for(int i=0; i<hoursLabels.length; i++) {

            if(i%2 == 0) {
                hoursLabels[i] = counterFullHours + startHoursFrom + ":00";
                counterFullHours++;
            } else hoursLabels[i] = "";
        }


        for(int i=0; i< data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                if (j == 0) {
                    data[i][j] = hoursLabels[i];
                } else data[i][j] = "";
            }
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public void setValueAt(Object aValue, int row, int col) {
        data[row][col] = aValue;
        fireTableCellUpdated(row, col);
    }

}