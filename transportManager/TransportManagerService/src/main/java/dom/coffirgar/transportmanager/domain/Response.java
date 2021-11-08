package dom.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.domain.stations.Status;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@ToString
@EqualsAndHashCode
public class Response {
    private static final String OK = "OK"; //TODO move to enum
    private static final String ERROR = "ERROR";
    private String result;
    private String description;
    private Station station;

    public static Response notFound(String stationName){
        return new Response("NOT FOUND",stationName + " not found", null);
    }

    public static Response error(String message) {
        return new Response(ERROR,"Unable to read response due to : " + message,Station.noStation());
    }

    public static Response ok(Station station) {
        return new Response(OK,"Station " + station.getName() + " was found.",station);
    }

    public boolean isOK() {
        return Objects.equals(result, OK);
    }

    public void updateToPassed() {
        station.setStatus(Status.PASSED);
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
}
