package dms.pastor.tools.removeDuplicatedLineInTextFile;

import dms.pastor.utils.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.io.File.separator;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DuplicateRemoverTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private final DuplicateRemover duplicateRemover = new DuplicateRemover();

    @Test
    public void shouldThrowIllegalArgumentExceptionForNullFilePathTest() {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        duplicateRemover.performTask(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForEmptyFilePathTest() {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        duplicateRemover.performTask(EMPTY_STRING);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileDoesNotExist() {
        // except
        exception.expect(IllegalArgumentException.class);

        // given
        final String nonExistingFile = System.getProperty("user.dir") +
            separator + "src" + separator + "main" +
            separator + "resources" +
            separator + "fileThatDoesNotExist.lol";
        // when
        duplicateRemover.performTask(nonExistingFile);

    }

    @Test
    public void acceptanceCriteria() {
        // given
        final String filePath = System.getProperty("user.dir") +
            separator + "src" + separator + "test" +
            separator + "resources" +
            separator + "fileWithDuplicatedLines.txt";
        final String randomLine = generateString(32);
        final String testLine = "test";
        String[] stringList = new String[]{randomLine, testLine, testLine};

        FileUtils.saveListToFile(stringList, filePath);

        // when
        duplicateRemover.performTask(filePath);

        // then
        final String result = FileUtils.readRawData(new File(filePath));

        assertThat(result).isEqualTo(randomLine + testLine);

        // cleanup
        final boolean deleted = new File(filePath).delete();
        assertThat(deleted).isTrue();

    }
}