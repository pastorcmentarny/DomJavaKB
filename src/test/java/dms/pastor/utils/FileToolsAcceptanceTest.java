package dms.pastor.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static dms.pastor.TestConfig.PATH;
import static dms.pastor.utils.FileTools.saveListToFile;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/11/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FileToolsAcceptanceTest {

    private static final int MAX_STRING_LENGTH = 20;
    private static final String FILE_PATH = PATH + "savesListToFile.txt";
    private static final Path path = Paths.get(FILE_PATH);

    @Before
    public void setUp() throws Exception {
        Files.deleteIfExists(path);
    }

    @After
    public void tearDown() throws Exception {
        new File(FILE_PATH).deleteOnExit();
    }

    @Test
    public void savesStringListToFile() throws Exception {
        // given
        final ArrayList<String> stringArrayList = new ArrayList<>();
        final String text1 = generateString(MAX_STRING_LENGTH);
        final String text2 = generateString(MAX_STRING_LENGTH);
        final String text3 = generateString(MAX_STRING_LENGTH);

        stringArrayList.add(text1);
        stringArrayList.add(text2);
        stringArrayList.add(text3);

        // when
        saveListToFile(stringArrayList, FILE_PATH);

        // then
        assertThat(Files.exists(path)).isTrue();
        Files.lines(path).forEach(System.out::println);
        assertThat(Files.lines(path).count()).isEqualTo(stringArrayList.size());
    }

}
