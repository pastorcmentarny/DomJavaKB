package dms.pastor.tools.tube;

import java.util.List;

public class Station {
    private String name;
    private Status status;
    private List<Line> lines;

    public Station(String name, Status status, List<Line> lines) {
        this.name = name;
        this.status = status;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public List<Line> getLines() {
        return lines;
    }
}
