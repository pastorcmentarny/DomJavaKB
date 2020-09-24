package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import org.junit.Test;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 16/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CreateNewLineCommandTest extends AbstractCommandTest {

    private static final String CREATE_LINE_COMMAND = "L";
    private static final String NOT_A_NUMBER = "Number";
    private static final String VALID_VALUE_AS_STRING = "3";
    private static final String NOT_USED_SMALL_VALUE_AS_STRING = "1";
    private static final String NOT_USED_LARGE_VALUE_AS_STRING = "4";

    private final CreateNewLineCommand createNewLineCommand = new CreateNewLineCommand();

    @Test
    public void getSyntaxShouldReturnCreateNewLine() {
        // when
        final String syntax = createNewLineCommand.getSyntax();

        // then
        assertThat(syntax).isEqualTo(CREATE_LINE_COMMAND);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfStartWidthIsEmpty() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because start width is not a number. Please check your input and try again.");

        // given
        String[] params = {CREATE_LINE_COMMAND, EMPTY_STRING, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfStartWidthIsNotANumber() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because start width is not a number. Please check your input and try again.");

        // given

        String[] params = {CREATE_LINE_COMMAND, NOT_A_NUMBER, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfStartHeightIsEmpty() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because start height is not a number. Please check your input and try again.");

        // given

        String[] params = {CREATE_LINE_COMMAND, VALID_VALUE_AS_STRING, EMPTY_STRING, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfStartHeightIsNotANumber() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because start height is not a number. Please check your input and try again.");

        // given

        String[] params = {CREATE_LINE_COMMAND, VALID_VALUE_AS_STRING, NOT_A_NUMBER, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfEndWidthIsEmpty() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because end width is not a number. Please check your input and try again.");

        // given

        String[] params = {CREATE_LINE_COMMAND, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, EMPTY_STRING, VALID_VALUE_AS_STRING};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfEndWidthIsNotANumber() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because end width is not a number. Please check your input and try again.");

        // given

        String[] params = {CREATE_LINE_COMMAND, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, NOT_A_NUMBER, VALID_VALUE_AS_STRING};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfEndHeightIsEmpty() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because end height is not a number. Please check your input and try again.");

        // given

        String[] params = {CREATE_LINE_COMMAND, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, EMPTY_STRING};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfEndHeightIsNotANumber() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because end height is not a number. Please check your input and try again.");

        // given

        String[] params = {CREATE_LINE_COMMAND, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, VALID_VALUE_AS_STRING, NOT_A_NUMBER};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfParamsCreateRectangle() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because Unable to create line with this params. Please check your input and try again.");

        // given
        String[] params = {CREATE_LINE_COMMAND, "2", "3", "2", "3"};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfParamsCreateNonHorizontalOrVerticalLine() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because Unable to create line with this params. Please check your input and try again.");

        // given
        String[] params = {CREATE_LINE_COMMAND, "1", "2", "3", "4"};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void getStartWidthShouldReturnValue() {
        // given
        String[] params = {CREATE_LINE_COMMAND, VALID_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING, NOT_USED_LARGE_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING};
        createNewLineCommand.setParamsIfValid(params);

        // when
        final int result = createNewLineCommand.getStartWidth();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getStartHeightShouldReturnValue() {
        // given
        String[] params = {CREATE_LINE_COMMAND, NOT_USED_SMALL_VALUE_AS_STRING, VALID_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING, NOT_USED_LARGE_VALUE_AS_STRING};
        createNewLineCommand.setParamsIfValid(params);

        // when
        final int result = createNewLineCommand.getStartHeight();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getEndWidthShouldReturnValue() {
        // given
        String[] params = {CREATE_LINE_COMMAND, NOT_USED_SMALL_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING, VALID_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING};
        createNewLineCommand.setParamsIfValid(params);

        // when
        final int result = createNewLineCommand.getEndWidth();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getEndHeightShouldReturnValue() {
        // given
        String[] params = {CREATE_LINE_COMMAND, NOT_USED_SMALL_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING, NOT_USED_SMALL_VALUE_AS_STRING, VALID_VALUE_AS_STRING,};
        createNewLineCommand.setParamsIfValid(params);

        // when
        final int result = createNewLineCommand.getEndHeight();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfParamsCreateSquare() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because Unable to create line with this params. Please check your input and try again.");

        // given
        String[] params = {CREATE_LINE_COMMAND, "3", "3", "3", "3"};

        // when
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void setParamsIfValidShouldValidateIfAllParamsAreValid() {
        // given
        String[] params = {CREATE_LINE_COMMAND, "1", "1", "3", "1"};

        // when
        createNewLineCommand.setParamsIfValid(params);

        // then
        assertThat(createNewLineCommand.getStartWidth()).isEqualTo(1);
        assertThat(createNewLineCommand.getStartHeight()).isEqualTo(1);
        assertThat(createNewLineCommand.getEndWidth()).isEqualTo(3);
        assertThat(createNewLineCommand.getEndHeight()).isEqualTo(1);
    }

    @Test
    public void validateIfParamsAreInOrderShouldThrowExceptionIfHeightStartPointIsHigherThanEndPoint() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because Start point must be smaller than end point. Please check your input and try again.");

        // when
        final String[] params = {createNewLineCommand.getSyntax(), "3", "4", "3", "1"};
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void validateIfParamsAreInOrderShouldThrowExceptionIfLengthStartPointIsHigherThanEndPoint() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because Start point must be smaller than end point. Please check your input and try again.");

        // when
        final String[] params = {createNewLineCommand.getSyntax(), "4", "3", "1", "3"};
        createNewLineCommand.setParamsIfValid(params);
    }

    @Test
    public void isParamsRequiredShouldReturnTrue() {
        // when
        final boolean result = createNewLineCommand.isParamsRequired();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void setParamsIfValidShouldThrowExceptionIfParamsCountIsWrong() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number of params are invalid. Should be 5 but was 1. Please check your input and try again.");

        // given
        String[] params = {CREATE_LINE_COMMAND};

        // when
        createNewLineCommand.setParamsIfValid(params);

    }

    @Test
    public void executeShouldDrawHorizontalLineOnCanvas() {
        // given
        final Canvas canvas = Canvas.createCanvasFor(4, 4);
        createNewLineCommand.setParam(new String[]{CREATE_LINE_COMMAND, "1", "1", "3", "1"});
        final String result = "------" + lineSeparator() +
                "|xxx |" + lineSeparator() +
                "|    |" + lineSeparator() +
                "|    |" + lineSeparator() +
                "|    |" + lineSeparator() +
                "------" + lineSeparator();

        // when
        createNewLineCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(result);
    }

    @Test
    public void executeShouldDrawVerticalLineOnCanvas() {
        // given
        final Canvas canvas = Canvas.createCanvasFor(4, 4);
        createNewLineCommand.setParam(new String[]{CREATE_LINE_COMMAND, "2", "1", "2", "3"});
        final String result = "------" + lineSeparator() +
                "| x  |" + lineSeparator() +
                "| x  |" + lineSeparator() +
                "| x  |" + lineSeparator() +
                "|    |" + lineSeparator() +
                "------" + lineSeparator();

        // when
        createNewLineCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(result);
    }

    @Test
    public void executeShouldNotDrawAnythingIfCanvasIsNotCreated() {
        // given
        final Canvas canvas = Canvas.noCanvas();

        // when
        createNewLineCommand.execute(canvas);

        // then
        assertThat(canvas.getCanvasAsString()).isEmpty();

    }

    @Test
    public void executeShouldThrowExceptionIfLineWillBeDrawnOnTopBorder() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because paint on border is not allowed. Please check your input and try again.");

        // given
        final Canvas canvas = Canvas.createCanvasFor(4, 4);
        createNewLineCommand.setParam(new String[]{CREATE_LINE_COMMAND, "0", "0", "3", "0"});

        // when
        createNewLineCommand.execute(canvas);
    }

    @Test
    public void executeShouldThrowExceptionIfLineWillBeDrawnOnBottomBorder() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because paint on border is not allowed. Please check your input and try again.");

        // given
        final Canvas canvas = Canvas.createCanvasFor(4, 4);
        createNewLineCommand.setParam(new String[]{CREATE_LINE_COMMAND, "0", "0", "0", "3"});

        // when
        createNewLineCommand.execute(canvas);
    }

    @Test
    public void executeShouldThrowExceptionIfLineWillBeDrawnOnLeftBorder() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because paint on border is not allowed. Please check your input and try again.");

        // given
        final Canvas canvas = Canvas.createCanvasFor(4, 4);
        createNewLineCommand.setParam(new String[]{CREATE_LINE_COMMAND, "3", "0", "3", "3"});

        // when
        createNewLineCommand.execute(canvas);
    }

    @Test
    public void executeShouldThrowExceptionIfLineWillBeDrawnOnRightBorder() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because paint on border is not allowed. Please check your input and try again.");

        // given
        final Canvas canvas = Canvas.createCanvasFor(4, 4);
        createNewLineCommand.setParam(new String[]{CREATE_LINE_COMMAND, "0", "3", "3", "3"});

        // when
        createNewLineCommand.execute(canvas);
    }

}
