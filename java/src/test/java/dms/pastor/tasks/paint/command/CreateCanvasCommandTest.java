package dms.pastor.tasks.paint.command;

import org.junit.Test;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

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
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number of params are invalid. Should be 3 but was 1. Please check your input and try again.");

        // given
        String[] params = {CREATE_CANVAS_COMMAND};

        // when
        createCanvasCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfWidthIsEmpty() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because width is not a number. Please check your input and try again.");

        // given
        String[] params = {CREATE_CANVAS_COMMAND, EMPTY_STRING, VALID_LENGTH};

        // when
        createCanvasCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfHeightIsEmpty() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because height is not a number. Please check your input and try again.");

        // given
        String[] params = {CREATE_CANVAS_COMMAND, VALID_LENGTH, EMPTY_STRING};

        // when
        createCanvasCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfWidthIsNotNumber() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because width is not a number. Please check your input and try again.");

        // given
        String[] params = {CREATE_CANVAS_COMMAND, NOT_A_NUMBER, VALID_LENGTH};

        // when
        createCanvasCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfHeightIsNotNumber() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because height is not a number. Please check your input and try again.");

        // given
        String[] params = {CREATE_CANVAS_COMMAND, VALID_LENGTH, NOT_A_NUMBER};

        // when
        createCanvasCommand.setParamsIfValid(params);
    }
}
