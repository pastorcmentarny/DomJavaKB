package dms.pastor.tasks.manipulatedataapplication;

import dms.pastor.tasks.manipulatedataapplication.utls.Utils;
import dms.pastor.utils.PrintOutUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static dms.pastor.TestConfig.BASE_PATH;
import static dms.pastor.tasks.manipulatedataapplication.utls.Utils.calculateAverageAge;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 14/11/2015
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class UtilsTest {

    private static ArrayList<String> getTextAsStringArray() {
        final ArrayList<String> text = new ArrayList<>();
        text.add("First line");
        text.add("Second line");
        text.add("Third line");
        text.add("Fourth line");
        text.add("Fifth line");
        return text;
    }

    @Test
    public void shouldLoadFileIntoArrayListOfStrings() throws IOException {
        String path = BASE_PATH + "5LinesOfCodeTest.txt";
        final ArrayList<String> sourceAsArray = Utils.loadFileToArrayOfStrings(path);
        PrintOutUtils.printArray(sourceAsArray);
        ArrayList<String> result = getTextAsStringArray();
        Assert.assertThat(sourceAsArray, is(result));
    }

    @Test
    public void shouldReturnZeroForCalculateAverageAge() {
        // when
        final int result = calculateAverageAge(0, -1);

        // then
        Assert.assertThat(result, is(0));
    }
}