package dms.pastor.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static dms.pastor.TestConfig.EMPTY_STRING_ARRAY;
import static dms.pastor.TestConfig.PATH;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.file.FileUtils.*;
import static dms.pastor.utils.file.TextFileUtils.loadFileFromResourceAsString;
import static dms.pastor.utils.file.TextFileUtils.saveListToFile;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">https://dominiksymonowicz.com/welcome</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">https://dominiksymonowicz.blogspot.co.uk</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">https://github.com/pastorcmentarny</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">https://play.google.com/store/apps/developer?id=Dominik+Symonowicz</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">https://www.linkedin.com/in/dominik-symonowicz</a>
 */
public class FileUtilsTest {

    private static final String TEST_FILE = "test/test.txt";
    private static final String LOCK_FILE = "program.lock";
    private static final String DEFAULT_PATH = PATH + TEST_FILE;


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @AfterEach
    public void tearDown() {
        new File(TEST_FILE).delete();
        new File(LOCK_FILE).delete();

    }


    @Test
    public void shouldThrowIllegalArgumentExceptionIfPathIsNullInReadRawDataTest() {
        // when
        assertThrows(IllegalArgumentException.class, () -> readRawData(null));

    }

    @Test
    public void shouldThrowExceptionIfFileNotExistsInRawDataReadTest() {
        // when
        assertThrows(IllegalArgumentException.class, () -> readRawData(EMPTY_STRING));

    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldRawDataReadTest() {
        // given
        final String expected = "This is a default test filetesttest";

        // when
        final String rawData = readRawData(DEFAULT_PATH);

        // when
        assertThat(rawData).isEqualToIgnoringCase(expected);
    }

    @Test
    public void shouldLockFileTest() {
        // given
        clean();

        if (new File(LOCK_FILE).exists()) {
            final boolean deleted = new File(LOCK_FILE).delete();
            assertThat(deleted).isTrue();
        }
        assertThat(new File(LOCK_FILE).exists()).isFalse();

        // when
        lock();

        // then
        assertThat(new File(LOCK_FILE).exists()).isTrue();

        clean();
    }

    @Test
    public void shouldUnlockFileTest() {
        // given
        clean();
        if (!new File(LOCK_FILE).exists()) {
            lock();
        }
        boolean isLockExists = new File(LOCK_FILE).exists();
        assertThat(isLockExists).isTrue();

        // when
        unlockFile();

        // then
        isLockExists = new File(LOCK_FILE).exists();
        assertThat(isLockExists).isFalse();
        clean();
    }

    @Test
    public void shouldListToFileTest() throws Exception {
        // given
        final String[] stringList = new String[]{"1", "2", "3"};
        final File file = File.createTempFile("test", ".txt");
        final String filePath = file.getAbsolutePath();

        // when
        final boolean isFileSaved = saveListToFile(stringList, filePath);

        // then
        assertThat(isFileSaved).isTrue();
        assertThat(file.exists()).isTrue();

        final String result = readRawData(filePath);
        assertThat(result).isEqualTo("123");
    }

    @Test
    public void shouldReturnTrueWhenAllFilesExists() {
        // given
        String[] files = new String[]{DEFAULT_PATH, DEFAULT_PATH};

        // when
        final boolean exists = isFilesExists(files);

        // then
        assertThat(exists).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenOneOfFilesDoesNotExists() {
        // given
        String[] files = new String[]{DEFAULT_PATH, generateString(), DEFAULT_PATH};

        // when
        final boolean exists = isFilesExists(files);

        // then
        assertThat(exists).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenListIsNull() {
        // when
        final boolean exists = isFilesExists(null);

        // then
        assertThat(exists).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenListIsEmpty() {
        // when
        final boolean exists = isFilesExists(EMPTY_STRING_ARRAY);

        // then
        assertThat(exists).isFalse();
    }

    @Test
    public void shouldLoadExampleTxtFromResourceAsString() {
        // given
        final var path = "test/test.txt";

        // when
        final var result = loadFileFromResourceAsString(path);

        // then
        assertThat(result).startsWith("This is a default test file");
        assertThat(result).endsWith("test");

    }

    @Test
    public void loadFileFromResourceAsStringShouldThrowExceptionIfPathIsNull() {
        // when
        assertThrows(IllegalArgumentException.class, () -> loadFileFromResourceAsString(null));
    }

    @Test
    public void loadFileFromResourceAsStringShouldThrowExceptionIfPathIsInvalid() {
        // when
        assertThrows(IllegalArgumentException.class, () -> loadFileFromResourceAsString("invalid path"));

    }

    @Test
    public void shouldThrowExceptionIfPathIsNull() {
        // when
        assertThrows(IllegalArgumentException.class, () -> getPathToResource(null));
    }

    @Test
    public void shouldThrowExceptionIfPathIsInvalid() {
        // when
        assertThrows(IllegalArgumentException.class, () -> getPathToResource(generateString(32)));
    }

    @Test
    public void shouldGetPathToResource() {
        // given
        final var pathToResource = "test/test.txt";

        // when
        final var path = getPathToResource(pathToResource);

        // then
        assertThat(path).isNotNull();

        // debug
        System.out.println(path);
    }

    private static void clean() {
        var result = new File(TEST_FILE).delete();
        System.out.println(TEST_FILE + " exists? " + result);
        result = new File(LOCK_FILE).delete();
        System.out.println(TEST_FILE + " exists? " + result);

    }

}