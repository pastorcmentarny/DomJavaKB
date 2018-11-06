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
    int userId;
    long id;
    String state;//State (CREATED,DRAFT,DELETED,BACKLOG,PLANNED,INPROGRESS,COMPLETED,ARCHIVED)
    String title;
    String message;
    long timeStamp;
    private static final AtomicLong counter = new AtomicLong();

    public Task(int userId) {
        this.userId = userId;
        this.id = counter.incrementAndGet();
        this.state = State.CREATED.name();
        timeStamp = System.currentTimeMillis();
        this.title = "NEW TITLE";
        this.message = "NEW MESSAGE";
    }

    public Task() {
        System.out.println("Oh cock!");
    }

    public Task(int userId, long id, String title,
                String message) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.message = message;
        this.state = State.CREATED.name();
        timeStamp = System.currentTimeMillis();

    }


    public long getId() {
        return id;
    }

    public Task(int userId, String title, String message) {
        this.userId = userId;
        this.id = counter.incrementAndGet();
        this.title = title;
        this.message = message;
        this.state = State.CREATED.name();
        timeStamp = System.currentTimeMillis();
    }

    public int getUserId() {
        return userId;
    }

    public String getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }


    public void setState(String state) {
        this.state = state;
    }


}