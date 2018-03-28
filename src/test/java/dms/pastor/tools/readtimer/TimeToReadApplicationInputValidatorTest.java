package dms.pastor.tools.readtimer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tools.readtimer.TimeToReadApplicationInputValidator.validateInputArgs;
import static dms.pastor.utils.randoms.RandomDataGenerator.*;

/**
 * Author Dominik Symonowicz
 * Created 26/12/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class TimeToReadApplicationInputValidatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfYouRunApplicationWith1Argument() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {generateString()};

        // when
        TimeToReadApplication.main(args);

    }

    @Test
    public void shouldThrowExceptionIfYouRunApplicationWithWithNegativeSpeedArgument() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {generateString(), String.valueOf(randomNegativeInteger())};

        // when
        TimeToReadApplication.main(args);
    }

    @Test
    public void shouldThrowExceptionWhenTextIsNull() {
        // except
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        TimeToReadApplication.main(args);

    }

    @Test
    public void shouldThrowExceptionWhenTextIsEmpty() {
        // except
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        TimeToReadApplication.main(args);
    }

    @Test
    public void shouldThrowExceptionWhenSpeedIsNotAValidNumber() {
        // except
        exception.expect(IllegalArgumentException.class);

        // given
        final String[] args = {null, String.valueOf(randomInteger())};

        // when
        TimeToReadApplication.main(args);

    }

    @Test
    public void getReadSpeedShouldThrowIllegalArgumentException() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        final String text = generateString();
        final String invalidSpeed = generateString();
        validateInputArgs(new String[]{text, invalidSpeed});

    }
}
