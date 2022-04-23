package dms.pastor.domain;

import org.junit.jupiter.api.Test;

import static dms.pastor.domain.TrainType.BEMU;
import static org.assertj.core.api.Assertions.assertThat;


class TrainTest {

    @Test
    void trainToStringAcceptanceTest() {
        // given
        final var testTrain = Train.builder()
                .trainId("8271")
                .trainType(BEMU)
                .inService(true)
                .description("test")
                .maxSpeed(220)
                .build();

        final var expectedResult = """
                Train{British Class:'8271', Train Type:BEMU, Is it service?:yes, maxSpeed(in kmh)=220,
                description='test'}""";

        // when
        final var result = testTrain.toString();

        // then

        assertThat(result).isEqualTo(expectedResult);
    }
}