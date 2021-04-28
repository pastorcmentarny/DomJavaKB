package dms.pastor.tools.trips.common.station;

import dms.pastor.domain.exception.NotImplementYetException;
import dms.pastor.tools.trips.common.options.Status;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Objects;

import static dms.pastor.tools.trips.common.options.Status.NOT_VISITED;
import static dms.pastor.tools.trips.common.options.Status.PASSED;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.file.TextFileUtils.FIELD_SEPARATOR;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@EqualsAndHashCode
public class Station {

    private final String name;
    private Status status;
    private LocalDate passedDate;
    private LocalDate visitedDate;
    private LocalDate thisYearVisitedDate;
    private boolean blogged;

    @SuppressWarnings("ConstructorWithTooManyParameters") //not apply in this case
    public Station(String name, Status status, LocalDate passedDate, LocalDate visitedDate, LocalDate thisYearVisitedDate, boolean blogged) {
        this.name = name;
        this.status = status;
        this.passedDate = passedDate;
        this.visitedDate = visitedDate;
        this.thisYearVisitedDate = thisYearVisitedDate;
        this.blogged = blogged;
    }

    public static Station notVisited(String name) {
        return new Station(name, NOT_VISITED, null, null, null, false);
    }

    public static Station passed(String name, LocalDate passedDate) {
        return new Station(name, PASSED, passedDate, null, null, false);
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getPassedDate() {
        return passedDate;
    }

    public void setPassedDate(LocalDate passedDate) {
        this.passedDate = passedDate;
    }

    public LocalDate getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(LocalDate visitedDate) {
        this.visitedDate = visitedDate;
    }

    public LocalDate getVisitedThisYearDate() {
        return thisYearVisitedDate;
    }

    public void setVisitedStationThisYearToNow() {
        this.thisYearVisitedDate = LocalDate.now();
    }

    public String getStatusAsValue() {
        return status.value();
    }

    public boolean isBlogged() {
        return blogged;
    }

    private String getBloggedAsString() {
        return blogged ? "Y" : "N";
    }

    public void setBlogged() {
        blogged = true;
    }

    @Override
    public String toString() {
        return "TubeStation{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", passedDate=" + passedDate +
                ", visitedDate=" + visitedDate +
                ", thisYearVisitedDate=" + thisYearVisitedDate +
                ", blogged=" + blogged +
                '}';
    }

    public String asFormattedString() {
        return getName() + " was " + getStatus().asName() + getDateToDisplay();
    }

    public String asLine() {
        return name + FIELD_SEPARATOR +
                getStatusAsValue() + FIELD_SEPARATOR +
                getDate(passedDate) + FIELD_SEPARATOR +
                getDate(visitedDate) + FIELD_SEPARATOR +
                getDate(thisYearVisitedDate) + FIELD_SEPARATOR +
                getBloggedAsString();
    }

    private String getDate(LocalDate date) {
        return date == null ? "none" : date.toString();
    }

    private String getDateToDisplay() {
        return switch (status) {
            case VISITED -> " at " + getVisitedDate();
            case PASSED -> " at " + getPassedDate();
            case NOT_VISITED -> EMPTY_STRING;
            default -> throw new NotImplementYetException();
        };
    }

    public void clearVisitedThisYear() {
        if (Objects.nonNull(thisYearVisitedDate)) {
            System.out.println("You visited  " + name + " station in 2018 at " + thisYearVisitedDate.toString());
            thisYearVisitedDate = null;
        }
    }
}
