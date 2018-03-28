package dms.pastor.tasks.paint.command;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InvalidCommandSyntaxExceptionTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnInvalidCommandSyntaxExceptionWithMessage() {
        // given
        final String reason = "test";

        // except
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because " + reason + ". Please check your input and try again.");

        // when
        throw new InvalidCommandSyntaxException(reason);
    }
}