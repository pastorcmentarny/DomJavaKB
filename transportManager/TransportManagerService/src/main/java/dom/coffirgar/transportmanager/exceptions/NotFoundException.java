package dom.coffirgar.transportmanager.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Slf4j
@SuppressWarnings("WeakerAccess")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String what) {
        super("%s was not found.".formatted(what));
        log.error("%s was not found.".formatted(what));
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
