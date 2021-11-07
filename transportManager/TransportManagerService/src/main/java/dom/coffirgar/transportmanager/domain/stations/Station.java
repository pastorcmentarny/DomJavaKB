package dom.coffirgar.transportmanager.domain.stations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

import static dom.coffirgar.transportmanager.common.Utils.*;
import static dom.coffirgar.transportmanager.domain.stations.Status.NOT_VISITED;
import static dom.coffirgar.transportmanager.domain.stations.Status.PASSED;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@ToString
@EqualsAndHashCode
public class Station {

    private String name;
    private Status status;
    //private StationType stationType;
    private LocalDate passedDate;
    private LocalDate visitedDate;
    private LocalDate visitedThisYearDate;
    //LocalDateTime lastUpdatedOn;


    public static Station notVisited(String name) {
        return new Station(name, NOT_VISITED, null, null, null);
    }

    public static Station passed(String name, LocalDate passedDate) {
        return new Station(name, PASSED, passedDate, null, null);
    }

    public static Station noStation() {
        return new Station(EMPTY_STRING,Status.UNKNOWN,null,null,null);
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