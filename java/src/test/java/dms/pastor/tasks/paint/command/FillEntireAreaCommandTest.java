package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import org.junit.Test;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static dms.pastor.tasks.paint.canvas.Canvas.noCanvas;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
 * I supress 2 warnings because:
 * off as test contains lots text as graphic elements
 * test tests algorithm that in many edge cases that uses similar condition
 */
@SuppressWarnings({"Duplicates", "SpellCheckingInspection"})
public class FillEntireAreaCommandTest extends AbstractCommandTest {
    private static final String FILL_ENTIRE_AREA_COMMAND = "B";
    private static final String FILL_CHARACTER = "o";
    private static final String EXISTING_POINT = "x";
    private static final int SQUARE_WITH_LENGTH_3 = 3;
    private static final int SQUARE_WITH_LENGTH_5 = 5;
    private static final String SQUARE_WITH_LENGTH_1_AS_STRING = "1";
    private static final String SQUARE_WITH_LENGTH_3_AS_STRING = "3";

    private static final String EXPECTED_SQUARE_FILLED_WITH_O = "-----" + System.lineSeparator()
            + "|ooo|" + System.lineSeparator()
            + "|ooo|" + System.lineSeparator()
            + "|ooo|" + System.lineSeparator()
            + "-----" + System.lineSeparator();

    private final Command fillEntireAreaCommand = new FillEntireAreaCommand();

    @Test
    public void getSyntaxShouldReturnCreateNewLine() {
        // when
        final String syntax = fillEntireAreaCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(FILL_ENTIRE_AREA_COMMAND);
    }

    @Test
    public void isParamsRequiredReturnForCreateRectangle() {
        // when
        final boolean result = fillEntireAreaCommand.isParamsRequired();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void executeShouldDrawSquareOfSizeOne() {
        // given
        final Canvas canvas = createCanvasFor(1, 1);
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_1_AS_STRING, SQUARE_WITH_LENGTH_1_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo("---" + System.lineSeparator() +
                "|o|" + System.lineSeparator() +
                "---" + System.lineSeparator());
    }

    @Test
    public void executeShouldDrawSquareOfSize3StartingFromCentre() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_3, SQUARE_WITH_LENGTH_3);
        final String length = "2";
        final String[] params = {fillEntireAreaCommand.getSyntax(), length, length, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(EXPECTED_SQUARE_FILLED_WITH_O);
    }

    @Test
    public void executeShouldDrawSquareOfSize3StartingFromTopLeftCorner() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_3, SQUARE_WITH_LENGTH_3);
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_1_AS_STRING, SQUARE_WITH_LENGTH_1_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(EXPECTED_SQUARE_FILLED_WITH_O);
    }

    @Test
    public void executeShouldDrawSquareOfSize3StartingFromTopRightCorner() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_3, SQUARE_WITH_LENGTH_3);
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_1_AS_STRING, SQUARE_WITH_LENGTH_3_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(EXPECTED_SQUARE_FILLED_WITH_O);
    }

    @Test
    public void executeShouldDrawSquareOfSize3StartingFromBottomLeftCorner() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_3, SQUARE_WITH_LENGTH_3);
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_3_AS_STRING, SQUARE_WITH_LENGTH_1_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(EXPECTED_SQUARE_FILLED_WITH_O);
    }

    @Test
    public void executeShouldDrawSquareOfSize3StartingFromBottomRightCorner() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_3, SQUARE_WITH_LENGTH_3);
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_3_AS_STRING, SQUARE_WITH_LENGTH_3_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(EXPECTED_SQUARE_FILLED_WITH_O);
    }

    @Test
    public void executeShouldFeelAreaInsideSquare() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_5, SQUARE_WITH_LENGTH_5);
        String[][] image = canvas.getImage();
        image[2][2] = EXISTING_POINT;
        image[3][2] = EXISTING_POINT;
        image[4][2] = EXISTING_POINT;
        image[2][3] = EXISTING_POINT;
        image[4][3] = EXISTING_POINT;
        image[2][4] = EXISTING_POINT;
        image[3][4] = EXISTING_POINT;
        image[4][4] = EXISTING_POINT;
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_3_AS_STRING, SQUARE_WITH_LENGTH_3_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo("-------" + System.lineSeparator()
                + "|     |" + System.lineSeparator()
                + "| xxx |" + System.lineSeparator()
                + "| xox |" + System.lineSeparator()
                + "| xxx |" + System.lineSeparator()
                + "|     |" + System.lineSeparator()
                + "-------" + System.lineSeparator());
    }

    @Test
    public void executeShouldFillAreaOutsideSquare() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_5, SQUARE_WITH_LENGTH_5);
        String[][] image = canvas.getImage();
        image[2][2] = EXISTING_POINT;
        image[3][2] = EXISTING_POINT;
        image[4][2] = EXISTING_POINT;
        image[2][3] = EXISTING_POINT;
        image[4][3] = EXISTING_POINT;
        image[2][4] = EXISTING_POINT;
        image[3][4] = EXISTING_POINT;
        image[4][4] = EXISTING_POINT;
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_1_AS_STRING, SQUARE_WITH_LENGTH_1_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo("-------" + System.lineSeparator()
                + "|ooooo|" + System.lineSeparator()
                + "|oxxxo|" + System.lineSeparator()
                + "|ox xo|" + System.lineSeparator()
                + "|oxxxo|" + System.lineSeparator()
                + "|ooooo|" + System.lineSeparator()
                + "-------" + System.lineSeparator());
    }

    @Test
    public void executeShouldFillAllSpacesExceptBottomLeftCorner() {
        // given
        final Canvas canvas = createCanvasFor(SQUARE_WITH_LENGTH_5, SQUARE_WITH_LENGTH_5);
        String[][] image = canvas.getImage();
        image[2][2] = EXISTING_POINT;
        image[3][2] = EXISTING_POINT;
        image[4][2] = EXISTING_POINT;
        image[4][3] = EXISTING_POINT;
        image[4][4] = EXISTING_POINT;
        image[3][4] = EXISTING_POINT;
        image[2][4] = EXISTING_POINT;
        image[1][4] = EXISTING_POINT;
        image[2][5] = EXISTING_POINT;
        final String[] params = {fillEntireAreaCommand.getSyntax(), SQUARE_WITH_LENGTH_1_AS_STRING, SQUARE_WITH_LENGTH_1_AS_STRING, FILL_CHARACTER};
        fillEntireAreaCommand.setParamsIfValid(params);

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo("-------" + System.lineSeparator()
                + "|ooooo|" + System.lineSeparator()
                + "|oxxxo|" + System.lineSeparator()
                + "|oooxo|" + System.lineSeparator()
                + "|xxxxo|" + System.lineSeparator()
                + "| xooo|" + System.lineSeparator()
                + "-------" + System.lineSeparator());
    }

    @Test
    public void executeShouldDontFillAnythingIfNoCanvas() {
        // given
        final Canvas canvas = noCanvas();

        // when
        fillEntireAreaCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(noCanvas().getCanvasAsString());

    }


}
