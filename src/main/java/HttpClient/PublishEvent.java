package HttpClient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublishEvent {

    private String name;

    private String fromHour;

    private String toHour;

    private int day;
}
