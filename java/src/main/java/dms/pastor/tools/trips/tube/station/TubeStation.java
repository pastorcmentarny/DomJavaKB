package dms.pastor.tools.trips.tube.station;

import dms.pastor.domain.exception.NotImplementYetException;

import java.time.LocalDate;
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
    private Status status;
    private LocalDate passedDate;
    private LocalDate visitedDate;
    private LocalDate thisYearVisitedDate;
    private boolean blogged;

    @SuppressWarnings("ConstructorWithTooManyParameters") //not apply in this case
    public TubeStation(String name, Status status, LocalDate passedDate, LocalDate visitedDate, LocalDate thisYearVisitedDate, boolean blogged) {
        this.name = name;
        this.status = status;
        this.passedDate = passedDate;
        this.visitedDate = visitedDate;
        this.thisYearVisitedDate = thisYearVisitedDate;
        this.blogged = blogged;
    }

    public static TubeStation notVisited(String name) {
        return new TubeStation(name, NOT_VISITED, null, null, null, false);
    }

    public static TubeStation passed(String name, LocalDate passedDate) {
        return new TubeStation(name, PASSED, passedDate, null, null, false);
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

    void setPassedDate(LocalDate passedDate) {
        this.passedDate = passedDate;
    }

    public LocalDate getVisitedDate() {
        return visitedDate;
    }

    void setVisitedDate(LocalDate visitedDate) {
        this.visitedDate = visitedDate;
    }

    public LocalDate getVisitedThisYearDate() {
        return thisYearVisitedDate;
    }

    void setVisitedStationThisYearToNow() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TubeStation)) return false;
        TubeStation that = (TubeStation) o;
        return isBlogged() == that.isBlogged() &&
                Objects.equals(getName(), that.getName()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getPassedDate(), that.getPassedDate()) &&
                Objects.equals(getVisitedDate(), that.getVisitedDate()) &&
                Objects.equals(thisYearVisitedDate, that.thisYearVisitedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStatus(), getPassedDate(), getVisitedDate(), thisYearVisitedDate, isBlogged());
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

    //TODO extract this method
    public String asFormattedString() {
        return getName() + " was " + getStatus().asName() + getDateToDisplay();
    }

    public String asLine() {
        return name + SEPARATOR +
                getStatusAsValue() + SEPARATOR +
                getDate(passedDate) + SEPARATOR +
                getDate(visitedDate) + SEPARATOR +
                getDate(thisYearVisitedDate) + SEPARATOR +
                getBloggedAsString();
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

    public void clearVisitedThisYear() {
        if(Objects.nonNull(thisYearVisitedDate)){
            System.out.println("You visited  " + name+ " station in 2018 at " + thisYearVisitedDate.toString());
            thisYearVisitedDate = null;
        }
    }
}
