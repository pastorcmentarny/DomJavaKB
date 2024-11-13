package dms.pastor.spring.tools.getdone.model;

import dms.pastor.spring.tools.getdone.commons.State;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Getter
@Setter
public class Task {
    private static final AtomicLong counter = new AtomicLong();
    private int userId;
    private long id;
    private String state;//State (CREATED,DRAFT,DELETED,BACKLOG,PLANNED,IN_PROGRESS,COMPLETED,ARCHIVED)

    public Task(int userId) {
        this.userId = userId;
        this.id = counter.incrementAndGet();
        this.state = State.CREATED.name();
        long timeStamp = System.currentTimeMillis();
        String title = "NEW TITLE";
        String message = "NEW MESSAGE";
    }

}
