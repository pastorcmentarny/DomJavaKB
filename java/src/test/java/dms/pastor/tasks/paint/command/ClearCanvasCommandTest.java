package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void getSyntaxShouldSyntaxForQuitCommand() {
        // when
        final String syntax = clearCanvasCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(CLEAR_COMMAND_SYNTAX);
    }

    @Test
    public void isParamsRequiredShouldReturnFalse() {
        // when
        final boolean result = clearCanvasCommand.isParamsRequired();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void setParamsIfValidShouldInvalidCommandSyntaxExceptionIfParamsAreInvalid() {
        // given
        final String[] params = {CLEAR_COMMAND_SYNTAX, "?", "1"};
        // when
        final var exception = Assertions.assertThrows(InvalidCommandSyntaxException.class, () -> clearCanvasCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because number of params are invalid. Should be 1 but was 3. Please check your input and try again.");

    }

    @Test
    public void setParamsIfValidShouldValidate() {
        // given
        final String[] params = {CLEAR_COMMAND_SYNTAX};
        // when
        clearCanvasCommand.setParamsIfValid(params);

        // then nothing happen when params are valid
    }

    @Test
    public void executeShouldReturnClearCanvas() {
        // given
        final int width = 8;
        final int height = 6;
        final Canvas canvas = createCanvasFor(width, height);
        canvas.updatePixelAt(Point.of(1, 1, "d"));
        canvas.updatePixelAt(Point.of(2, 2, "o"));
        canvas.updatePixelAt(Point.of(3, 3, "m"));

        Canvas expectedCanvas = createCanvasFor(width, height);
        // when
        clearCanvasCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(expectedCanvas.getCanvasAsString());
    }

}