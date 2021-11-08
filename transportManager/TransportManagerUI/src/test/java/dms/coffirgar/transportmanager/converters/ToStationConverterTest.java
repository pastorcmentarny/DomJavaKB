package dms.coffirgar.transportmanager.converters;


import com.fasterxml.jackson.databind.ObjectMapper;
import dms.coffirgar.transportmanager.domain.Station;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ToStationConverterTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    ToStationConverter converter = new ToStationConverter(objectMapper);

    @Test
    void shouldConvertToResponseAcceptanceTest() {

        // given
        final String input = """
                {
                		"name": "Aldgate",
                		"status": "V",
                		"passedDate": "2017-11-01",
                		"visitedDate": "2018-05-01",
                		"visitedThisYearDate": "2019-05-03"
                	}""";

        final Station expectedResult = new Station("Aldgate", "V", "2017-11-01", "2018-05-01", "2019-05-03");

        // when
        final Station result = converter.convert(input);

        // debug
        System.out.println(result.toString());

        // then
        assertThat(result).isEqualTo(expectedResult);

    }
}