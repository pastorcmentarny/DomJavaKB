package dms.pastor.tasks.fifinder;

import org.junit.Test;

import static dms.pastor.tasks.fifinder.NameBuilder.nameBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 31/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class NameBuilderTest {

    @Test
    public void shouldCreateNameWithRandomData() throws Exception {

        // when
        final Name result = nameBuilder().build();

        // then
        assertThat(result).isNotNull();
        assertThat(result.getFirst()).isNotEmpty();
        assertThat(result.getMiddles()).isNotEmpty();
        assertThat(result.getLast()).isNotEmpty();
    }

    @Test
    public void shouldCreateNameWithSetValues() throws Exception {
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
