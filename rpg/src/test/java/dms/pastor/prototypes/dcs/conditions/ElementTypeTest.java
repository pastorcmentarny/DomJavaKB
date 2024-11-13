package dms.pastor.prototypes.dcs.conditions;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 2017-06-15
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ElementTypeTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementTypeTest.class);

    @Test
    public void shouldReturnRandomElement() {
        // when
        final ElementType elementType = ElementType.getRandomElement();

        // then
        assertThat(elementType).isNotNull();

        // debug info
        LOGGER.debug(elementType.name());

    }
}