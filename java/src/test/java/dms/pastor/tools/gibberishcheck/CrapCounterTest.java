package dms.pastor.tools.gibberishcheck;


import org.junit.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class CrapCounterTest {
    private CrapCounter counter;
    private Data data;

    @Test
    public void shouldReturnEmptyResult() {
        // given
        data = new Data(emptyList(), emptyList());
        counter = new CrapCounter(data);


        // when
        CounterResult counterResult = counter.count();
        // then
        assertThat(counterResult).isEqualTo(CounterResult.noResult());
    }

    @Test
    public void getPercentageShouldReturn100Percent() {
        // given
        var crapWordList = List.of("word");
        var jobWordList = List.of("word");

        data = new Data(crapWordList, jobWordList);
        counter = new CrapCounter(data);

        var expectedResult = new CrapCounter(data);

        // when
        CounterResult counterResult = counter.count();

        // then
        assertThat(counterResult.getPercentageAsString()).isEqualTo("100");
    }

    @Test
    public void getPercentageShouldReturn50Percent() {
        // given
        var crapWordList = List.of("word");
        var jobWordList = List.of("other", "word");

        data = new Data(crapWordList, jobWordList);
        counter = new CrapCounter(data);

        // when
        CounterResult counterResult = counter.count();

        // then
        assertThat(counterResult.getPercentageAsString()).isEqualTo("50");
    }

    @Test
    public void getPercentageShouldReturn33Percent() {
        // given
        var crapWordList = List.of("word");
        var jobWordList = List.of("another", "other", "word");

        data = new Data(crapWordList, jobWordList);
        counter = new CrapCounter(data);

        // when
        CounterResult counterResult = counter.count();

        // then
        assertThat(counterResult.getPercentageAsString()).isEqualTo("33");
    }

    @Test
    public void getPercentageShouldReturn0Percent() {
        // given
        var crapWordList = List.of("crap");
        var jobWordList = List.of("great", "job", "offer");

        data = new Data(crapWordList, jobWordList);
        counter = new CrapCounter(data);

        // when
        CounterResult counterResult = counter.count();

        // then
        assertThat(counterResult.getPercentageAsString()).isEqualTo("0");
    }
}