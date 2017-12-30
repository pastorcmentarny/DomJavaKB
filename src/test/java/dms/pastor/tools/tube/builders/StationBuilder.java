package dms.pastor.tools.tube.builders;

import dms.pastor.tools.tube.station.Line;
import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static dms.pastor.tools.tube.station.Station.notVisited;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.util.Collections.singletonList;

public final class StationBuilder {
    private String name = generateString(10);
    private List<Line> lines = singletonList(new Line(generateString(10)));
    private Status status = Status.values()[new Random().nextInt(Status.values().length)];
    private LocalDate passedDate = LocalDate.now();
    private LocalDate visitedDate = LocalDate.now();

    private StationBuilder() {
    }

    public static StationBuilder stationBuilder() {
        return new StationBuilder();
    }

    public Station build() {
        return new Station(name, status, lines, passedDate, visitedDate);
    }

    public Station buildNotVisitedStation() {
        return notVisited(name, lines);
    }

    public StationBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StationBuilder lines(List<Line> lines) {
        this.lines = lines;
        return this;
    }

    public StationBuilder status(Status status) {
        this.status = status;
        return this;
    }

    public StationBuilder passedDate(LocalDate passedDate) {
        this.passedDate = passedDate;
        return this;
    }

    public StationBuilder visitedDate(LocalDate visitedDate) {
        this.visitedDate = visitedDate;
        return this;
    }
}
