package dms.pastor.tools.nanobackup.backup;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/06/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * tag-system-rules-for-junit-example
 */
public class StatisticTest {
    private final Statistic statistic = new Statistic();

    @Test
    public void shouldDisplayStatistic() {
        // given
        final String expectedResult = """
                --------
                Summary.
                --------
                Time needed: 0 days, 0 hours, 0 minutes and 0 seconds.
                BackupType: null
                Files copied: 0
                Errors: 0""";

        // when
        final String result = statistic.display();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldAddOneToErrorCount() {
        // given
        final String errorMessage = generateString();

        // when
        statistic.addErrorCount(errorMessage);

        // then
        assertThat(statistic.getError()).isEqualTo(1);
        assertThat(statistic.getErrorMsgList()).isEqualTo(errorMessage);
    }

    @Test
    public void addFileCopied() {
        // given
        final int filesNumber = 3;

        // when
        statistic.addFileCopied(filesNumber);

        // then
        assertThat(statistic.getFileCopied()).isEqualTo(filesNumber);
    }

    @Test
    public void shouldResetStats() {
        // given
        final int number = 3;
        statistic.addFileCopied(number);
        statistic.addErrorCount(generateString());

        // when
        statistic.resetStats();

        // then
        assertThat(statistic.getFileCopied()).isZero();
        assertThat(statistic.getError()).isZero();
    }
}