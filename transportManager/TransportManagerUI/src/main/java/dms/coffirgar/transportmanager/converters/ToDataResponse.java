package dms.coffirgar.transportmanager.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dms.coffirgar.transportmanager.domain.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class ToDataResponse {
    private final ObjectMapper objectMapper;

    @Autowired
    public ToDataResponse(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public DataResponse convert(String dataAsString) {
        try {
            if (Objects.isNull(dataAsString) || dataAsString.isEmpty()) {
                return DataResponse.error("Data is null or empty");
            }

            final Map<String, String> data = objectMapper.readValue(dataAsString, new TypeReference<>() {
            });
            return DataResponse.ok(data);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error(jsonProcessingException.getMessage());
            return DataResponse.error("Unable to convert due to:" + jsonProcessingException.getMessage() + " . StationData : " + dataAsString);
        }
    }
}
