package dms.coffirgar.transportmanager.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dms.coffirgar.transportmanager.domain.Station;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ToStationConverter {
    private final ObjectMapper objectMapper;

    @Autowired
    public ToStationConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Station convert(String stationAsString) {
        try {
            return objectMapper.readValue(stationAsString, Station.class);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error(jsonProcessingException.getMessage());
            return Station.noStation();
        }
    }
}
