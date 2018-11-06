package dms.pastor.tasks.paint.command;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InvalidCommandSyntaxException extends RuntimeException {

    private static final String INVALID_SYNTAX_ERROR_MESSAGE = "Invalid Syntax because %s. Please check your input and try again.";

    public InvalidCommandSyntaxException(String reason) {
        super(format(INVALID_SYNTAX_ERROR_MESSAGE, reason));
    }

    public InvalidCommandSyntaxException(String reason, Throwable throwable) {
        super(format(INVALID_SYNTAX_ERROR_MESSAGE, reason), throwable);
    }
}

