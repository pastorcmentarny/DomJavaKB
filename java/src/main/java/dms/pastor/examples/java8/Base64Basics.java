package dms.pastor.examples.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    //TODO move to FileUtils
    public static String loadFile(Path path) {
        StringBuilder builder = new StringBuilder();
        try {
            Files.lines(path).forEach(line -> builder.append(line).append("\n"));
        } catch (IOException e) {
            return "Something went wrong";
        }
        return builder.toString();
    }


}
