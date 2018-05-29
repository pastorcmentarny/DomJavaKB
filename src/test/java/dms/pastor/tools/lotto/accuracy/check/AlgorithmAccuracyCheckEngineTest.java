package dms.pastor.tools.lotto.accuracy.check;


import org.junit.Test;

import static dms.pastor.TestConfig.PATH;

public class AlgorithmAccuracyCheckEngineTest {
    private static final String filePath = PATH + "lotto-hotpicks-52-draws-history.csv";

    @Test
    public void shouldReturnNoAccuracyResult() {
/*        // given
        AlgorithmAccuracyCheckEngine accuracyCheckEngine = new AlgorithmAccuracyCheckEngine(filePath, new HotPicksFileUploader());

        // when
        final Result result = accuracyCheckEngine.analyse();

        System.out.println(result.toString());
        // then
        assertThat(result).isNotNull();*/

    }

    @Test
    public void shouldReturn50PercentAccuracyResult() {

    }

    @Test
    public void shouldReturn100PercentAccuracyResult() {

    }


    @Test
    public void shouldReturnPostiveBalanceResult() {

    }

    @Test //TODO hotpicks only
    public void shouldReturnPositiveBalance() {

    }

    @Test //TODO hotpicks only
    public void shouldReturnNegativeBalance() {

    }
}