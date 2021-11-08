package dom.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dom.coffirgar.transportmanager.domain.stations.Station;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@ToString
@EqualsAndHashCode
public class Response {
    private String result;
    private String description;
    private Station station;

    public static Response notFound(String stationName){
        return new Response("NOT FOUND",stationName + " not found", null);
    }

    public static Response error(String message) {
        return new Response("ERROR","Unable to read response due to : " + message,Station.noStation());
    }

    public static Response ok(Station station) {
        return new Response("OK","Station " + station.getName() + " was found.",station);
    }
}
