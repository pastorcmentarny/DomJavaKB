package dms.pastor.exercises.readtimer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.exercises.readtimer.TimeToReadApplicationInputValidator.validateInputArgs;
import static dms.pastor.utils.RandomDataGenerator.*;

/**
 * Author Dominik Symonowicz
 * Created 26/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class TimeToReadApplicationInputValidatorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfYouRunApplicationWith1Argument() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {generateString()};

        // when
        TimeToReadApplication.main(args);

    }

    @Test
    public void shouldThrowExceptionIfYouRunApplicationWithWithNegativeSpeedArgument() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {generateString(), String.valueOf(randomNegativeInteger())};

        // when
        TimeToReadApplication.main(args);
    }

    @Test
    public void shouldThrowExceptionWhenTextIsNull() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        TimeToReadApplication.main(args);

    }

    @Test
    public void shouldThrowExceptionWhenTextIsEmpty() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        TimeToReadApplication.main(args);
    }

    @Test
    public void shouldThrowExceptionWhenSpeedIsNotAValidNumber() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        TimeToReadApplication.main(args);

    }

    @Test
    public void getReadSpeedShouldThrowIllegalArgumentException() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        final String text = generateString();
        final String invalidSpeed = generateString();
        validateInputArgs(new String[]{text, invalidSpeed});

    }
}
