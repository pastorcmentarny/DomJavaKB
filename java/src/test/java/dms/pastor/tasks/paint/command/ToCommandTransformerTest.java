package dms.pastor.tasks.paint.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.paint.command.ToCommandTransformer.toCommand;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ToCommandTransformerTest {


    @Test
    public void toCommandWithInputForQuitShouldReturnQuitCommand() {
        // given
        final String quitCommandInput = "Q";
        // when
        final Command quitCommand = toCommand(quitCommandInput);

        // then
        assertThat(quitCommand).isInstanceOf(QuitCommand.class);
    }

    @Test
    public void toCommandWithInputForCreateCanvasShouldReturnCreateCanvasCommand() {
        // given
        final String createCanvasCommandInput = "C 2 1";
        // when
        final Command quitCommand = toCommand(createCanvasCommandInput);

        // then
        assertThat(quitCommand).isInstanceOf(CreateCanvasCommand.class);
    }

    @Test
    public void toCommandWithInputForClearCanvasShouldReturnClearCanvasCommand() {
        // given
        final String clearCanvasCommandInput = "C";
        // when
        final Command clearCommand = toCommand(clearCanvasCommandInput);

        // then
        assertThat(clearCommand).isInstanceOf(ClearCanvasCommand.class);
    }

    @Test
    public void toCommandWithInputForCreateNewLineShouldReturnCreateNewLineCommand() {
        // given
        final String createNewLineCommandInput = "L 1 1 3 1";
        // when
        final Command createNewLineCommand = toCommand(createNewLineCommandInput);

        // then
        assertThat(createNewLineCommand).isInstanceOf(CreateNewLineCommand.class);
    }

    @Test
    public void toCommandWithInputForCreateNewRectangleShouldReturnCreateNewRectangleCommand() {
        // given
        final String createNewRectangleCommandInput = "R 2 2 3 3";
        // when
        final Command createNewRectangleCommand = toCommand(createNewRectangleCommandInput);

        // then
        assertThat(createNewRectangleCommand).isInstanceOf(CreateNewRectangleCommand.class);
    }

    @Test
    public void toCommandWithInputForFillEntireAreaShouldReturnFillEntireAreaCommand() {
        // given
        final String fillEntireAreaCommandInput = "B 1 1 o";
        // when
        final Command fillEntireAreaCommand = toCommand(fillEntireAreaCommandInput);

        // then
        assertThat(fillEntireAreaCommand).isInstanceOf(FillEntireAreaCommand.class);
    }

    @Test
    public void toCommandShouldThrowExceptionIfInputDoNotMatchAnyCommand() {
        // when
        final var exception = Assertions.assertThrows(InvalidCommandSyntaxException.class, () -> toCommand("DOMINIK"));


        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because command not found. Please check your input and try again.");
    }

}