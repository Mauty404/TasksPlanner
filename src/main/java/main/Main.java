package main;


import HttpClient.Event;
import HttpClient.HttpClientService;
import pl.MainWindow;
import java.io.IOException;
import java.util.List;

public class Main {

        private static final HttpClientService service = new HttpClientService();

        public static void main(String[] args)  throws IOException {
        MainWindow mainWindow = new MainWindow();
        mainWindow.createMainWindow();

                List<Event> events  = service.getAllEvents();
                events.forEach(System.out::println);
        }
}