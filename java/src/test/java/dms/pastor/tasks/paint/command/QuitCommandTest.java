package dms.pastor.tasks.paint.command;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.paint.canvas.Canvas.noCanvas;
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
public class QuitCommandTest extends AbstractCommandTest {

    private static final String QUIT_COMMAND_SYNTAX = "Q";
    private final Command quitCommand = new QuitCommand();

    @Test
    public void getSyntaxShouldSyntaxForQuitCommand() {
        // when
        final String syntax = quitCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(QUIT_COMMAND_SYNTAX);
    }

    @Test
    public void isParamsRequiredShouldReturnFalse() {
        // when
        final boolean result = quitCommand.isParamsRequired();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void setParamsIfValidShouldInvalidCommandSyntaxExceptionIfParamsAreInvalid() {
        // given
        final String[] params = {QUIT_COMMAND_SYNTAX, "?", "1"};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> quitCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because number of params are invalid. Should be 1 but was 3. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldValidate() {
        // given
        final String[] params = {QUIT_COMMAND_SYNTAX};

        // when
        quitCommand.setParamsIfValid(params);

        // then nothing happen when params are valid
    }

    @Test
    public void executeShouldThrowExceptionForQuitCommand() {
        // when
        final var exception = assertThrows(SomethingWentWrongException.class, () -> quitCommand.execute(noCanvas()));

        // then
        assertThat(exception.getMessage()).isEqualTo(("Whoops! Something went wrong. Bug detected. execute method in quit command should not be called.. I apologize for any inconvenience caused by your mistake."));
    }

}
