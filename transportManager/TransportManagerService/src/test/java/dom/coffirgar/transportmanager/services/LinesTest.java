package dom.coffirgar.transportmanager.services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    public void getAllTubeLinesNameAcceptanceTest() {
        // given
        LinesService linesService = new LinesService();
        List<String> expectedResult = List.of("Bakerloo", "Central", "Circle", "District", "HammersmithAndCity", "Jubilee", "Metropolitan", "Northern", "Piccadilly", "Victoria", "WaterlooAndCity");

        // when
        final List<String> result = linesService.getAllTubeLinesName();

        // debug
        System.out.println(result);

        // then
        assertThat(result.size()).isEqualTo(11);
        assertThat(result).isEqualTo(expectedResult);
    }
}