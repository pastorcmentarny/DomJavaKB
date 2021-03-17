package dms.pastor.tasks.manipulatedataapplication;

import dms.pastor.tasks.manipulatedataapplication.utls.Utils;
import dms.pastor.utils.PrintOutUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.TestConfig.BASE_PATH;
import static dms.pastor.tasks.manipulatedataapplication.utls.Utils.calculateAverageAge;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/11/2015
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class UtilsTest {

    private static List<String> getTextAsStringArray() {
        final List<String> text = new ArrayList<>();
        text.add("First line");
        text.add("Second line");
        text.add("Third line");
        text.add("Fourth line");
        text.add("Fifth line");
        return text;
    }

    @Test
    public void shouldLoadFileIntoArrayListOfStrings() throws IOException {
        // given
        String path = BASE_PATH + "5LinesOfCodeTest.txt";
        final List<String> sourceAsArray = Utils.loadFileToArrayOfStrings(path);

        // debug
        PrintOutUtils.printArray(sourceAsArray);

        // when
        List<String> result = getTextAsStringArray();

        // then
        assertThat(sourceAsArray).isEqualTo(result);
    }

    @Test
    public void shouldReturnZeroForCalculateAverageAgeTest() {
        // when
        final int result = calculateAverageAge(0, -1);

        // then
        assertThat(result).isZero();
    }
}