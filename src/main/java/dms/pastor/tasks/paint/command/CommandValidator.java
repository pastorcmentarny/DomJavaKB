package dms.pastor.tasks.paint.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.StringUtils.WHITESPACE;
import static dms.pastor.utils.StringUtils.isStringNotEmpty;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
final class CommandValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandValidator.class);
    private static final String PARAMS_SPLITTER = WHITESPACE;

    private CommandValidator() {
    }

    static void validateCommandParams(Command command, String input) {
        if (command.isParamsRequired()) {
            command.setParamsIfValid(input.split(PARAMS_SPLITTER));
        }
    }

    static void validateParamsNumber(int paramsNumberRequired, String[] params) {
        if (params.length != paramsNumberRequired) {
            throw new InvalidCommandSyntaxException(format("number of params are invalid. Should be %d but was %d", paramsNumberRequired, params.length));
        }
    }

    static void validatePositiveLength(String param, String name) {
        try {
            final Integer integer = Integer.valueOf(param);
            validatePositiveNumber(integer);
        } catch (NumberFormatException nfe) {
            final String errorMessage = name + " is not a number";
            LOGGER.warn(errorMessage, nfe);
            throw new InvalidCommandSyntaxException(errorMessage, nfe);
        }
    }

    static void validateFillCharacter(String fillCharacter, String name) {
        if (!isStringNotEmpty(fillCharacter) || fillCharacter.length() != 1) {
            final String errorMessage = name + " is not a valid fill character";
            LOGGER.warn(errorMessage);
            throw new InvalidCommandSyntaxException(errorMessage);
        }
    }

    static void validatePositiveNumber(int integer) {
        if (integer < 0) {
            throw new InvalidCommandSyntaxException("number must be positive");
        }
    }

}
