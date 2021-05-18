import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEventWindow extends JFrame {
    public NewEventWindow() {
        setTitle("Create new event");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        JLabel eventNameLabel = new JLabel("Event name");
        JTextField eventNameField = new JTextField();

        int hourCounter = 0;
        String[] hoursCombo = new String[MainWindow.numberOfHours*2+1];
        for (int i=0; i<=MainWindow.numberOfHours; i++) {
            int tmp = i + MainWindow.startHoursFrom;
            hoursCombo[hourCounter] = tmp + ":00";
            if (i == MainWindow.numberOfHours) continue;
            hoursCombo[hourCounter+1] = tmp + ":30";
            hourCounter+= 2;
        }

        JLabel fromHour = new JLabel("From: ");
        JComboBox fromCombo = new JComboBox(hoursCombo);
        fromCombo.setSelectedIndex(TransferObj.getSelectedRow());
        JLabel toHour = new JLabel("To: ");
        JComboBox toCombo = new JComboBox(hoursCombo);


        if (TransferObj.getSelectedRow()+1 == toCombo.getItemCount())
            toCombo.setSelectedIndex(TransferObj.getSelectedRow());
        else
            toCombo.setSelectedIndex(TransferObj.getSelectedRow()+1);


        eventNameField.setPreferredSize(new Dimension(100,30));
        //eventNameField.setMinimumSize(new Dimension(40,100));

        Container container1 = new Container();
        container1.add(eventNameLabel);
        container1.add(eventNameField);
        container1.setLayout(new FlowLayout());

        Container container2 = new Container();
        container2.add(fromHour);
        container2.add(fromCombo);
        container2.add(toHour);
        container2.add(toCombo);
        container2.setLayout(new FlowLayout());

        JButton acceptButton = new JButton("Accept");
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(fromCombo.getSelectedItem());
            }
        });

        add(container1);
        add(container2);
        add(acceptButton);
        setLayout(new FlowLayout());

        setVisible(true);
    }
}
