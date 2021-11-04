package dms.pastor.spring.examples.json;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JsonObjectBuilderTest {

    @Test
    void shouldBuildJsonObject(){

        // when
        final JsonObject result = JsonObjectBuilder.jsonObjectBuilder().build();

        // then
        assertThat(result.toString()).isNotBlank();
        assertThat(result.getName()).isNotBlank();
        assertThat(result.getVersion()).isGreaterThanOrEqualTo(0);
    }

}