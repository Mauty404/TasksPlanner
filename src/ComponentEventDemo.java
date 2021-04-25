import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ComponentEventDemo extends MainWindow implements ComponentListener {


    @Override
    public void componentResized(ComponentEvent e) {
        Dimension newSize = e.getComponent().getBounds().getSize();
        System.out.println(newSize.width);
        super.calculateWidthOfSingleColumn();
        //super.setBoundsOfDays();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
