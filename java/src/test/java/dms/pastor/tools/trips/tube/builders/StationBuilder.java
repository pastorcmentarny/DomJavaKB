package dms.pastor.tools.trips.tube.builders;

import dms.pastor.tools.trips.tube.station.Line;
import dms.pastor.tools.trips.common.options.Status;
import dms.pastor.tools.trips.tube.station.TubeStation;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static dms.pastor.tools.trips.tube.station.TubeStation.notVisited;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public final class StationBuilder {
    private String name = generateString(10);
    private List<Line> lines = singletonList(new Line(generateString(10)));
    private Status status = Status.values()[new Random().nextInt(Status.values().length)];
    private LocalDate passedDate = LocalDate.now();
    private LocalDate visitedDate = LocalDate.now();
    private final LocalDate thisYearVisitedDate = LocalDate.now();
    private boolean blogged = true;

    private StationBuilder() {
    }

    public static StationBuilder stationBuilder() {
        return new StationBuilder();
    }

    public TubeStation build() {
        return new TubeStation(name, status, passedDate, visitedDate, thisYearVisitedDate, blogged);
    }

    public TubeStation buildNotVisitedStation() {
        return notVisited(name);
    }

    public StationBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StationBuilder lines(List<Line> lines) {
        this.lines = lines;
        return this;
    }

    public StationBuilder noLines() {
        this.lines = emptyList();
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

    public StationBuilder blogged(boolean blogged) {
        this.blogged = blogged;
        return this;
    }
}
