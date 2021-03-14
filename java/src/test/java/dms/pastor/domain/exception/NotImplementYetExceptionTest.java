package dms.pastor.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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


    @Test
    public void shouldThrowNotImplementYetExceptionTest() {
        // when
        final var exception = Assertions.assertThrows(NotImplementYetException.class, () -> {
            throw new NotImplementYetException();
        });

        // then
        assertThat(exception.getMessage()).isEqualTo(EXCEPTION_MESSAGE);


    }

    @SuppressWarnings({"resource", "IOResourceOpenedButNotSafelyClosed"})
    @Test
    public void shouldThrowIOExceptionWhenTryingReadObjectTest() {
        // given
        NotImplementYetException notImplementYetException = new NotImplementYetException();
        // when
        final boolean result = isObjectCanBeSerialized(notImplementYetException);

        // then
        assertThat(result).isFalse();

        // then verify
        Assertions.assertThrows(IOException.class, () -> {
            OutputStream sink = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(sink);
            stream.writeObject(notImplementYetException);

        });

    }

}
