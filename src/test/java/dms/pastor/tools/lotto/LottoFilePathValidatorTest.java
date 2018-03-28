package dms.pastor.tools.lotto;

import dms.pastor.utils.FileTools;
import dms.pastor.utils.ValidatorUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.junit.Assert.fail;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class LottoFilePathValidatorTest {
    private static final String USER_DIRECTORY = "user.dir";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        LottoFilePathValidator.validateFilePath(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathToFileIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        LottoFilePathValidator.validateFilePath(EMPTY_STRING);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathToFileIsInvalid() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        LottoFilePathValidator.validateFilePath(generateString(128));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathToFileIsDirectory() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        LottoFilePathValidator.validateFilePath(System.getProperty(USER_DIRECTORY));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileTypeIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Path cannot be null.");

        // given
        generateFile(null);

        // when

        LottoFilePathValidator.validateFilePath(null);
    }

/*    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileTypeIsNotACsvFile() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("It must be a csv file.");

        // when
        hotPicksFileUploader.loadDrawHistoryFile(EMPTY_TEXT_FILE);
    }*/

/*    @Test
    public void shouldReturnEmptyListIfLineIsNull() throws Exception {
        // given
        String[] lines = new String[]{null};
        generateFile(EMPTY_CSV_FILE, lines);

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE);

        // then
        assertThat(hotPickDrawList).isNotNull();
        assertThat(hotPickDrawList.size()).isEqualTo(0);

    }*/

    //TODO move to File utils
    public static void generateFile(String path) throws IOException {
        generateFile(path, null);
    }

    //TODO move to File utils
    public static void generateFile(String path, String[] lines) throws IOException {
        ValidatorUtils.validateIfNotNull(path, "Path");
        File file = new File(path);
        if (lines != null) {
            FileTools.saveListToFile(lines, path);
        } else {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                fail("File wasn't created");
            }
        }
    }


}