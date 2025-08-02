package dms.pastor.tools.readtimer;

import org.junit.jupiter.api.Test;

import static dms.pastor.tools.readtimer.TimeToReadApplicationInputValidator.validateInputArgs;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 26/12/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class TimeToReadApplicationInputValidatorTest {


    @Test
    public void shouldThrowExceptionIfYouRunApplicationWith1Argument() {
        // given
        final String[] args = {generateString()};

        // when
        assertThrows(IllegalArgumentException.class, () -> TimeToReadApplication.main(args));
    }

    @Test
    public void shouldThrowExceptionIfYouRunApplicationWithWithNegativeSpeedArgument() {

        // given
        final String[] args = {generateString(), String.valueOf(randomNegativeInteger())};

        // when
        assertThrows(IllegalArgumentException.class, () -> TimeToReadApplication.main(args));

    }

    @Test
    public void shouldThrowExceptionWhenTextIsNull() {
        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        assertThrows(IllegalArgumentException.class, () -> TimeToReadApplication.main(args));
    }

    @Test
    public void shouldThrowExceptionWhenTextIsEmpty() {
        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        assertThrows(IllegalArgumentException.class, () -> TimeToReadApplication.main(args));

    }

    @Test
    public void shouldThrowExceptionWhenSpeedIsNotAValidNumber() {
        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        assertThrows(IllegalArgumentException.class, () -> TimeToReadApplication.main(args));
    }

    @Test
    public void getReadSpeedShouldThrowIllegalArgumentException() {
        // when
        final String text = generateString();
        final String invalidSpeed = generateString();
        assertThrows(IllegalArgumentException.class, () -> validateInputArgs(new String[]{text, invalidSpeed}));

    }
}
