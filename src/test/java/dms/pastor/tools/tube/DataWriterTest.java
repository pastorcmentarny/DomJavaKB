package dms.pastor.tools.tube;

import dms.pastor.tools.tube.data.DataUploader;
import dms.pastor.tools.tube.data.DataWriter;
import dms.pastor.tools.tube.station.Station;
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
import static dms.pastor.tools.tube.station.Line.noLine;
import static dms.pastor.tools.tube.station.Status.VISITED;
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
        final Station amershamStation = new Station("Amersham", null, null, null, null);
        List<Station> stations = Collections.singletonList(amershamStation);

        // when
        writer.save(null, stations);
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

        final Station amershamStation = new Station("Amersham", VISITED, noLine(), LocalDate.now(), LocalDate.now());
        final Station cheshamStation = Station.passed("Pinner", noLine(), LocalDate.now());
        List<Station> stations = new ArrayList<>();
        stations.add(amershamStation);
        stations.add(cheshamStation);

        // when
        writer.save(path, stations);

        // then
        assertThat(new DataUploader().load(path).size()).isEqualTo(2);
    }

}
