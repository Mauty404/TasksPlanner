package pl;
import java.util.Vector;

public class EventCompositor {
    private static EventCompositor singleInstance = null;

    public static EventCompositor getInstance() {
        if (singleInstance == null)
            singleInstance = new EventCompositor();

        return singleInstance;
    }

    Vector<SingleEvent> components = new Vector<>();

    public class SingleEvent {
        String name;
        String fromHour;
        String toHour;
        int day;
    }

}
