package dms.pastor.utils;

import dms.pastor.TestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.utils.FileUtils.saveListToFile;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/11/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FileUtilsAcceptanceTest {

    private static final int MAX_STRING_LENGTH = 20;
    private static final String FILE_PATH = TestConfig.PATH + "savesListToFile.txt";
    private static final Path PATH = Paths.get(FILE_PATH);

    @Before
    public void setUp() throws Exception {
        Files.deleteIfExists(PATH);
    }

    @After
    public void tearDown() {
        new File(FILE_PATH).deleteOnExit();
    }

    @Test
    public void savesStringListToFile() throws Exception {
        // given
        final List<String> stringArrayList = new ArrayList<>();
        final String text1 = generateString(MAX_STRING_LENGTH);
        final String text2 = generateString(MAX_STRING_LENGTH);
        final String text3 = generateString(MAX_STRING_LENGTH);

        stringArrayList.add(text1);
        stringArrayList.add(text2);
        stringArrayList.add(text3);

        // when
        saveListToFile(stringArrayList, FILE_PATH);

        // then
        assertThat(Files.exists(PATH)).isTrue();
        Files.lines(PATH).forEach(System.out::println);
        assertThat(Files.lines(PATH).count()).isEqualTo(stringArrayList.size());
    }

}
