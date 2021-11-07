package dms.coffirgar.transportmanager.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dms.coffirgar.transportmanager.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.util.Objects.isNull;

@Slf4j
@Component
public class ToResponseConverter {
    private final ObjectMapper objectMapper;

    @Autowired
    public ToResponseConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Response convert(String stationAsString) {
        try {
            final Response response = objectMapper.readValue(stationAsString.replace("\n \t",""), Response.class);
            System.out.println("RESPONSE:"+ response);
            return getResponse(stationAsString, response);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error(jsonProcessingException.getMessage());
            return Response.error("Unable to convert due to:" + jsonProcessingException.getMessage() + " . StationData : " + stationAsString);
        }
    }

    private Response getResponse(String stationAsString, Response response) {

        if (isNull(response) || isNull(response.getStation())) {
            return Response.error("Invalid respond from server. Response: " + stationAsString);
        }
        return response;
    }
}
