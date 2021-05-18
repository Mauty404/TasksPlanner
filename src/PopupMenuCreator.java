import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupMenuCreator extends JPopupMenu {


    JMenuItem createNew = new JMenuItem("Create new event");
    JMenuItem deleteCurrent = new JMenuItem("Delete selected event");

    private Object selectedRow;
    private Object selectedColumn;

    public PopupMenuCreator() {
        add(createNew);
        add(deleteCurrent);


        createNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getData());
                new NewEventWindow();
            }
        });

        deleteCurrent.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));
    }

    public void setData(Object data) {
        this.selectedRow = data;
    }

    public Object getData() {
        return selectedRow;
    }
}
