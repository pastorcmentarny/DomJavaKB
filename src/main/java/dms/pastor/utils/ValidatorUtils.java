package dms.pastor.utils;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Some utils to help you validate data
 */
public class ValidatorUtils {

    private ValidatorUtils() {
    }

    static boolean validateNotNullProperties(Object... properties) {
        for (Object property : properties) {
            if (property == null) {
                return false;
            }
        }
        return true;
    }

    static void validateNotNullPropertiesWithCustomMessage(Object[] properties, String errorMessage) {
        for (Object property : properties) {
            if (property == null) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    static void validateNotNullPropertiesWithCustomMessagesPerProperty(Object[][] properties) {
        for (Object[] property : properties) {
            if (property[0] == null) {
                throw new IllegalArgumentException(property[1].toString());
            }
        }
    }

    public static boolean validateThatObjectCanBeSerialized(Object object) {

        try (OutputStream sink = new ByteArrayOutputStream();
             ObjectOutputStream stream = new ObjectOutputStream(sink)) {
            stream.writeObject(object);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
