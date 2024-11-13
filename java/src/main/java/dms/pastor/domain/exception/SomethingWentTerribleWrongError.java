package dms.pastor.domain.exception;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">...</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">...</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">...</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">...</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">...</a>
 */
public class SomethingWentTerribleWrongError extends Error {

    public SomethingWentTerribleWrongError() {
        super("I screwed up something badly exception. It means I need fix setup or forgot to implement something.");
    }

    public SomethingWentTerribleWrongError(String message) {
        super("I screwed up something badly exception. It means I need fix setup or forgot to implement something. Problem was with " + message);
    }

    //https://www.owasp.org/index.php/Deserialization_Cheat_Sheet
    @Serial
    @SuppressWarnings({"FinalPrivateMethod", "unused"})
    private final void readObject(ObjectInputStream in) throws java.io.IOException {
        throw new java.io.IOException("Cannot be deserialized");
    }

    @Serial
    @SuppressWarnings({"FinalPrivateMethod", "unused"})
    private final void writeObject(ObjectOutputStream out) throws java.io.IOException {
        throw new java.io.IOException("Cannot be deserialized");
    }
}
