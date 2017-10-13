package dms.pastor.tools.html;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tools.html.HTMLValidator.validateContentType;
import static dms.pastor.tools.html.HTMLValidator.validateUrl;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
 * Created 16/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HTMLValidatorTest {

    private static final String ERROR_MESSAGE = "WHOOPS!\n\tIt is not a html file.Unable to read non-html file.";
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        validateUrl(null);
    }

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsEmpty() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        validateUrl("");
    }

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsHasWhitespacesOnly() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        validateUrl("    ");
    }

    @Test
    public void validateUrlShouldValidateForMyHomepage() throws Exception {

        // when
        validateUrl("http://pastor.ovh.org");

        // then nothing happen if url is valid
    }

    @Test
    public void validateContentTypeShouldThrowIllegalArgumentExceptionIfContentTypeIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Value cannot be null");

        // when
        validateContentType(null);
    }

    @Test
    public void validateContentTypeShouldThrowIllegalArgumentExceptionIfContentTypeIsNotValid() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(ERROR_MESSAGE);

        // when
        validateContentType(generateString());
    }

    @Test
    public void validateContentTypeShouldValidateForTextHtmlContentType() throws Exception {
        // when
        validateContentType("text/html");

        // then nothing happen if valid
    }

}