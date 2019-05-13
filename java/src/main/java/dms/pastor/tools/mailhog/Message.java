package dms.pastor.tools.mailhog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Message {
    private final String to;
    private final String subject;
    private final String body;
}
