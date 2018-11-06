package dms.pastor.domain.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 24/02/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SomethingWentWrongExceptionTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowNotImplementYetExceptionTest() {

        // expect
        exception.expect(SomethingWentWrongException.class);

        // when
        throw new SomethingWentWrongException();

    }

    @Test
    public void shouldThrowNotImplementYetExceptionWithMessageTest() {

        // given
        final String whatWentWrongMessage = generateString();

        // expect
        exception.expect(SomethingWentWrongException.class);
        exception.expectMessage(format("Whoops! Something went wrong. %s. I apologize for any inconvenience caused by your mistake.", whatWentWrongMessage));

        // when
        throw new SomethingWentWrongException(whatWentWrongMessage);

    }
}
