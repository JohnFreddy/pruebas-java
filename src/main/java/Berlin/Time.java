package Berlin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Time {
    private String singleMinutes;
    private String fiveMinutes;
    private String singleHours;
    private String fiveHours;
    private String seconds;
}
