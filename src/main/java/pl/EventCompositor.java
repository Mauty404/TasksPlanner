package pl;
import javax.swing.*;
import java.util.Iterator;
import java.util.Vector;

public class EventCompositor {
    private static EventCompositor singleInstance = null;

    public static EventCompositor getInstance() {
        if (singleInstance == null)
            singleInstance = new EventCompositor();

        return singleInstance;
    }

    Vector<SingleEvent> components = new Vector<SingleEvent>();

    public class SingleEvent {
        String name;
        String fromHour;
        String toHour;
        int day;
    }



    public void printAll() {
        Iterator<SingleEvent> it = components.iterator();
        while (it.hasNext()) {
            System.out.println("---EVENT---");
            SingleEvent singleEvent = it.next();
            System.out.println("Name: " + singleEvent.name);
            System.out.println("From: " + singleEvent.fromHour);
            System.out.println("To: " + singleEvent.toHour);
            System.out.println("Day: " + singleEvent.day);
            System.out.println();
        }
    }
}
