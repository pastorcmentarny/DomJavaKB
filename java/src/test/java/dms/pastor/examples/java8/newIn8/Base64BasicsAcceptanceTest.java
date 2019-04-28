package dms.pastor.examples.java8.newIn8;

import org.junit.Test;

import java.nio.file.FileSystems;
import java.util.Base64;

import static dms.pastor.examples.java8.Base64Basics.*;


/**
 * Author Dominik Symonowicz
 * Created 14/12/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Base64BasicsAcceptanceTest {

    @Test
    public void base64Example() {
        System.out.println("...START...");

        String originalMessage = loadFile(FileSystems.getDefault().getPath("C:\\file.txt"));
        System.out.println("... ... O MESSAGE: " + originalMessage);
        String encrypted = encrypt(originalMessage);
        System.out.println("... ... E MESSAGE: " + encrypted);
        final String decrypted = decrypt(encrypted);
        System.out.println("... ... D MESSAGE: " + decrypted);

        String source = "aGFydGxpbms6c2VjcmV0";
        final byte[] decodedMessage = Base64.getDecoder().decode(source.getBytes());
        System.out.println(new String(decodedMessage));
    }


}