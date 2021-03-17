package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Point;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 30/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RedoCommandTest extends AbstractCommandTest {
    private static final String REDO_COMMAND = "R";
    private final Command redoCommand = new RedoCommand();

    @Test
    public void getSyntaxShouldSyntaxForRedoCommand() {
        // when
        final String syntax = redoCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(REDO_COMMAND);
    }

    @Test
    public void isParamsRequiredShouldReturnFalse() {
        // when
        final boolean result = redoCommand.isParamsRequired();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void setParamsIfValidShouldInvalidCommandSyntaxExceptionIfParamsAreInvalid() {
        // given
        final String[] params = {REDO_COMMAND, "?", "1"};
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> redoCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because number of params are invalid. Should be 1 but was 3. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldValidate() {
        // given
        final String[] params = {REDO_COMMAND};
        // when
        redoCommand.setParamsIfValid(params);

        // then nothing happen when params are valid
    }

    @Test
    public void executeShouldRedoLastChange() {
        // given
        final Canvas canvas = createCanvasFor(8, 6);
        canvas.saveState();

        canvas.updatePixelAt(Point.of(1, 2, "x"));

        canvas.undo();

        final Canvas expectedCanvasAfterUndo = createCanvasFor(8, 6);
        assertThat(canvas.getCanvasAsString()).isEqualTo(expectedCanvasAfterUndo.getCanvasAsString());

        final Canvas expectedCanvasAfterRedo = createCanvasFor(8, 6);
        expectedCanvasAfterRedo.updatePixelAt(Point.of(1, 2, "x"));
        // when
        redoCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(expectedCanvasAfterRedo.getCanvasAsString());
    }

}
