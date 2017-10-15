package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import org.junit.Test;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 07/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ClearCanvasCommandTest extends AbstractCommandTest {

    private static final String CLEAR_COMMAND_SYNTAX = "C";
    private final Command clearCanvasCommand = new ClearCanvasCommand();

    @Test
    public void getSyntaxShouldSyntaxForQuitCommand() throws Exception {
        // when
        final String syntax = clearCanvasCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(CLEAR_COMMAND_SYNTAX);
    }

    @Test
    public void isParamsRequiredShouldReturnFalse() throws Exception {
        // when
        final boolean result = clearCanvasCommand.isParamsRequired();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void setParamsIfValidShouldInvalidCommandSyntaxExceptionIfParamsAreInvalid() throws Exception {
        // given
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number of params are invalid. Should be 1 but was 3. Please check your input and try again.");
        final String[] params = {CLEAR_COMMAND_SYNTAX, "?", "1"};

        // when
        clearCanvasCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldValidate() throws Exception {
        // given
        final String[] params = {CLEAR_COMMAND_SYNTAX};

        // when
        clearCanvasCommand.setParamsIfValid(params);

        // then nothing happen when params are valid
    }

    @Test
    public void executeShouldReturnClearCanvas() throws Exception {
        // given
        final int width = 8;
        final int height = 6;
        final Canvas canvas = createCanvasFor(width, height);
        canvas.updatePixelAt(1, 1, "d");
        canvas.updatePixelAt(2, 2, "o");
        canvas.updatePixelAt(3, 3, "m");

        Canvas expectedCanvas = createCanvasFor(width, height);

        // when
        clearCanvasCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(expectedCanvas.getCanvasAsString());
    }

}