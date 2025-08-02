package dms.pastor.tools.trips.tube;


import dms.pastor.tools.trips.common.data.DataUploader;
import org.junit.jupiter.api.Test;

import static dms.pastor.tools.trips.tube.data.DataOperations.STATION_PATH;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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