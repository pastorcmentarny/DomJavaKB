package dms.pastor.tools.gibberishcheck;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CounterResultTest {

    @Test
    public void shouldGet50PercentIfHalfWordsIsCrap() {
        // given
        CounterResult counterResult = new CounterResult(1, 2);

        // when
        String result = counterResult.getPercentage();

        // then
        assertThat(result).isEqualTo("50");
    }

    @Test
    public void shouldReturnEmptyStringIFResultContainsInvalidData() {
        // given
        CounterResult counterResult = new CounterResult(1, 0);

        // when
        String result = counterResult.getPercentage();

        // then
        assertThat(result).isEmpty();
    }

}
