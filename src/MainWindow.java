import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class MainWindow {

    JMenuBar menuBar;
    JMenu manageMenu, fileMenu;
    JMenuItem manageDatabase, clearCurrent;
    JFrame frame;
    ImageIcon image;

    static final int numberOfHours = 10;
    static final int startHoursFrom = 7;

    JTable timetable;

    PopupMenuCreator popupMenuCreator;


    public void createMainWindow() {

// Default properties of main window
        frame = new JFrame();
        frame.setTitle("TasksPlanner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 420);
        image = new ImageIcon("assets/mainProgramIcon.png");
        frame.setIconImage(image.getImage());



// MenuBar
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);


        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        clearCurrent = new JMenuItem("Clear");
        fileMenu.add(clearCurrent);


        manageMenu = new JMenu("Management");
        menuBar.add(manageMenu);
        manageDatabase = new JMenuItem("Manage database");
        manageMenu.add(manageDatabase);

        frame.setJMenuBar(menuBar);



// Create timetable and setting preffered options

        timetable = new JTable(new DataTableModel(numberOfHours, startHoursFrom));
        //timetable.setFillsViewportHeight(true);
        timetable.setRowHeight(30);
        timetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        timetable.setColumnSelectionAllowed(true);
        TableColumnModel columnModel = timetable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);

        for(int i=0; i<8; i++) { columnModel.getColumn(i).setPreferredWidth(100); }


// Adding generated timetable to pane
        JScrollPane sp = new JScrollPane(timetable);
        frame.add(sp);

        frame.setLayout(new GridLayout());
        frame.setVisible(true);


// Adding context menu handle to jtable

        popupMenuCreator = new PopupMenuCreator();
        timetable.setComponentPopupMenu(popupMenuCreator);


// Setting up listener when selected area is changed

        timetable.getSelectionModel().addListSelectionListener(e -> {
            popupMenuCreator.setData(timetable.getValueAt(timetable.getSelectedRow(),0));
            TransferObj.setSelectedRow(timetable.getSelectedRow());
            TransferObj.setSelectedColumn(timetable.getSelectedColumn());
        });
    }
}


