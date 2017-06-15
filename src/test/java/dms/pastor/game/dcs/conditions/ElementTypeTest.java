package dms.pastor.game.dcs.conditions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 2017-06-15
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ElementTypeTest {

    @Test
    public void shouldReturnNumberThatIsUsedToSelectRandomElement() {
        // when
        final int randomElement = ElementType.getRandomElement();

        // then
        assertThat(randomElement).isGreaterThanOrEqualTo(0);
        assertThat(randomElement).isLessThan(ElementType.values().length);

    }
}