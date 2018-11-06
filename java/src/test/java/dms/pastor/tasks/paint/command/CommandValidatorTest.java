package dms.pastor.tasks.paint.command;

import org.junit.Test;

import static dms.pastor.tasks.paint.command.CommandValidator.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
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
        // expect
        exception.expect(InvalidCommandSyntaxException.class);

        // given
        final Command command = new CreateCanvasCommand();

        // when
        validateCommandParams(command, command.getSyntax());
    }

    @Test
    public void validateCommandShouldNotValidateIfParamsAreRequiredAndProvidedButInvalid() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);

        // given
        final Command command = new CreateCanvasCommand();
        final String input = command.getSyntax() + " X 1";

        // when
        validateCommandParams(command, input);
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

        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number of params are invalid. Should be " + paramsNumberRequired + " but was " + params.length + ". Please check your input and try again.");

        // when
        validateParamsNumber(paramsNumberRequired, params);
    }

    @Test
    public void validatePositiveNumberWillThrowExceptionForNegativeNumber() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because number must be positive. Please check your input and try again.");

        // given
        final int negativeNumber = -1;

        // when
        validatePositiveNumber(negativeNumber);
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

        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because " + NAME + " is not a number. Please check your input and try again.");

        // when
        validatePositiveLength(param, NAME);
    }

    @Test
    public void validateFillCharacterShouldThrowExceptionIfFillCharacterIsNull() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because " + NAME + " is not a valid fill character. Please check your input and try again.");

        // when
        validateFillCharacter(null, NAME);
    }

    @Test
    public void validateFillCharacterShouldThrowExceptionIfFillCharacterIsEmpty() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because " + NAME + " is not a valid fill character. Please check your input and try again.");

        // when
        validateFillCharacter(EMPTY_STRING, NAME);
    }

    @Test
    public void validateFillCharacterShouldThrowExceptionIfFillCharacterHasMoreThanOneCharacter() {
        // expect
        exception.expect(InvalidCommandSyntaxException.class);
        exception.expectMessage("Invalid Syntax because " + NAME + " is not a valid fill character. Please check your input and try again.");

        // when
        validateFillCharacter("ufo", NAME);
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
