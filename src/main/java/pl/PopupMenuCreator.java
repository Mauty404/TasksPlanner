package pl;

import javax.swing.*;

public class PopupMenuCreator extends JPopupMenu {


    JMenuItem createNew = new JMenuItem("Create new event");

    private int selectedRow;
    private int selectedColumn;

    public PopupMenuCreator() {
        add(createNew);

        createNew.addActionListener(e -> new NewEventWindow(getData()));

    }

    public void setData(int selectedRow, int selectedColumn) {
        this.selectedRow = selectedRow;
        this.selectedColumn = selectedColumn;
    }

    public int[] getData() {
        int[] data = new int[2];
        data[0] = selectedRow;
        data[1] = selectedColumn;
        return data;
    }
}
