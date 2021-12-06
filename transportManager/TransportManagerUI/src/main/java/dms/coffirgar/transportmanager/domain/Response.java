package dms.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static dms.coffirgar.transportmanager.configurations.Constants.ERROR;
import static dms.coffirgar.transportmanager.configurations.Constants.NOT_FOUND;

//TODO rename to StationResponse
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class Response {

    //FIXME
    public String getResult() {
        return result;
    }

    //FIXME
    public String getDescription() {
        return description;
    }

    //FIXME
    public Station getStation() {
        return station;
    }

    private String result;
    private String description;
    private Station station;


    public static Response notFound(String stationName) {
        return new Response(NOT_FOUND, stationName + " not found", Station.noStation());
    }

    public static Response error(String errorMessage) {
        return new Response(ERROR, "Something went badly wrong and we got this sad error message " + errorMessage, Station.noStation());
    }
}