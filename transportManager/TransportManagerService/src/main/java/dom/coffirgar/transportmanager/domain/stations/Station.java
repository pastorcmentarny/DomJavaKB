package dom.coffirgar.transportmanager.domain.stations;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

import static dom.coffirgar.transportmanager.common.Utils.FIELD_SEPARATOR;
import static dom.coffirgar.transportmanager.common.Utils.getDateAsStringOrNone;
import static dom.coffirgar.transportmanager.domain.stations.Status.NOT_VISITED;
import static dom.coffirgar.transportmanager.domain.stations.Status.PASSED;


@Getter
@EqualsAndHashCode
public class Station {

    private final String name;
    private Status status;
    private StationType stationType;
    private LocalDate passedDate;
    private LocalDate visitedDate;
    private LocalDate visitedThisYearDate;
    //LocalDateTime lastUpdatedOn;

    @SuppressWarnings("ConstructorWithTooManyParameters") //not apply in this case
    public Station(String name, Status status, LocalDate passedDate, LocalDate visitedDate, LocalDate thisYearVisitedDate) {
        this.name = name;
        this.status = status;
        this.passedDate = passedDate;
        this.visitedDate = visitedDate;
        this.visitedThisYearDate = thisYearVisitedDate;
    }

    public static Station notVisited(String name) {
        return new Station(name, NOT_VISITED, null, null, null);
    }

    public static Station passed(String name, LocalDate passedDate) {
        return new Station(name, PASSED, passedDate, null, null);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPassedDate(LocalDate date) {
        this.passedDate = date;
    }

    public void setPassedDateToNow() {
        passedDate = LocalDate.now();
    }

    public void setVisitedDateToNow() {
        visitedDate = LocalDate.now();
    }

    public void setVisitedStationThisYearToNow() {
        visitedThisYearDate = LocalDate.now();
    }

    public String getStatusAsValue() {
        return status.value();
    }

    public String asLine() {
        return name + FIELD_SEPARATOR +
                getStatusAsValue() + FIELD_SEPARATOR +
                getDateAsStringOrNone(passedDate) + FIELD_SEPARATOR +
                getDateAsStringOrNone(visitedDate) + FIELD_SEPARATOR +
                getDateAsStringOrNone(visitedThisYearDate);
    }
}