package dms.pastor.tools.tube;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static dms.pastor.TestConfig.BASE_PATH;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

public class DataUploaderTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void loadShouldThrowExceptionIfPathIsInvalid() {
        //expect
        exception.expect(IllegalArgumentException.class);

        // given
        DataUploader dataUploader = new DataUploader();

        // when
        dataUploader.load(generateString());
    }

    @Test
    public void shouldLoadStationsFromFile() {
        // given
        DataUploader dataUploader = new DataUploader();
        String path = BASE_PATH + "tube" + File.separator + "station.txt";

        // when
        dataUploader.load(path);
    }
}