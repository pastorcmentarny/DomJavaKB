package dom.coffirgar.transportmanager.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dom.coffirgar.transportmanager.domain.Response;
import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.domain.stations.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ToResponseConverterTest {
    ObjectMapper objectMapper = getObjectMapper();

    private ObjectMapper getObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    ToResponseConverter converter = new ToResponseConverter(objectMapper);

    @Test
    void shouldReturnResponseObject() {
        // given
        String input = """
                {
                	"result": "OK",
                	"description": "Station Aldgate was found.",
                	"station": {
                		"name": "Aldgate",
                		"status": "V",
                		"passedDate": "2017-02-02",
                		"visitedDate": "2018-05-01",
                		"visitedThisYearDate": "2018-05-03"
                	}
                }""";
        Response expectedResponse = new Response("OK", "Station Aldgate was found.", new Station("Aldgate", Status.VISITED, LocalDate.of(2017, 2, 2), LocalDate.of(2018, 5, 1), LocalDate.of(2018, 5, 3)));

        // when
        final Response response = converter.fromJsonAsString(input);

        // debug
        System.out.println("RESPONSE: " + response.toString());

        // then
        assertThat(response.getResult()).isNotEqualTo("ERROR");
        assertThat(response).isEqualTo(expectedResponse);

    }
}