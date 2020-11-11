package dms.pastor.tasks.paint.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InvalidCommandSyntaxExceptionTest {


    @Test
    public void shouldReturnInvalidCommandSyntaxExceptionWithMessage() {
        // given
        final String reason = "test";
        // when
        final var exception = Assertions.assertThrows(InvalidCommandSyntaxException.class, () -> {
            throw new InvalidCommandSyntaxException(reason);
        });

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because " + reason + ". Please check your input and try again.");


    }
}