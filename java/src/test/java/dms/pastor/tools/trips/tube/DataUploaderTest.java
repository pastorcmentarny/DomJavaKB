package dms.pastor.tools.trips.tube;


import dms.pastor.tools.trips.tube.data.DataUploader;
import org.junit.jupiter.api.Test;

import static dms.pastor.tools.trips.tube.data.DataOperations.STATION_PATH;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DataUploaderTest {


    @Test
    public void shouldLoadStationsFromFile() {
        // given
        DataUploader dataUploader = new DataUploader();
        // when
        dataUploader.load(STATION_PATH);
    }
}