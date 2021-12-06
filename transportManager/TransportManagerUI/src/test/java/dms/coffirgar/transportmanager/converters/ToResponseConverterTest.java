package dms.coffirgar.transportmanager.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import dms.coffirgar.transportmanager.domain.Response;
import dms.coffirgar.transportmanager.domain.Station;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class ToResponseConverterTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    ToResponseConverter converter = new ToResponseConverter(objectMapper);

    @Test
    void shouldConvertToResponseAcceptanceTest() {
        // given
        String input = """
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

    @Test
    void shouldReturnNoStationIfErrorOccurredDuringConversionDueToNull() {
        // given
        final Response expectedResult = new Response("ERROR", "Something went badly wrong and we got this sad error message json is null or empty", Station.noStation());

        // when
        final Response result = converter.convert(null);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnNoStationIfErrorOccurredDuringConversionIfJsonIsInvalid() {

        // when
        final Response result = converter.convert("dominik");

        // then
        assertThat(result.getResult()).isEqualTo("ERROR");
        assertThat(result.getDescription()).contains("Unrecognized token 'dominik': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')");
        assertThat(result.getDescription()).contains("at [Source: (String)\"dominik\"; line: 1, column: 8]");
        assertThat(result.getStation()).isNotNull();
    }


    @Test
    void isStationNullWhenResponseOKShouldReturnTrueIfStationIsNullButStatusIsOK() {
        // given
        final Response response = new Response("OK", "Everything is fine,except is wrong", null);

        // when
        boolean result = converter.isStationNullWhenResponseOK(response);

        // then
        assertThat(result).isTrue();
    }
}
