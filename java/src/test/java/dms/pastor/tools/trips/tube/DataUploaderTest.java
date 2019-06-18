package dms.pastor.tools.trips.tube;


import dms.pastor.tools.trips.tube.data.DataUploader;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static dms.pastor.TestConfig.BASE_PATH;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
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
        String path = BASE_PATH + "transport/tube" + File.separator + "station.txt";

        // when
        dataUploader.load(path);
    }
}