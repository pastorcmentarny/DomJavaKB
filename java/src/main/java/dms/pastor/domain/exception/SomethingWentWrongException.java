package dms.pastor.domain.exception;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">...</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">...</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">...</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">...</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">...</a>
 * <p>
 * This a generic exception use in  exercises and examples which is a placeholder for specific exception that I wll normally used.
 */
@SuppressWarnings("WeakerAccess")
public class SomethingWentWrongException extends RuntimeException {

    private static final String ERROR = "Whoops! Something went wrong. %s. I apologize for any inconvenience caused by your mistake.";

    public SomethingWentWrongException() {
        super(format(ERROR, "I didn't bother to specify what"));
    }

    public SomethingWentWrongException(String whatWentWrongMessage) {
        super(format(ERROR, whatWentWrongMessage));
    }

    public SomethingWentWrongException(String whatWentWrongMessage, Throwable cause) {
        super(format(ERROR, whatWentWrongMessage), cause);
    }

    //https://www.owasp.org/index.php/Deserialization_Cheat_Sheet
    @Serial
    @SuppressWarnings({"FinalPrivateMethod", "unused"})
    private final void readObject(ObjectInputStream in) throws IOException {
        throw new IOException("Cannot be deserialized");
    }

    @Serial
    @SuppressWarnings({"FinalPrivateMethod", "unused"})
    private final void writeObject(ObjectOutputStream out) throws IOException {
        throw new IOException("Cannot be serialized");
    }
}
