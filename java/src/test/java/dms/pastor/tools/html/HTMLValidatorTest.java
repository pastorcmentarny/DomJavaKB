package dms.pastor.tools.html;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tools.html.HTMLValidator.validateContentType;
import static dms.pastor.tools.html.HTMLValidator.validateUrl;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

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


    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validateUrl(null);
        });
    }

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsEmpty() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validateUrl(EMPTY_STRING);
        });

    }

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsHasWhitespacesOnly() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validateUrl("    ");
        });

    }

    @Test
    public void validateUrlShouldValidateForMyHomepage() {
        // when
        validateUrl("http://pastor.ovh.org");

        // then nothing happen if url is valid
    }

    @Test
    public void validateContentTypeShouldThrowIllegalArgumentExceptionIfContentTypeIsNull() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> validateContentType(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value cannot be null.");


    }

    @Test
    public void validateContentTypeShouldThrowIllegalArgumentExceptionIfContentTypeIsNotValid() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> validateContentType(generateString()));

        // then
        assertThat(exception.getMessage()).isEqualTo(ERROR_MESSAGE);
    }

    @Test
    public void validateContentTypeShouldValidateForTextHtmlContentType() {
        // when
        validateContentType("text/html");

        // then nothing happen if valid
    }

}