package dms.pastor.tools.removeDuplicatedLineInTextFile;

import dms.pastor.utils.file.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.file.TextFileUtils.saveListToFile;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DuplicateRemoverTest {


    private final DuplicateRemover duplicateRemover = new DuplicateRemover();

    @Test
    public void shouldThrowIllegalArgumentExceptionForNullFilePathTest() {
        // when
        assertThrows(IllegalArgumentException.class, () -> duplicateRemover.performTask(null));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForEmptyFilePathTest() {
        // when
        assertThrows(IllegalArgumentException.class, () -> duplicateRemover.performTask(EMPTY_STRING));

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileDoesNotExist() {
        // given
        final String nonExistingFile = System.getProperty("user.dir") +
                separator + "src" + separator + "main" +
                separator + "resources" +
                separator + "fileThatDoesNotExist.lol";

        // when
        assertThrows(IllegalArgumentException.class, () -> duplicateRemover.performTask(nonExistingFile));


    }

    @Test
    public void acceptanceCriteria() throws Exception {
        // given
        final String filePath = File.createTempFile("fileWithDuplicatedLines", ".txt").getAbsolutePath();
        final String randomLine = generateString(32);
        final String testLine = "test";
        String[] stringList = new String[]{randomLine, testLine, testLine};

        saveListToFile(stringList, filePath);

        // when
        duplicateRemover.performTask(filePath);

        // then
        final String result = FileUtils.readRawData(filePath);

        assertThat(result).isEqualTo(randomLine + testLine);


    }
}