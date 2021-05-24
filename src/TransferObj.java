import javax.swing.*;

public abstract class TransferObj {
    private static int selectedRow;
    private static int selectedColumn;

    private static int changedRow;

    public static void setSelectedRow(int a) { selectedRow = a; }
    public static int getSelectedRow() { return selectedRow; }
    public static void setSelectedColumn(int a) { selectedColumn = a; }
    public static int getSelectedColumn() { return selectedColumn; }

    public static void setChangedRow(int a) { changedRow = a;}
    public static int getChangedRow() { return changedRow; }
}
