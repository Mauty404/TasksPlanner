import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    JMenuBar menuBar;
    JMenu manageMenu, fileMenu;
    JMenuItem manageDatabase, clearCurrent;
    JFrame frame;
    ImageIcon image;
    Dimension sizeOfWindow;
    int widthOfSingleDayCol;

    MainWindow() {

// Default properties of main window
        frame = new JFrame();
        frame.setTitle("TasksPlanner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,420);
        frame.setVisible(true);
        image = new ImageIcon("assets/mainProgramIcon.png");
        frame.setIconImage(image.getImage());
        frame.setVisible(true);


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


// Generating timetable using TimeTableGenerator instance
        TimetableGenerator ttg =  new TimetableGenerator();
        //frame.add(ttg.panel[1]);
        sizeOfWindow = frame.getSize();
        widthOfSingleDayCol = sizeOfWindow.width/7;
        System.out.println(widthOfSingleDayCol);
        ttg.panel[0].setBounds(0,0, widthOfSingleDayCol, 100);
        ttg.panel[1].setBounds(widthOfSingleDayCol, 0, widthOfSingleDayCol, 100);
        ttg.panel[2].setBounds(widthOfSingleDayCol*2, 0, widthOfSingleDayCol, 100);
        ttg.panel[3].setBounds(widthOfSingleDayCol*3,0,widthOfSingleDayCol, 100);
        ttg.panel[4].setBounds(widthOfSingleDayCol*4,0,widthOfSingleDayCol, 100);
        ttg.panel[5].setBounds(widthOfSingleDayCol*5,0,widthOfSingleDayCol, 100);
        ttg.panel[6].setBounds(widthOfSingleDayCol*6,0,widthOfSingleDayCol, 100);
        frame.add(ttg.panel[0]);
        frame.add(ttg.panel[1]);
        frame.add(ttg.panel[2]);
        frame.add(ttg.panel[3]);
        frame.add(ttg.panel[4]);
        frame.add(ttg.panel[5]);
        frame.add(ttg.panel[6]);


    }
}
