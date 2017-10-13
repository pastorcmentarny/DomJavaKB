package dms.pastor.tasks.paint.command;

import org.junit.Test;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InvalidCommandSyntaxExceptionTest extends AbstractCommandTest {

    @Test
    public void shouldReturnInvalidCommandSyntaxExceptionWithMessage() throws Exception {
        // given
        final String reason = "test";

        // except
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because " + reason + ". Please check your input and try again.");

        // when
        throw new InvalidCommandSyntaxException(reason);
    }
}