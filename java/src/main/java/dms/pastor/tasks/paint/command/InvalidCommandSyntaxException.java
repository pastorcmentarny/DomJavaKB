package dms.pastor.tasks.paint.command;

import static java.lang.String.format;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a> * Created 15/07/2017
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

