package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.tube.data.DataUploader;
import dms.pastor.tools.trips.tube.data.DataWriter;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.TestConfig.TEST_BASE_PATH;
import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 03/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DataWriterTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void saveShouldThrowIllegalArgumentExceptionIfPathIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        DataWriter writer = new DataWriter();
        final TubeStation amershamTubeStation = new TubeStation("Amersham", null, null, null, null, true);
        List<TubeStation> tubeStations = Collections.singletonList(amershamTubeStation);

        // when
        writer.save(null, tubeStations);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test //TODO improve it as it is just prototype
    public void shouldSaveStationToFile() throws Exception {
        // given
        DataWriter writer = new DataWriter();
        final String path = TEST_BASE_PATH + File.separator + "station" + LocalDateTime.now().getNano() + ".test";

        // delete if exists
        final File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        file.deleteOnExit(); //comment this out if you need see file

        final TubeStation amershamTubeStation = new TubeStation("Amersham", VISITED, LocalDate.now(), LocalDate.now(), LocalDate.now(), true);
        final TubeStation cheshamTubeStation = TubeStation.passed("Pinner", LocalDate.now());
        List<TubeStation> tubeStations = new ArrayList<>();
        tubeStations.add(amershamTubeStation);
        tubeStations.add(cheshamTubeStation);

        // when
        writer.save(path, tubeStations);

        // then
        assertThat(new DataUploader().load(path).size()).isEqualTo(2);
    }

}
