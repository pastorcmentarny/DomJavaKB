package dom.coffirgar.transportmanager.mappers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.domain.stations.Stations;
import dom.coffirgar.transportmanager.domain.stations.Status;
import dom.coffirgar.transportmanager.validators.StationLineValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Slf4j
@Component
public final class ToStationConverter {

    private final ObjectMapper objectMapper;

    @Autowired
    public ToStationConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Stations fromStationsAsJson(String stationsAsJson) {
        try {
            log.info(stationsAsJson);
            return objectMapper.readValue(stationsAsJson, Stations.class);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Unable to convert because I cocked up something : " + jsonProcessingException.getMessage());
            return Stations.builder().build();
        }
    }

    public static Station fromStationAsString(String stationAsString) {
        final String[] validatedLine = StationLineValidator.validate(stationAsString);
        return new Station(validatedLine[0], Status.fromValue(validatedLine[1]), setDateFor(validatedLine[2]), setDateFor(validatedLine[3]), setDateFor(validatedLine[4]));
    }


    private static LocalDate setDateFor(String date) {
        return Objects.isNull(date) || "none".equalsIgnoreCase(date) ? null : LocalDate.parse(date);
    }

    public Station fromStationAsJson(String stationAsString) {
        try {
            log.info(stationAsString);
            return objectMapper.readValue(stationAsString, Station.class);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Unable to convert because I cocked up something : " + jsonProcessingException.getMessage());
            return Station.noStation();
        }

    }
}
