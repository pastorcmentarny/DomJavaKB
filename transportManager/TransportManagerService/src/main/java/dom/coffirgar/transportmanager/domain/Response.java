package dom.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dom.coffirgar.transportmanager.domain.stations.Station;
import lombok.*;

import java.util.Objects;

import static dom.coffirgar.transportmanager.common.Utils.notEquals;
import static dom.coffirgar.transportmanager.domain.stations.Status.PASSED;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@ToString
@EqualsAndHashCode
public class Response {
    private static final String OK = "OK"; //TODO move to enum
    private static final String ERROR = "ERROR";
    private static final String WARNING = "WARNING";
    private static final String NOT_FOUND = "NOT_FOUND";
    private String result;
    private String description;
    private Station station;

    public static Response notFound(String stationName) {
        return new Response(NOT_FOUND, stationName + " not found", null);
    }

    public static Response error(String message) {
        return new Response(ERROR, "Unable to read response due to : " + message, Station.noStation());
    }

    public static Response ok(Station station) {
        return new Response(OK, "Station " + station.getName() + " was found.", station);
    }

    public boolean isOK() {
        return Objects.equals(result, OK);
    }

    public void updateToPassed() {
        station.setStatus(PASSED);
        station.setPassedDateToNow();
    }

    public void toError(String errorMessage) {
        this.result = ERROR;
        this.description = errorMessage;
    }

    public boolean isNotOK() {
        return not(isOK());
    }

    private boolean not(boolean ok) {
        return false;
    }

    public void toWarning(String warningMessage) {
        if (notEquals(result, ERROR)) {
            this.result = WARNING;
            this.description = warningMessage;
        }
    }


    public void toInfo(String informationMessage) {
        if (notEquals(result, ERROR) && notEquals(result, WARNING)) {
            this.result = OK;
            this.description = informationMessage;
        }
    }

    public void updateToVisitedThisYear() {
        station.setVisitedStationThisYearToNow();
    }

    public void updateToVisited() {
        station.updateStationToVisited();
    }
}
