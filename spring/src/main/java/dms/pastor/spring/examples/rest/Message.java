package dms.pastor.spring.examples.rest;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Message {
    private final long id;
    private final String message;
    private final LocalDate created;


    @Deprecated
    public Message() {
        this(0L, null, null);
    }

    public Message(long id, String message, LocalDate created) {
        this.id = id;
        this.message = message;
        this.created = created;
    }

    private long getId() {
        return id;
    }

    private String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return getId() == message1.getId() &&
                Objects.equals(getMessage(), message1.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMessage());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", created=" + created +
                '}';
    }
}
