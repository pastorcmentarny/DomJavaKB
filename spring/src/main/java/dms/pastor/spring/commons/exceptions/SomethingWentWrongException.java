package dms.pastor.spring.commons.exceptions;

import java.io.IOException;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This a generic exception use in exercises and examples which is a placeholder for specific exception that I wll normally used.
 */
@SuppressWarnings("WeakerAccess")
public class SomethingWentWrongException extends RuntimeException {
    private static final String ERROR = "Whoops! Something went wrong. %s. I apologize for any inconvenience caused by your mistake.";

    public SomethingWentWrongException(String message) {
        super(ERROR + message);
    }

    public SomethingWentWrongException(String message, Throwable blame) {
        super(ERROR + message, blame);
    }


    //https://www.owasp.org/index.php/Deserialization_Cheat_Sheet
    @SuppressWarnings("FinalPrivateMethod")
    private final void readObject() throws IOException {
        throw new IOException("Cannot be deserialized");
    }

    @SuppressWarnings("FinalPrivateMethod")
    private final void writeObject() throws IOException {
        throw new IOException("Cannot be serialized");
    }
}
