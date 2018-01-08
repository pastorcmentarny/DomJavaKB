package dms.pastor.snippets.error;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 30/12/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Field {
    private final String name;
    private final String message;

    public Field(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;
        Field field = (Field) o;
        return Objects.equals(name, field.name) &&
                Objects.equals(message, field.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, message);
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
