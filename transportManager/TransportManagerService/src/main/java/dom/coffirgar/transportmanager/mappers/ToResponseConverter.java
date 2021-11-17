package dom.coffirgar.transportmanager.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dom.coffirgar.transportmanager.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ToResponseConverter {

    private final ObjectMapper objectMapper;

    @Autowired
    public ToResponseConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Response fromJsonAsString(String responseJson) {
        try {
            return objectMapper.readValue(responseJson, Response.class);
        } catch (Exception jsonProcessingException) {
            log.error("Unable to convert because I cocked up something : " + jsonProcessingException.getMessage());
            return Response.error(jsonProcessingException.getMessage());
        }
    }
}
