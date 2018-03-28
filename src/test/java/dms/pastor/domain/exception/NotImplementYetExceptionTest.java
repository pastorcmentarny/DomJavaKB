package dms.pastor.domain.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import static dms.pastor.utils.ValidatorUtils.isObjectCanBeSerialized;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NotImplementYetExceptionTest {

    private static final String EXCEPTION_MESSAGE = "Not Implemented yet, so move your ass and implement this. I apologize for any inconvenience caused by my laziness";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowNotImplementYetExceptionTest() {

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
        final boolean result = isObjectCanBeSerialized(notImplementYetException);

        // then
        assertThat(result).isFalse();

        // then verify
        OutputStream sink = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(sink);
        stream.writeObject(notImplementYetException);
    }

}
