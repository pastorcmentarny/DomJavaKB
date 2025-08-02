package dms.pastor.tasks.fifinder;

import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.fifinder.NameBuilder.nameBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 31/10/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class NameBuilderTest {

    @Test
    public void shouldCreateNameWithRandomData() {
        // when
        final Name result = nameBuilder().build();

        // then
        assertThat(result).isNotNull();
        assertThat(result.first()).isNotEmpty();
        assertThat(result.middles()).isNotEmpty();
        assertThat(result.last()).isNotEmpty();
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
        assertThat(result.first()).isEqualTo(first);
        assertThat(result.middles()).isEqualTo(middles);
        assertThat(result.last()).isEqualTo(last);
    }
}
