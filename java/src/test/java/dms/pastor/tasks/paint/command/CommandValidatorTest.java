package dms.pastor.tasks.paint.command;

import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.paint.command.CommandValidator.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CommandValidatorTest extends AbstractCommandTest {
    private static final String NAME = "name";

    @Test
    public void validateCommandShouldValidateIfParamsAreNotRequired() {
        // given
        final Command command = new QuitCommand();
        // when
        validateCommandParams(command, command.getSyntax());

        // then no exception should be thrown
    }

    @Test
    public void validateCommandShouldNotValidateIfParamsAreRequiredButNotProvided() {
        // given
        final Command command = new CreateCanvasCommand();

        // when
        assertThrows(InvalidCommandSyntaxException.class, () -> validateCommandParams(command, command.getSyntax()));

    }

    @Test
    public void validateCommandShouldNotValidateIfParamsAreRequiredAndProvidedButInvalid() {
        // given
        final Command command = new CreateCanvasCommand();
        final String input = command.getSyntax() + " X 1";

        // when
        assertThrows(InvalidCommandSyntaxException.class, () -> validateCommandParams(command, input));
    }

    @Test
    public void validateCommandShouldValidateIfParamsAreRequiredProvidedAndValid() {

        // given
        final Command command = new CreateCanvasCommand();
        final String input = command.getSyntax() + " 2 3";

        // when
        validateCommandParams(command, input);

        // then no exception should be thrown
    }

    @Test
    public void validateParamsNumberShouldThrowExceptionIfNumberOfRequiredParamsIsDifferentThanActualParamsList() {
        // given
        final String[] params = {"Param1", "Param2"};
        final int paramsNumberRequired = 3;

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> validateParamsNumber(paramsNumberRequired, params));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because number of params are invalid. Should be " + paramsNumberRequired + " but was " + params.length + ". Please check your input and try again.");
    }

    @Test
    public void validatePositiveNumberWillThrowExceptionForNegativeNumber() {

        // given
        final int negativeNumber = -1;

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> validatePositiveNumber(negativeNumber));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because number must be positive. Please check your input and try again.");
    }

    @Test
    public void validatePositiveNumberShouldValidateForZero() {
        // when
        validatePositiveNumber(0);

        // then no exception is thrown if number is valid
    }

    @Test
    public void validatePositiveNumberShouldValidateForPositiveNumber() {
        // when
        final int positiveNumber = 1;
        validatePositiveNumber(positiveNumber);

        // then no exception is thrown if number is valid
    }

    @Test
    public void validatePositiveLengthShouldValidate() {
        // given
        final String param = "1";

        // when
        validatePositiveLength(param, NAME);

        // then no exception is thrown if number is valid
    }

    @Test
    public void validatePositiveLengthShouldThrowExceptionIfParamIsNotANumber() {
        // given
        final String param = "notANumber";

        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> validatePositiveLength(param, NAME));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because " + NAME + " is not a number. Please check your input and try again.");
    }

    @Test
    public void validateFillCharacterShouldThrowExceptionIfFillCharacterIsNull() {
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> validateFillCharacter(null, NAME));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because " + NAME + " is not a valid fill character. Please check your input and try again.");
    }

    @Test
    public void validateFillCharacterShouldThrowExceptionIfFillCharacterIsEmpty() {
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> validateFillCharacter(EMPTY_STRING, NAME));

        // then
        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because " + NAME + " is not a valid fill character. Please check your input and try again.");
    }

    @Test
    public void validateFillCharacterShouldThrowExceptionIfFillCharacterHasMoreThanOneCharacter() {
        // when
        final var exception = assertThrows(InvalidCommandSyntaxException.class, () -> validateFillCharacter("ufo", NAME));

        assertThat(exception.getMessage()).isEqualTo("Invalid Syntax because " + NAME + " is not a valid fill character. Please check your input and try again.");
    }

    @Test
    public void validateFillCharacterShouldValidateForOneCharacter() {
        // given
        final String fillCharacter = "D";
        // when
        validateFillCharacter(fillCharacter, NAME);

        // then no exception is thrown
    }

}
