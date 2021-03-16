package dms.pastor.tools.job.gibberishcheck;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CounterResultTest {

    @Test
    public void shouldGet50PercentIfHalfWordsIsCrap() {
        // given
        CounterResult counterResult = new CounterResult(1, 2);

        // when
        String result = counterResult.getPercentageAsString();

        // then
        assertThat(result).isEqualTo("50");
    }

    @Test
    public void shouldReturnEmptyStringIFResultContainsInvalidData() {
        // given
        CounterResult counterResult = new CounterResult(1, 0);

        // when
        String result = counterResult.getPercentageAsString();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void getPercentageAcceptanceTest() {
        // given
        CounterResult counterResult = new CounterResult(1, 2);

        // when
        int result = counterResult.getPercentage();

        // then
        assertThat(result).isEqualTo(50);
    }


}
