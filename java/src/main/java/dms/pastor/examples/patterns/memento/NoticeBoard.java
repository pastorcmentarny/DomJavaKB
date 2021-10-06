package dms.pastor.examples.patterns.memento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@ToString
@Getter
public class NoticeBoard {
    private LocalDateTime date;
    private String message;
    private boolean priority;


    public static NoticeBoard createNotice(String message) {
        return new NoticeBoard(LocalDateTime.now(), message, false);
    }

    public static NoticeBoard createHighPriorityNotice(String message) {
        return new NoticeBoard(LocalDateTime.now(), message, true);
    }


    public static NoticeBoard withMessageAndPriority(String message, boolean priority) {
        return new NoticeBoard(LocalDateTime.now(),message,priority);
    }

    public void update(String message) {
        this.message = message;
    }
}
