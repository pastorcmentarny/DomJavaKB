package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import org.junit.Test;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 17/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class UndoCommandTest extends AbstractCommandTest {
    private static final String UNDO_COMMAND = "U";
    private final UndoCommand undoCommand = new UndoCommand();

    @Test
    public void getSyntaxShouldSyntaxForUndoCommand() throws Exception {
        // when
        final String syntax = undoCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(UNDO_COMMAND);
    }

    @Test
    public void isParamsRequiredShouldReturnFalse() throws Exception {
        // when
        final boolean result = undoCommand.isParamsRequired();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void setParamsIfValidShouldInvalidCommandSyntaxExceptionIfParamsAreInvalid() throws Exception {
        // given
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number of params are invalid. Should be 1 but was 3. Please check your input and try again.");
        final String[] params = {UNDO_COMMAND, "?", "1"};

        // when
        undoCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldValidate() throws Exception {
        // given
        final String[] params = {UNDO_COMMAND};

        // when
        undoCommand.setParamsIfValid(params);

        // then nothing happen when params are valid
    }

    @Test
    public void executeShouldUndoLastChange() throws Exception {
        // given
        final Canvas canvas = createCanvasFor(8, 6);
        canvas.saveState();
        canvas.updatePixelAt(1, 2, "x");

        canvas.saveState();
        canvas.updatePixelAt(1, 2, "d");

        final Canvas expectedCanvas = createCanvasFor(8, 6);
        expectedCanvas.updatePixelAt(1, 2, "x");

        // when
        undoCommand.execute(canvas);
        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(expectedCanvas.getCanvasAsString());
    }

}
