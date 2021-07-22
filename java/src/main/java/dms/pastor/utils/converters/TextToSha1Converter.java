package dms.pastor.utils.converters;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.isNull;

//In real word, I will use DigestUtils apache commons codec
public class TextToSha1Converter implements Converter<String, String> {

    // "%040x" to ensure it has 40 characters
    private static final String MESSAGE_LENGTH = "%040x";


    @Override
    public String convert(String from) {
        if (isNull(from)) {
            return null;
        }
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(from.getBytes(UTF_8));
            return String.format(MESSAGE_LENGTH, new BigInteger(1, crypt.digest()));
        } catch (NoSuchAlgorithmException algorithmException) {
            System.out.println(algorithmException.getMessage());
        }
        return EMPTY_STRING;
    }

}
