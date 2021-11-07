package dms.coffirgar.transportmanager.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import dms.coffirgar.transportmanager.domain.Response;
import dms.coffirgar.transportmanager.domain.Station;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToResponseConverterTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    ToResponseConverter converter = new ToResponseConverter(objectMapper);

    @Test
    void shouldConvertToResponse() {
        // given
        String input =  """
                {
                	"result": "OK",
                	"description": "Station Aldgate was found.",
                	"station": {
                		"name": "Aldgate",
                		"status": "V",
                		"passedDate": "2017-11-01",
                		"visitedDate": "2018-05-01",
                		"visitedThisYearDate": "2018-05-03"
                	}
                }""";

        Response expectedResult = new Response("OK", "Station Aldgate was found.", new Station("Aldgate", "V", "2017-11-01", "2018-05-01", "2018-05-03"));


        // when
        final Response result = converter.convert(input);

        // debug
        System.out.println(result.toString());

        // then
        assertThat(result).isEqualTo(expectedResult);


    }

}