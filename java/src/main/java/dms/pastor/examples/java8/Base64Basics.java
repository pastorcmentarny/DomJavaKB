package dms.pastor.examples.java8;

import java.util.Base64;

/**
 * Note: Example is run from tests
 */
public final class Base64Basics {

    public static String encrypt(String source) {
        final byte[] encodedMessage = Base64.getEncoder().encode(source.getBytes());
        return new String(encodedMessage);
    }

    public static String decrypt(String source) {
        final byte[] decodedMessage = Base64.getDecoder().decode(source.getBytes());
        return new String(decodedMessage);
    }

}
