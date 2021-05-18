import javax.swing.*;
import java.awt.*;

public class MainWindow {

    JMenuBar menuBar;
    JMenu manageMenu, fileMenu;
    JMenuItem manageDatabase, clearCurrent;
    JFrame frame;
    ImageIcon image;

    static final int numberOfHours = 10;
    static final int startHoursFrom = 7;

    int widthOfSingleDayCol;
    TimetableGenerator ttg;

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



// Invoke timetable generator with options

        Object[] generatedFulfilament = generateFulfilament();
        ttg = new TimetableGenerator((Object[][])generatedFulfilament[0], (Object[])generatedFulfilament[1]);
        JScrollPane sp = new JScrollPane(ttg);
        frame.add(sp);

        frame.setLayout(new GridLayout());
        frame.setVisible(true);


// Adding context menu handle to jtable

        popupMenuCreator = new PopupMenuCreator();
        ttg.setComponentPopupMenu(popupMenuCreator);


// Setting up listener when selected area is changed

        ttg.getSelectionModel().addListSelectionListener(e -> {
            //System.out.println(ttg.weekTable.getValueAt(ttg.weekTable.getSelectedRow(),0));
            popupMenuCreator.setData(ttg.getValueAt(ttg.getSelectedRow(),0));

            TransferObj.setSelectedRow(ttg.getSelectedRow());
            TransferObj.setSelectedColumn(ttg.getSelectedColumn());
            //System.out.println("Row: "+ ttg.getSelectedRow());
            //System.out.println("Column: " + ttg.getSelectedColumn());
        });
    }

    public Object[] generateFulfilament() {
        Object[][] emptyData = new Object[numberOfHours*2+1][8];

        Object[] hoursLabels = new Object[numberOfHours*2+1];

        int counterFullHours = 0;
        for(int i=0; i<hoursLabels.length; i++) {

            if(i%2 == 0) {
                hoursLabels[i] = counterFullHours + startHoursFrom + ":00";
                counterFullHours++;
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

        return new Object[] {emptyData, columnNames};
    }


    public int calculateWidthOfSingleColumn() {
        Dimension sizeOfWindow = frame.getSize();
        return sizeOfWindow.width / 7;
    }




}


