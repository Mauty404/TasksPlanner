import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    JMenuBar menuBar;
    JMenu manageMenu, fileMenu;
    JMenuItem manageDatabase, clearCurrent;
    JFrame frame;
    ImageIcon image;

    int widthOfSingleDayCol;
    TimetableGenerator ttg;


    public void createMainWindow() {

//        Default properties of main window
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



        ttg = new TimetableGenerator(10);
        JScrollPane sp = new JScrollPane(ttg.weekTable);
        frame.add(sp);

        frame.setLayout(new GridLayout());
        frame.setVisible(true);
    }


    public int calculateWidthOfSingleColumn() {
        Dimension sizeOfWindow = frame.getSize();
        return sizeOfWindow.width / 7;
    }


}


