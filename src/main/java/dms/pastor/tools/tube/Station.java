package dms.pastor.tools.tube;

import java.util.List;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 08/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Station {
    static final String SEPARATOR = ";;";
    private static final String LINE_SEPARATOR = "||";
    private final String name;
    private Status status;
    private final List<Line> lines;

    public Station(String name, Status status, List<Line> lines) {
        this.name = name;
        this.status = status;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusAsValue() {
        return status.value();
    }

    private List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return Objects.equals(getName(), station.getName()) &&
                getStatus() == station.getStatus() &&
                Objects.equals(getLines(), station.getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStatus(), getLines());
    }

    @Override
    public String toString() {
        return name + SEPARATOR + getStatusAsValue() + SEPARATOR + getLinesAsString();
    }

    //TODO stub
    private String getLinesAsString() {
        return lines.get(0).getName();
    }

}
