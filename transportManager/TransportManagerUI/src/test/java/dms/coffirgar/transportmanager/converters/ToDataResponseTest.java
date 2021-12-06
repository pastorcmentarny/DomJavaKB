package dms.coffirgar.transportmanager.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import dms.coffirgar.transportmanager.domain.DataResponse;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static dms.coffirgar.transportmanager.configurations.Constants.EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

class ToDataResponseTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private ToDataResponse converter = new ToDataResponse(objectMapper);

    @Test
    void shouldTransformToDataResponseObject() {
        // given
        Map<String, String> expectedResultData = new HashMap<>();
        expectedResultData.put("key1", "value1");
        expectedResultData.put("key2", "value2");
        expectedResultData.put("key3", "value3");
        final String input = """
                {
                  "key1" : "value1",
                  "key2" : "value2",
                  "key3" : "value3"
                }""";

        final DataResponse expectedResult = DataResponse.ok(expectedResultData);

        // when
        final DataResponse result = converter.convert(input);

        /// debug
        System.out.println(result);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void shouldReturnErrorDataResponseIfInputIsNull() {
        // given
        final DataResponse expectedResult = DataResponse.error("Data is null or empty");

        // when
        final DataResponse result = converter.convert(null);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnErrorDataResponseIfInputIsEmpty() {
        // given
        final DataResponse expectedResult = DataResponse.error("Data is null or empty");

        // when
        final DataResponse result = converter.convert(EMPTY);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldReturnErrorDataResponseIfInputIsInvalid() {

        // when
        final DataResponse result = converter.convert("Garlic");

        // then
        assertThat(result.getResult()).isEqualTo("ERROR");
        assertThat(result.getDescription()).startsWith("Something went badly wrong and we got this sad error message: Unable to convert due to:Unrecognized token 'Garlic'");
        assertThat(result.getData()).isEmpty();
    }
}