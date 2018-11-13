package dms.pastor.spring.tools.getdone.model;

import dms.pastor.spring.tools.getdone.commons.State;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Task {
    private int userId;
    private long id;
    private String state;//State (CREATED,DRAFT,DELETED,BACKLOG,PLANNED,IN_PROGRESS,COMPLETED,ARCHIVED)
    private static final AtomicLong counter = new AtomicLong();

    public Task(int userId) {
        this.userId = userId;
        this.id = counter.incrementAndGet();
        this.state = State.CREATED.name();
        long timeStamp = System.currentTimeMillis();
        String title = "NEW TITLE";
        String message = "NEW MESSAGE";
    }


    public long getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }


    public void setState(String state) {
        this.state = state;
    }


}