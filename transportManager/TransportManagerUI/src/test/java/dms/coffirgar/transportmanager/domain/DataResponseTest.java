package dms.coffirgar.transportmanager.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static dms.coffirgar.transportmanager.configurations.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class DataResponseTest {

    @Test
    void shouldCreateDataResponse() {
        // given
        HashMap<String, String> input = new HashMap<>();
        input.put("key1", "value1");
        input.put("key2", "value2");

        final DataResponse expectedResult = new DataResponse(OK, EMPTY, input);

        // when
        final DataResponse result = DataResponse.ok(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldCreateErrorDataResponseForInvalidCase() {
        // given
        final DataResponse expectedResult = new DataResponse(ERROR, "Something went badly wrong and we got this sad error message: Poonami", new HashMap<>(0));

        // when
        final DataResponse result = DataResponse.error("Poonami");

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}