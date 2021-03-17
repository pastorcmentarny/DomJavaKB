package dms.pastor.tools.nanobackup.tools;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 21/04/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class TaskUtilsAcceptanceTest {

    @Test
    public void removeDuplicateLines() {
        // given
        String line1 = generateString();
        String line2 = generateString();
        String line3 = generateString();
        final String[] lineWithDuplicates = Arrays.asList(line1, line1, line2, line3).toArray(new String[0]);
        final String[] expectedResult = Arrays.asList(line1, line2, line3).toArray(new String[0]);

        // when
        final String[] result = TaskUtils.removeDuplicateLines(lineWithDuplicates);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}