package dms.pastor.tools.trips.tube.lines;

import dms.pastor.domain.exception.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class LinesTest {

    @Test
    public void getLinesShouldReturnAllLines() {
        // when
        final var lines = Lines.getLines();

        // then
        assertThat(lines).hasSize(11);
    }

    @Test
    public void findLineShouldThrowNotFoundExceptionIfNull() {

        // when and then throws
        assertThrows(NotFoundException.class, () -> Lines.findLine(null));

    }

    @Test
    public void findLineShouldThrowNotFoundExceptionIfEmpty() {
        // when and then throws
        assertThrows(NotFoundException.class, () -> Lines.findLine(""));
    }

    @Test
    public void findLineShouldThrowNotFoundExceptionIfInvalid() {
        // when and then throws
        assertThrows(NotFoundException.class, () -> Lines.findLine("GarlicExpress"));
    }

    @Test
    public void findLineShouldFindWaterlooAndCityLine() {
        // given
        final var expectedResult = new WaterlooAndCity();

        // when
        final var result = Lines.findLine("WaterlooAndCity");

        // then
        assertThat(result.name()).isEqualTo(expectedResult.name());
    }
}