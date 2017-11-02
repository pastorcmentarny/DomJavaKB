package dms.pastor.tools.tube;


import org.junit.Test;

import java.io.File;

import static dms.pastor.TestConfig.BASE_PATH;

public class DataUploaderTest {

    @Test
    public void shouldLoadStationsFromFile(){
        // given
        DataUploader dataUploader = new DataUploader();
        String path = BASE_PATH + "tube" + File.separator + "station.txt";

        // when
        dataUploader.load(path);
    }
}