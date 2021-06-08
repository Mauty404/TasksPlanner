package pl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupMenuCreator extends JPopupMenu {


    JMenuItem createNew = new JMenuItem("Create new event");
    JMenuItem deleteCurrent = new JMenuItem("Delete selected event");

    private int selectedRow;
    private int selectedColumn;

    public PopupMenuCreator() {
        add(createNew);
        add(deleteCurrent);


        createNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewEventWindow(getData());
            }
        });

        deleteCurrent.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));
    }

    public void setData(int selectedRow, int selectedColumn) {
        this.selectedRow = selectedRow;
        this.selectedColumn = selectedColumn;
        //TransferObj.setSelectedColumn();

        //System.out.println("Column: " + selectedColumn);
        //System.out.println("Row: " + selectedRow);
    }

    public int[] getData() {
        int[] data = new int[2];
        data[0] = selectedRow;
        data[1] = selectedColumn;
        return data;
    }
}
