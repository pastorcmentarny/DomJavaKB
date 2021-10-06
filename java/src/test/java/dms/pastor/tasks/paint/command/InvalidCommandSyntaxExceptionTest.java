package dms.pastor.tasks.paint.command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InvalidCommandSyntaxExceptionTest {


    @Test
    public void shouldReturnInvalidCommandSyntaxExceptionWithMessage() {
        // given
        final String reason = "test";

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> {
            throw new InvalidCommandSyntaxException(reason);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because " + reason + ". Please check your input and try again.");


    }
}