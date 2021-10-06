package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 16/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CreateNewRectangleCommandTest extends AbstractCommandTest {

    private static final String CREATE_RECTANGLE_COMMAND = "R";
    private static final String NOT_A_NUMBER = "Trzy";
    private static final String START_NUMBER = "1";
    private static final String END_NUMBER = "3";
    private static final String VALID_VALUE_AS_STRING = "3";
    private static final String NOT_USED_SMALL_VALUE_AS_STRING = "1";
    private static final String NOT_USED_MEDIUM_VALUE_AS_STRING = "2";
    private static final String NOT_USED_LARGE_VALUE_AS_STRING = "4";
    private static final int SQUARE_WITH_LENGTH_4 = 4;

    private final CreateNewRectangleCommand createNewRectangleCommand = new CreateNewRectangleCommand();

    @Test
    public void getStartWidthShouldReturnValue() {
        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, VALID_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING, NOT_USED_LARGE_VALUE_AS_STRING, NOT_USED_MEDIUM_VALUE_AS_STRING};
        createNewRectangleCommand.setParamsIfValid(params);

        // when
        final int result = createNewRectangleCommand.getStartWidth();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getStartHeightShouldReturnValue() {
        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, NOT_USED_SMALL_VALUE_AS_STRING, VALID_VALUE_AS_STRING, NOT_USED_MEDIUM_VALUE_AS_STRING, NOT_USED_LARGE_VALUE_AS_STRING};
        createNewRectangleCommand.setParamsIfValid(params);

        // when
        final int result = createNewRectangleCommand.getStartHeight();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getEndWidthShouldReturnValue() {
        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, NOT_USED_SMALL_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING, VALID_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING};
        createNewRectangleCommand.setParamsIfValid(params);

        // when
        final int result = createNewRectangleCommand.getEndWidth();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void setParamsIfValidAreInOrderShouldThrowExceptionIfHeightStartPointIsHigherThanEndPoint() {
        // given
        final String[] params = {createNewRectangleCommand.getSyntax(), NOT_USED_MEDIUM_VALUE_AS_STRING, "4", "3", "1"};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because Start point must be smaller than end point. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidAreInOrderShouldThrowExceptionIfLengthStartPointIsHigherThanEndPoint() {
        // given
        final String[] params = {createNewRectangleCommand.getSyntax(), "4", NOT_USED_MEDIUM_VALUE_AS_STRING, "1", "3"};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because Start point must be smaller than end point. Please check your input and try again.");

    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfStartPointIsOnBorder() {
        // given
        Canvas canvas = Canvas.createCanvasFor(SQUARE_WITH_LENGTH_4, SQUARE_WITH_LENGTH_4);
        final String startPoint = "0";
        final String endPoint = "3";
        final String[] params = {createNewRectangleCommand.getSyntax(), startPoint, startPoint, endPoint, endPoint};
        createNewRectangleCommand.setParamsIfValid(params);

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.execute(canvas));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because paint on border is not allowed. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfEndPointIsOnBorder() {
        // given
        Canvas canvas = Canvas.createCanvasFor(SQUARE_WITH_LENGTH_4, SQUARE_WITH_LENGTH_4);
        final String startPoint = "2";
        final String endPoint = "5";
        final String[] params = {createNewRectangleCommand.getSyntax(), startPoint, startPoint, endPoint, endPoint};
        createNewRectangleCommand.setParamsIfValid(params);

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.execute(canvas));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because paint on border is not allowed. Please check your input and try again.");

    }

    @Test
    public void getSyntaxShouldReturnCreateNewLine() {
        // when
        final String syntax = createNewRectangleCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(CREATE_RECTANGLE_COMMAND);
    }

    @Test
    public void isParamsRequiredReturnForCreateRectangle() {
        // when
        final boolean result = createNewRectangleCommand.isParamsRequired();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfParamsCountIsWrong() {
        // given
        String[] params = {CREATE_RECTANGLE_COMMAND};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because number of params are invalid. Should be 5 but was 1. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfStartWidthIsNotANumber() {
        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, NOT_A_NUMBER, START_NUMBER, END_NUMBER, END_NUMBER};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because start width is not a number. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfStartHeightIsNotANumber() {

        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, START_NUMBER, NOT_A_NUMBER, END_NUMBER, END_NUMBER};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because start height is not a number. Please check your input and try again.");

    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfEndWidthIsNotANumber() {
        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, START_NUMBER, START_NUMBER, NOT_A_NUMBER, END_NUMBER};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because end width is not a number. Please check your input and try again.");

    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfEndHeightIsNotANumber() {

        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, START_NUMBER, START_NUMBER, END_NUMBER, NOT_A_NUMBER};

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> createNewRectangleCommand.setParamsIfValid(params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because end height is not a number. Please check your input and try again.");
    }

    @Test
    public void setParamsIfValidShouldValidateIfAllParamsAreValid() {
        // given
        String[] params = {CREATE_RECTANGLE_COMMAND, START_NUMBER, START_NUMBER, END_NUMBER, END_NUMBER};
        // when
        createNewRectangleCommand.setParamsIfValid(params);

        // then
        assertThat(createNewRectangleCommand.getStartWidth()).isEqualTo(1);
        assertThat(createNewRectangleCommand.getStartHeight()).isEqualTo(1);
        assertThat(createNewRectangleCommand.getEndWidth()).isEqualTo(3);
        assertThat(createNewRectangleCommand.getEndHeight()).isEqualTo(3);
    }


    @Test
    public void executeShouldDrawRectangleOnCanvas() {
        // given
        final Canvas canvas = Canvas.createCanvasFor(SQUARE_WITH_LENGTH_4, SQUARE_WITH_LENGTH_4);
        createNewRectangleCommand.setParam(new String[]{CREATE_RECTANGLE_COMMAND, NOT_USED_MEDIUM_VALUE_AS_STRING, START_NUMBER, "4", END_NUMBER});
        final String result = "------" + lineSeparator() +
                "| xxx|" + lineSeparator() +
                "| x x|" + lineSeparator() +
                "| xxx|" + lineSeparator() +
                "|    |" + lineSeparator() +
                "------" + lineSeparator();

        // when
        createNewRectangleCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(result);
    }

}
