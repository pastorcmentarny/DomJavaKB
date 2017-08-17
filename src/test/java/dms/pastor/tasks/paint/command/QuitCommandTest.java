package dms.pastor.tasks.paint.command;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class QuitCommandTest extends AbstractCommandTest {

    private static final String QUIT_COMMAND_SYNTAX = "Q";
    private final Command quitCommand = new QuitCommand();

    @Test
    public void getSyntaxShouldSyntaxForQuitCommand() throws Exception {
        // when
        final String syntax = quitCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(QUIT_COMMAND_SYNTAX);
    }

    @Test
    public void isParamsRequiredShouldReturnFalse() throws Exception {
        // when
        final boolean result = quitCommand.isParamsRequired();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void setParamsIfValidShouldInvalidCommandSyntaxExceptionIfParamsAreInvalid() throws Exception {
        // given
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number of params are invalid. Should be 1 but was 3. Please check your input and try again.");
        final String[] params = {QUIT_COMMAND_SYNTAX, "?", "1"};

        // when
        quitCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldValidate() throws Exception {
        // given
        final String[] params = {QUIT_COMMAND_SYNTAX};

        // when
        quitCommand.setParamsIfValid(params);

        // then nothing happen when params are valid
    }

}
