package dms.pastor.tools.trips.tube.station;

import dms.pastor.domain.exception.NotImplementYetException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static dms.pastor.tools.trips.tube.station.Status.NOT_VISITED;
import static dms.pastor.tools.trips.tube.station.Status.PASSED;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class TubeStation {//implements Station {
    public static final String SEPARATOR = ";;";
    private final String name;
    private final List<Line> lines;
    private Status status;
    private LocalDate passedDate;
    private LocalDate visitedDate;
    private LocalDate thisYearVisitedDate;

    @SuppressWarnings("ConstructorWithTooManyParameters") //not apply in this case
    public TubeStation(String name, Status status, List<Line> lines, LocalDate passedDate, LocalDate visitedDate, LocalDate thisYearVisitedDate) {
        this.name = name;
        this.status = status;
        this.lines = lines;
        this.passedDate = passedDate;
        this.visitedDate = visitedDate;
        this.thisYearVisitedDate = thisYearVisitedDate;
    }

    public static TubeStation notVisited(String name, List<Line> lines) {
        return new TubeStation(name, NOT_VISITED, lines, null, null, null);
    }

    public static TubeStation passed(String name, List<Line> lines, LocalDate passedDate) {
        return new TubeStation(name, PASSED, lines, passedDate, null, null);
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
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

    public void setStatus(Status status) {
        this.status = status;
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
        if (o == null || getClass() != o.getClass()) return false;
        TubeStation tubeStation = (TubeStation) o;
        return Objects.equals(getName(), tubeStation.getName()) &&
                Objects.equals(getLines(), tubeStation.getLines()) &&
                getStatus() == tubeStation.getStatus() &&
                Objects.equals(getPassedDate(), tubeStation.getPassedDate()) &&
                Objects.equals(getVisitedDate(), tubeStation.getVisitedDate()) &&
                Objects.equals(thisYearVisitedDate, tubeStation.thisYearVisitedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLines(), getStatus(), getPassedDate(), getVisitedDate(), thisYearVisitedDate);
    }

    @Override
    public String toString() {
        return "TubeStation{" +
                "name='" + name + '\'' +
                ", lines=" + lines +
                ", status=" + status +
                ", passedDate=" + passedDate +
                ", visitedDate=" + visitedDate +
                ", thisYearVisitedDate=" + thisYearVisitedDate +
                '}';
    }

    //TODO stub
    private String getLinesAsString() {
        return lines.get(0).getName();
    }

    //TODO extract this method
    public String asFormattedString() {
        return getName() + " was " + getStatus().asName() + getDateToDisplay();
    }

    public String asLine() {
        return name + SEPARATOR +
                getStatusAsValue() + SEPARATOR +
                getLinesAsString() + SEPARATOR +
                getDate(passedDate) + SEPARATOR +
                getDate(visitedDate) + SEPARATOR +
                getDate(thisYearVisitedDate);

    }

    private String getDate(LocalDate date) {
        return date == null ? "none" : date.toString();
    }

    private String getDateToDisplay() {
        switch (status) {
            case VISITED:
                return " at " + getVisitedDate();
            case PASSED:
                return " at " + getPassedDate();
            case NOT_VISITED:
                return EMPTY_STRING;
            default:
                throw new NotImplementYetException();
        }
    }
}