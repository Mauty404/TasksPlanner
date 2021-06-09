package pl;
import HttpClient.Event;
import HttpClient.HttpClientService;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MainWindow {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem  clearCurrent, refresh;
    JFrame frame;
    ImageIcon image;

    static final int numberOfHours = 10;
    static final int startHoursFrom = 7;

    static boolean signatures[][] = new boolean[8][numberOfHours*2+1];

    static JTable timetable;
    TableColumn tableColumn;

    PopupMenuCreator popupMenuCreator;

    private static final HttpClientService service = new HttpClientService();

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
        clearCurrent.addActionListener(e -> {
            EventCompositor ev = EventCompositor.getInstance();
            ev.components.clear();

            for(int i=1; i<8; i++) {
                for (int j=0; j<numberOfHours*2+1; j++) {
                    timetable.setValueAt("", j, i);
                }
            }
            try {
                service.deleteAllEvents();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            update();
        });

        refresh = new JMenuItem("Refresh");
        fileMenu.add(refresh);
        refresh.addActionListener(e -> {
            List<Event> list = null;
            try {
                 list = service.getAllEvents();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            EventCompositor ev = EventCompositor.getInstance();

            Iterator<Event> it = list.iterator();
            while(it.hasNext()) {
                Event event = it.next();
                EventCompositor.SingleEvent singleEvent = ev.new SingleEvent();
                singleEvent.name = event.getName();
                singleEvent.fromHour = event.getFromHour();
                singleEvent.toHour = event.getToHour();
                singleEvent.day = event.getDay();
                ev.components.add(singleEvent);
            }
            update();
        });



        frame.setJMenuBar(menuBar);

// Create timetable and setting preffered options

        timetable = new JTable(new DataTableModel(numberOfHours, startHoursFrom));
        tableColumn = timetable.getColumnModel().getColumn(0);
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
            popupMenuCreator.setData(timetable.getSelectedRow(), timetable.getSelectedColumn());
        });
    }

    static void update() {
        for(int i=0 ;i<8; i++)
            for(int j=0; j<numberOfHours*2+1; j++) {
                signatures[i][j] = false;
            }

        int currentHandleColumn;
        EventCompositor ev = EventCompositor.getInstance();
        Iterator<EventCompositor.SingleEvent> it = ev.components.iterator();
        while(it.hasNext()) {
            EventCompositor.SingleEvent singleEvent = it.next();
            currentHandleColumn = singleEvent.day;
            int indexFrom = getNumberOfRowFromHour(singleEvent.fromHour);
            int indexTo = getNumberOfRowFromHour(singleEvent.toHour);
            timetable.setValueAt(singleEvent.name, indexFrom, singleEvent.day);

            for(int i=0; i<numberOfHours*2; i++) {
                if(i>=indexFrom && i <= indexTo) {
                    signatures[currentHandleColumn][i] = true;
                }
            }
        }


        for(int i=0; i<8; i++) {
            TableColumn col = MainWindow.timetable.getColumnModel().getColumn(i);
            col.setCellRenderer(new EventRenderer(Color.magenta));
        }

        MainWindow.timetable.repaint();
    }

    static int getNumberOfRowFromHour(String data) {
        String concated;
        int intHour;
        int rowNumber;
        boolean halfFlag = false;

        int indexFrom = data.indexOf(':');
        switch(indexFrom){
            case 1:
                concated = data.substring(0,1);
                if(data.charAt(2) == '3')
                    halfFlag = true;
                break;
            default:
                concated = data.substring(0,2);
                if(data.charAt(3) == '3')
                    halfFlag = true;
                break;
        }


        intHour = Integer.parseInt(concated);
        rowNumber = intHour - startHoursFrom;

        if(halfFlag)
            return 2*rowNumber+1;
        else
            return 2*rowNumber;
    }
}