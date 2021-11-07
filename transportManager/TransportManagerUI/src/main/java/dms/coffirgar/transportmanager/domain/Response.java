package dms.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class Response {

    public String getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }

    public Station getStation() {
        return station;
    }

    private String result;
    private String description;
    private Station station;


    public static Response notFound(String stationName) {
        return new Response("NOT FOUND", stationName + " not found", Station.noStation());
    }

    public static Response error(String errorMessage) {
        return new Response("ERROR", "Something went badly wrong and we got this sad error message " + errorMessage, Station.noStation());
    }
}