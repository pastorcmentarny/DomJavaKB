package dms.pastor.spring.commons;

import org.junit.jupiter.api.Test;

import static dms.pastor.spring.commons.QuirkyUtils.getJsonEncodingsAsMap;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 21.06.2020
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class QuirkyUtilsTest {

    @Test
    void getJsonEncodingsAsMapShouldGetMap() {
        // when
        final var result = getJsonEncodingsAsMap();

        // then
        assertThat(result).isNotEmpty();

        // debug
        System.out.println(result);
    }
}