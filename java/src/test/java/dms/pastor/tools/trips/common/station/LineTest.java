package dms.pastor.tools.trips.common.station;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void generateLineAcceptanceTest() {
        // given
        final var name = "Test";

        // when
        Line line = new Line(name);

        // then
        assertThat(line.toString()).isEqualTo("Line{name='Test'}");
    }
}