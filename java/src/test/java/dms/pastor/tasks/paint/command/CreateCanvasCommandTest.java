package dms.pastor.tasks.paint.command;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
//testing various edge cases
public class CreateCanvasCommandTest extends AbstractCommandTest {

    private static final String NOT_A_NUMBER = "THREE";
    private static final String CREATE_CANVAS_COMMAND = "C";
    private static final String VALID_LENGTH = "3";

    // given
    private final Command createCanvasCommand = new CreateCanvasCommand();


    @Test
    public void getSyntaxShouldSyntaxForCreateCanvasCommand() {
        // when
        final String syntax = createCanvasCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(CREATE_CANVAS_COMMAND);
    }

    @Test
    public void isParamsRequiredShouldReturnTrue() {
        // when
        final boolean result = createCanvasCommand.isParamsRequired();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfParamsCountIsWrong() {
        // given
        String[] params = {CREATE_CANVAS_COMMAND};
        // when
        assertThrows(InvalidCommandSyntaxException.class, () -> createCanvasCommand.setParamsIfValid(params));
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfWidthIsEmpty() {
        // given
        String[] params = {CREATE_CANVAS_COMMAND, EMPTY_STRING, VALID_LENGTH};
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createCanvasCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because width is not a number. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfHeightIsEmpty() {
        // given
        String[] params = {CREATE_CANVAS_COMMAND, VALID_LENGTH, EMPTY_STRING};
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createCanvasCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because height is not a number. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfWidthIsNotNumber() {
        // given
        String[] params = {CREATE_CANVAS_COMMAND, NOT_A_NUMBER, VALID_LENGTH};
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createCanvasCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because width is not a number. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfHeightIsNotNumber() {
        // given
        String[] params = {CREATE_CANVAS_COMMAND, VALID_LENGTH, NOT_A_NUMBER};
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createCanvasCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because height is not a number. Please check your input and try again.");
    }
}
