package dms.pastor.tools.trips.common.station;

import dms.pastor.domain.exception.NotImplementYetException;
import dms.pastor.tools.trips.common.options.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

import static dms.pastor.tools.trips.common.Constants.getDateAsStringOrNone;
import static dms.pastor.tools.trips.common.options.Status.NOT_VISITED;
import static dms.pastor.tools.trips.common.options.Status.PASSED;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.file.TextFileUtils.FIELD_SEPARATOR;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
@EqualsAndHashCode
public class Station {

    @Getter
    private final String name;
    @Setter
    @Getter
    private Status status;
    @Setter
    @Getter
    private LocalDate passedDate;
    @Setter
    @Getter
    private LocalDate visitedDate;
    private LocalDate thisYearVisitedDate;
    @Getter
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

    public LocalDate getVisitedThisYearDate() {
        return thisYearVisitedDate;
    }

    public void setVisitedStationThisYearToNow() {
        this.thisYearVisitedDate = LocalDate.now();
    }

    public String getStatusAsValue() {
        return status.value();
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
                getDateAsStringOrNone(passedDate) + FIELD_SEPARATOR +
                getDateAsStringOrNone(visitedDate) + FIELD_SEPARATOR +
                getDateAsStringOrNone(thisYearVisitedDate) + FIELD_SEPARATOR +
                getBloggedAsString();
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
            System.out.println("You visited " + name + " station in 2018 at " + thisYearVisitedDate);
            thisYearVisitedDate = null;
        }
    }
}
