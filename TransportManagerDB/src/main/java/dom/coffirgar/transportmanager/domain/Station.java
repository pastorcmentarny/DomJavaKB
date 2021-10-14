package dom.coffirgar.transportmanager.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static dom.coffirgar.transportmanager.domain.Status.NOT_VISITED;
import static dom.coffirgar.transportmanager.domain.Status.PASSED;


@Getter
@EqualsAndHashCode
public class Station {

    private final String name;
    private Status status;
    private StationType stationType;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPassedDate(LocalDate date) {
        this.passedDate = passedDate;
    }

    public void setPassedDateToNow(){
        passedDate = LocalDate.now();
    }

    public void setVisitedDateToNow() {
        visitedDate = LocalDate.now();
    }

    public void setVisitedStationThisYearToNow() {
        thisYearVisitedDate = LocalDate.now();
    }
}