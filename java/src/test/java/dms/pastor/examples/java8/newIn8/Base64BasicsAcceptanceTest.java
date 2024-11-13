package dms.pastor.examples.java8.newIn8;

import org.junit.jupiter.api.Test;

import java.util.Base64;

import static dms.pastor.examples.java8.Base64Basics.decrypt;
import static dms.pastor.examples.java8.Base64Basics.encrypt;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Author Dominik Symonowicz
 * Created 14/12/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Base64BasicsAcceptanceTest {

    @Test
    public void base64Example() {

        String originalMessage = "RG9vb21pbmlr";
        System.out.println("... ... O MESSAGE: " + originalMessage);

        String encrypted = encrypt(originalMessage);
        System.out.println("... ... E MESSAGE: " + encrypted);

        final String decrypted = decrypt(encrypted);
        System.out.println("... ... D MESSAGE: " + decrypted);

        final byte[] decodedMessage = Base64.getDecoder().decode(originalMessage.getBytes());
        assertThat("Dooominik").isEqualTo(new String(decodedMessage));

    }


}