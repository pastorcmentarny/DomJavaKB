package dms.pastor.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 24/02/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SomethingWentWrongExceptionTest {


    @Test // best test award
    public void shouldThrowSomethingWentWrongExceptionTest() {

        // expect
        Assertions.assertThrows(SomethingWentWrongException.class, () -> {
            throw new SomethingWentWrongException();
        });

    }

    @Test
    public void shouldThrowNotImplementYetExceptionWithMessageTest() {

        // given
        final String whatWentWrongMessage = generateString();
        final String expectedMessage = format("Whoops! Something went wrong. %s. I apologize for any inconvenience caused by your mistake.", whatWentWrongMessage);

        // expect
        final var exception = Assertions.assertThrows(SomethingWentWrongException.class, () -> {
            // when
            throw new SomethingWentWrongException(whatWentWrongMessage);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);


    }
}
