import javax.swing.*;
import java.awt.*;

public class TimetableGenerator  {


    JLabel[] daysOfWeek;
    JPanel[] panel;

    public TimetableGenerator() {
        daysOfWeek = new JLabel[7];
        panel = new JPanel[7];

        daysOfWeek[0] = new JLabel("Monday");
        daysOfWeek[1] = new JLabel("Tuesday");
        daysOfWeek[2] = new JLabel("Wednesday");
        daysOfWeek[3] = new JLabel("Thursday");
        daysOfWeek[4] = new JLabel("Friday");
        daysOfWeek[5] = new JLabel("Saturday");
        daysOfWeek[6] = new JLabel("Sunday");

        for (int i=0; i<7; i++) {
            panel[i] = new JPanel();
            panel[i].add(daysOfWeek[i]);
        }

        panel[0].setBackground(Color.blue);
        panel[1].setBackground(Color.green);

    }
}
