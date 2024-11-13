package dms.pastor.domain.exception;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class NotImplementYetException extends RuntimeException {

    private static final String CANNOT_BE_DESERIALIZED_MESSAGE = "Cannot be deserialized";

    public NotImplementYetException() {
        super("Not Implemented yet, so move your ass and implement this. I apologize for any inconvenience caused by my laziness");
    }

    public NotImplementYetException(String name) {
        super(name + "Not Implemented yet, so move your ass and implement this. I apologize for any inconvenience caused by my laziness");
    }


    //https://www.owasp.org/index.php/Deserialization_Cheat_Sheet
    @Serial
    @SuppressWarnings("FinalPrivateMethod")
    private final void readObject(ObjectInputStream in) throws IOException {
        throw new IOException(CANNOT_BE_DESERIALIZED_MESSAGE);
    }

    @Serial
    @SuppressWarnings("FinalPrivateMethod")
    private final void writeObject(ObjectOutputStream out) throws IOException {
        throw new IOException(CANNOT_BE_DESERIALIZED_MESSAGE);
    }
}
