package HttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class HttpClientService {

    private static final String BASE_URL = "http://localhost:8080/api/event/";

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static final ObjectMapper mapper = new ObjectMapper();

    private final OkHttpClient client = new OkHttpClient();

    public List<Event> getAllEvents() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "all")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                String value = body.string();
                    return mapper.readValue(value, mapper.getTypeFactory().constructCollectionType(List.class, Event.class));
            }
        }
        return Collections.emptyList();
    }


    public void postEvent(PublishEvent event) throws IOException {
        RequestBody body = RequestBody.create(JSON, mapper.writeValueAsString(event));
        Request request = new Request.Builder()
                .url(BASE_URL + "add")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
             if(response.isSuccessful()) {
                 System.out.println("Successfully");
             } else {
                 System.out.println(response.message());
             }
        }
    }

    public void deleteAllEvents() throws  IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "drop")
                .delete()
                .build();
        try (Response response = client.newCall(request).execute()) {
            if(response.isSuccessful()) {
                System.out.println("Successfully");
            }
        }
    }
}
