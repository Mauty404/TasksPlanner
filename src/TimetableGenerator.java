import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class TimetableGenerator {

    JTable weekTable;
    JPanel[] hourPanel;

    public TimetableGenerator(int numberOfHours) {

        String[][] emptyData = new String[numberOfHours*2][8];

        /*for(String[] a : emptyData) {
            for(String b : a) {
                b = "";
            }
        }*/

        String[] hoursLabels = new String[numberOfHours*2];

        for(int i=0; i<hoursLabels.length; i++) {
            if(i%2 == 0) {
                hoursLabels[i] = Integer.toString(i+7) + ":00";
            } else hoursLabels[i] = "";
        }

        for(int i=0; i< emptyData.length; i++) {
            for(int j=0; j<emptyData[i].length; j++) {
                if (j == 0) {
                    emptyData[i][j] = hoursLabels[i];
                } else emptyData[i][j] = "";
            }
        }
        String[] columnNames = {
                "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        weekTable = new JTable(emptyData, columnNames);
        weekTable.setRowHeight(30);

        TableColumnModel columnModel = weekTable.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(10);
        for(int i=1; i<8; i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
        }

       /* hourPanel = new JPanel[numberOfHours*2];
        hourPanel[0].add(new JLabel("HEEEE"));*/

    }
}
