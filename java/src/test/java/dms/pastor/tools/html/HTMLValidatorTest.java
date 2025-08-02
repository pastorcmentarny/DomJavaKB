package dms.pastor.tools.html;

import org.junit.jupiter.api.Test;

import static dms.pastor.tools.html.HTMLValidator.validateContentType;
import static dms.pastor.tools.html.HTMLValidator.validateUrl;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 16/03/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class HTMLValidatorTest {

    private static final String ERROR_MESSAGE = "WHOOPS!\n\tIt is not a html file.Unable to read non-html file.";

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsNull() {
        assertThrows(IllegalArgumentException.class, () -> validateUrl(null));
    }

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsEmpty() {
        // when
        assertThrows(IllegalArgumentException.class, () -> validateUrl(EMPTY_STRING));

    }

    @Test
    public void validateUrlShouldThrowIllegalArgumentExceptionIfUrlIsHasWhitespacesOnly() {
        // when
        assertThrows(IllegalArgumentException.class, () -> validateUrl("    "));

    }

    @Test
    public void validateUrlShouldValidateForMyHomepage() {
        // when
        validateUrl("https://dominiksymonowicz.com/");

        // then nothing happen if url is valid
    }

    @Test
    public void validateContentTypeShouldThrowIllegalArgumentExceptionIfContentTypeIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateContentType(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Value cannot be null.");


    }

    @Test
    public void validateContentTypeShouldThrowIllegalArgumentExceptionIfContentTypeIsNotValid() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validateContentType(generateString()));

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