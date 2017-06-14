package dms.pastor.utils;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static dms.pastor.TestConfig.EMPTY_STRING_ARRAY;
import static dms.pastor.TestConfig.PATH;
import static dms.pastor.utils.FileTools.*;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FileToolsTest {
    private static final String TEST_FILE = "test.txt";
    private static final String LOCK_FILE = "program.lock";
    private static final String DEFAULT_PATH = PATH + TEST_FILE;
    private static final String EMPTY_STRING = "";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @After
    public void tearDown() throws Exception {
        new File(TEST_FILE).delete();
        new File(LOCK_FILE).delete();

    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test
    public void isFileValidShouldReturnFalseWhenFilePathIsNull() throws Exception {
        // when
        final boolean result = isFileValid(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isFileValidShouldReturnFalseIfFilePathIsEmptyTest() throws Exception {
        // when
        final boolean result = isFileValid(EMPTY_STRING);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldThrowExceptionIfUnableToAccessFileTest() throws Exception {
        // when
        final boolean result = isFileValid("text.txt");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueForExistingFileTest() throws Exception {
        // when
        final boolean result = isFileValid(DEFAULT_PATH);

        // then
        assertThat(result).isTrue();
    }

    @SuppressWarnings("ConstantConditions") // part of the test
    @Test
    public void shouldThrowIllegalArgumentExceptionIfPathIsNullInReadRawDataTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        readRawData(null);
    }

    @Test
    public void shouldThrowExceptionIfFileNotExistsInRawDataReadTest() throws Exception {
        // except
        exception.expect(IllegalArgumentException.class);

        // when
        readRawData(new File(EMPTY_STRING));
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldRawDataReadTest() throws Exception {
        // given
        final String expected = "This is a default test filetesttest";
        // when
        final String rawData = readRawData(new File(DEFAULT_PATH));

        // when
        assertThat(rawData).isEqualToIgnoringCase(expected);
    }

    @Test
    public void shouldLockFileTest() throws Exception {
        // given
        if (new File(LOCK_FILE).exists()) {
            final boolean deleted = new File(LOCK_FILE).delete();
            assertThat(deleted).isTrue();
        }
        assertThat(new File(LOCK_FILE).exists()).isFalse();

        // when
        lock();

        // then
        assertThat(new File(LOCK_FILE).exists()).isTrue();
    }

    @Test
    @Ignore//TODO fix it
    public void shouldUnlockFileTest() throws Exception {
        // given
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
    }

    @Test
    public void shouldListToFileTest() throws Exception {
        // given
        final String[] stringList = new String[]{"1", "2", "3"};

        // when
        final boolean isFileSaved = saveListToFile(stringList, TEST_FILE);

        // then
        assertThat(isFileSaved).isTrue();
        final File file = new File(TEST_FILE);
        assertThat(file.exists()).isTrue();

        final String result = readRawData(file);
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

    @SuppressWarnings("ConstantConditions") // part of the test
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

}