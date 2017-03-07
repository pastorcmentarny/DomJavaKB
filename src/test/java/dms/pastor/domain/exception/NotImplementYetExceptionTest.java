package dms.pastor.domain.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import static dms.pastor.utils.ValidatorUtils.validateThatObjectCanBeSerialized;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class NotImplementYetExceptionTest {
    private static final String EXCEPTION_MESSAGE = "Not Implemented yet, so move your ass and implement this. I apologize for any inconvenience caused by my laziness";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowNotImplementYetExceptionTest() throws Exception {

        // expect
        exception.expect(NotImplementYetException.class);
        exception.expectMessage(EXCEPTION_MESSAGE);

        // when
        throw new NotImplementYetException();

    }

    @SuppressWarnings({"resource", "IOResourceOpenedButNotSafelyClosed"})
    @Test
    public void shouldThrowIOExceptionWhenTryingReadObjectTest() throws Exception {
        // expect
        exception.expect(IOException.class);
        exception.expectMessage("Cannot be deserialized");

        // given
        NotImplementYetException notImplementYetException = new NotImplementYetException();

        // when
        final boolean result = validateThatObjectCanBeSerialized(notImplementYetException);

        // then
        assertThat(result).isFalse();

        // then verify (//TODO check better ways to verify this
        OutputStream sink = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(sink);
        stream.writeObject(notImplementYetException);
    }

}
