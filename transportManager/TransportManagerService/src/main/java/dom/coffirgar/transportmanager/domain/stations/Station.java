package dom.coffirgar.transportmanager.domain.stations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

import static dom.coffirgar.transportmanager.common.Utils.*;
import static dom.coffirgar.transportmanager.domain.stations.Status.*;


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


    public boolean isNotAStation() {
        return Objects.isNull(name) || name.isEmpty() || status == UNKNOWN;
    }

    public boolean isPassedAlready() {
        return status != NOT_VISITED && status != UNKNOWN;
    }

}