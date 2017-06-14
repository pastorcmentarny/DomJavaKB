package dms.pastor.domain.exception;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class NotImplementYetException extends RuntimeException {

    public NotImplementYetException() {
        super("Not Implemented yet, so move your ass and implement this. I apologize for any inconvenience caused by my laziness");
    }

    //https://www.owasp.org/index.php/Deserialization_Cheat_Sheet
    @SuppressWarnings("FinalPrivateMethod")
    private final void readObject(ObjectInputStream in) throws IOException {
        throw new IOException("Cannot be deserialized");
    }

    @SuppressWarnings("FinalPrivateMethod")
    private final void writeObject(ObjectOutputStream out) throws IOException {
        throw new IOException("Cannot be deserialized");
    }
}
