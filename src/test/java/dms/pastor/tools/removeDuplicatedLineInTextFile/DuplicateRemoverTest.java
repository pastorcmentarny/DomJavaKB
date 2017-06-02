package dms.pastor.tools.removeDuplicatedLineInTextFile;

import dms.pastor.utils.FileTools;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.io.File.separator;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DuplicateRemoverTest {

    private final DuplicateRemover duplicateRemover = new DuplicateRemover();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionForNullFilePathTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        duplicateRemover.performTask(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForEmptyFilePathTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        duplicateRemover.performTask("");
    }


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileDoesNotExist() throws Exception {
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
    public void acceptanceCriteria() throws Exception {
        // given
        final String filePath = System.getProperty("user.dir") +
                separator + "src" + separator + "test" +
                separator + "resources" +
                separator + "fileWithDuplicatedLines.txt";
        final String randomLine = generateString(32);
        final String testLine = "test";
        String[] stringList = new String[]{randomLine, testLine, testLine};

        FileTools.saveListToFile(stringList, filePath);

        // when
        duplicateRemover.performTask(filePath);

        // then
        final String result = FileTools.readRawData(new File(filePath));

        assertThat(result).isEqualTo(randomLine + testLine);

        // cleanup
        final boolean deleted = new File(filePath).delete();
        assertThat(deleted).isTrue();

    }

    //                System.err.println("WHOOPS!\n\n\tI am not \"your brain waves\" reader(anyway how i can read from empty brain ?),so you need give me a bloody path to existing file or run program with path ,to do my job.\n\tFor example:\n\t java -jar \"C:\\dsSTUFF\\soft\\dev\\nanoBackup\\dist\\nanoBackup.jar\"  C:\\myAwesomeFile.txt");

}