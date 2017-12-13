package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Point;
import org.junit.Test;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static org.assertj.core.api.Assertions.assertThat;

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
    public void getSyntaxShouldSyntaxForRedoCommand() throws Exception {
        // when
        final String syntax = redoCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(REDO_COMMAND);
    }

    @Test
    public void isParamsRequiredShouldReturnFalse() throws Exception {
        // when
        final boolean result = redoCommand.isParamsRequired();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void setParamsIfValidShouldInvalidCommandSyntaxExceptionIfParamsAreInvalid() throws Exception {
        // given
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number of params are invalid. Should be 1 but was 3. Please check your input and try again.");
        final String[] params = {REDO_COMMAND, "?", "1"};

        // when
        redoCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldValidate() throws Exception {
        // given
        final String[] params = {REDO_COMMAND};

        // when
        redoCommand.setParamsIfValid(params);

        // then nothing happen when params are valid
    }

    @Test
    public void executeShouldRedoLastChange() throws Exception {
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
