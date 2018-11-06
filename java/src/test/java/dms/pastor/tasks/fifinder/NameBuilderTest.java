package dms.pastor.tasks.fifinder;

import org.junit.Test;

import static dms.pastor.tasks.fifinder.NameBuilder.nameBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 31/10/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NameBuilderTest {

    @Test
    public void shouldCreateNameWithRandomData() {

        // when
        final Name result = nameBuilder().build();

        // then
        assertThat(result).isNotNull();
        assertThat(result.getFirst()).isNotEmpty();
        assertThat(result.getMiddles()).isNotEmpty();
        assertThat(result.getLast()).isNotEmpty();
    }

    @Test
    public void shouldCreateNameWithSetValues() {
        // given
        final String first = generateString();
        final String middles = generateString();
        final String last = generateString();

        // when
        final Name result = nameBuilder()
                .first(first)
                .middles(middles)
                .last(last)
                .build();

        // then
        assertThat(result.getFirst()).isEqualTo(first);
        assertThat(result.getMiddles()).isEqualTo(middles);
        assertThat(result.getLast()).isEqualTo(last);
    }
}
